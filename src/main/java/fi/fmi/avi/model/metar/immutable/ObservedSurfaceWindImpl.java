package fi.fmi.avi.model.metar.immutable;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.io.Serializable;
import java.util.Optional;

import org.inferred.freebuilder.FreeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fi.fmi.avi.model.NumericMeasure;
import fi.fmi.avi.model.immutable.NumericMeasureImpl;
import fi.fmi.avi.model.metar.ObservedSurfaceWind;

/**
 * Created by rinne on 13/04/2018.
 */

@FreeBuilder
@JsonDeserialize(builder = ObservedSurfaceWindImpl.Builder.class)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class ObservedSurfaceWindImpl implements ObservedSurfaceWind, Serializable {

    public static ObservedSurfaceWindImpl immutableCopyOf(final ObservedSurfaceWind observedSurfaceWind) {
        checkNotNull(observedSurfaceWind);
        if (observedSurfaceWind instanceof ObservedSurfaceWindImpl) {
            return (ObservedSurfaceWindImpl) observedSurfaceWind;
        } else {
            return Builder.from(observedSurfaceWind).build();
        }
    }

    public static Optional<ObservedSurfaceWindImpl> immutableCopyOf(final Optional<ObservedSurfaceWind> observedSurfaceWind) {
        checkNotNull(observedSurfaceWind);
        return observedSurfaceWind.map(ObservedSurfaceWindImpl::immutableCopyOf);
    }

    public abstract Builder toBuilder();

    public static class Builder extends ObservedSurfaceWindImpl_Builder {

        public Builder() {
            setVariableDirection(false);
        }

        @Override
        public ObservedSurfaceWindImpl build() {
            checkState(isVariableDirection() || getMeanWindDirection().isPresent(), "MeanWindDirection must be present if variableDirection is false");
            return super.build();
        }

        public static Builder from(final ObservedSurfaceWind value) {
            return new ObservedSurfaceWindImpl.Builder()//
                    .setMeanWindDirection(NumericMeasureImpl.immutableCopyOf(value.getMeanWindDirection()))
                    .setMeanWindSpeed(NumericMeasureImpl.immutableCopyOf(value.getMeanWindSpeed()))
                    .setVariableDirection(value.isVariableDirection())
                    .setWindGust(NumericMeasureImpl.immutableCopyOf(value.getWindGust()))
                    .setExtremeClockwiseWindDirection(NumericMeasureImpl.immutableCopyOf(value.getExtremeClockwiseWindDirection()))
                    .setExtremeCounterClockwiseWindDirection(NumericMeasureImpl.immutableCopyOf(value.getExtremeCounterClockwiseWindDirection()));
        }


        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setMeanWindDirection(final NumericMeasure meanWindDirection) {
            return super.setMeanWindDirection(meanWindDirection);
        }


        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setMeanWindSpeed(final NumericMeasure meanWindSpeed) {
            return super.setMeanWindSpeed(meanWindSpeed);
        }

        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setWindGust(final NumericMeasure windGust) {
            return super.setWindGust(windGust);
        }

        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setExtremeClockwiseWindDirection(final NumericMeasure extremeClockwiseWindDirection) {
            return super.setExtremeClockwiseWindDirection(extremeClockwiseWindDirection);
        }

        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setExtremeCounterClockwiseWindDirection(final NumericMeasure extremeCounterClockwiseWindDirection) {
            return super.setExtremeCounterClockwiseWindDirection(extremeCounterClockwiseWindDirection);
        }
    }
}