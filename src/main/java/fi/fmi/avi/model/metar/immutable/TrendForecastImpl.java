package fi.fmi.avi.model.metar.immutable;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.inferred.freebuilder.FreeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fi.fmi.avi.model.CloudForecast;
import fi.fmi.avi.model.NumericMeasure;
import fi.fmi.avi.model.Weather;
import fi.fmi.avi.model.immutable.CloudForecastImpl;
import fi.fmi.avi.model.immutable.NumericMeasureImpl;
import fi.fmi.avi.model.immutable.WeatherImpl;
import fi.fmi.avi.model.metar.TrendForecast;
import fi.fmi.avi.model.metar.TrendForecastSurfaceWind;

/**
 * Created by rinne on 13/04/2018.
 */
@FreeBuilder
@JsonDeserialize(builder = TrendForecastImpl.Builder.class)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class TrendForecastImpl implements TrendForecast, Serializable {

    public static TrendForecastImpl immutableCopyOf(final TrendForecast trendForecast) {
        checkNotNull(trendForecast);
        if (trendForecast instanceof TrendForecastImpl) {
            return (TrendForecastImpl) trendForecast;
        } else {
            return Builder.from(trendForecast).build();
        }
    }

    public static Optional<TrendForecastImpl> immutableCopyOf(final Optional<TrendForecast> trendForecast) {
        checkNotNull(trendForecast);
        return trendForecast.map(TrendForecastImpl::immutableCopyOf);
    }

    public abstract Builder toBuilder();

    public static class Builder extends TrendForecastImpl_Builder {

        public Builder() {
            setCeilingAndVisibilityOk(false);
            setNoSignificantWeather(false);
        }

        public static Builder from(final TrendForecast value) {

            Builder retval = new TrendForecastImpl.Builder().setPeriodOfChange(value.getPeriodOfChange())
                    .setInstantOfChange(value.getInstantOfChange())
                    .setCeilingAndVisibilityOk(value.isCeilingAndVisibilityOk())
                    .setChangeIndicator(value.getChangeIndicator())
                    .setPrevailingVisibilityOperator(value.getPrevailingVisibilityOperator())
                    .setNoSignificantWeather(value.isNoSignificantWeather())
                    .setPrevailingVisibility(NumericMeasureImpl.immutableCopyOf(value.getPrevailingVisibility()))
                    .setSurfaceWind(TrendForecastSurfaceWindImpl.immutableCopyOf(value.getSurfaceWind()))
                    .setCloud(CloudForecastImpl.immutableCopyOf(value.getCloud()));

            value.getForecastWeather()
                    .map(layers -> retval.setForecastWeather(
                            Collections.unmodifiableList(layers.stream().map(WeatherImpl::immutableCopyOf).collect(Collectors.toList()))));
            return retval;
        }

        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setPrevailingVisibility(final NumericMeasure prevailingVisibility) {
            return super.setPrevailingVisibility(prevailingVisibility);
        }

        @Override
        @JsonDeserialize(as = TrendForecastSurfaceWindImpl.class)
        public Builder setSurfaceWind(final TrendForecastSurfaceWind surfaceWind) {
            return super.setSurfaceWind(surfaceWind);
        }

        @Override
        @JsonDeserialize(contentAs = WeatherImpl.class)
        public Builder setForecastWeather(final List<Weather> forecastWeather) {
            return super.setForecastWeather(forecastWeather);
        }

        @Override
        @JsonDeserialize(as = CloudForecastImpl.class)
        public Builder setCloud(final CloudForecast cloud) {
            return super.setCloud(cloud);
        }

        @Override
        public TrendForecastImpl build() {
            checkState(!(getPeriodOfChange().isPresent() && getInstantOfChange().isPresent()), "Both the period and the instant of change cannot be set");
            return super.build();
        }

    }
}
