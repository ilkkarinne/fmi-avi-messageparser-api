package fi.fmi.avi.model.metar.immutable;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Optional;

import org.inferred.freebuilder.FreeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fi.fmi.avi.model.NumericMeasure;
import fi.fmi.avi.model.immutable.NumericMeasureImpl;
import fi.fmi.avi.model.metar.HorizontalVisibility;

/**
 * Created by rinne on 13/04/2018.
 */
@FreeBuilder
@JsonDeserialize(builder = HorizontalVisibilityImpl.Builder.class)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class HorizontalVisibilityImpl implements HorizontalVisibility, Serializable {

    public static HorizontalVisibilityImpl immutableCopyOf(final HorizontalVisibility horizontalVisibility) {
        checkNotNull(horizontalVisibility);
        if (horizontalVisibility instanceof HorizontalVisibilityImpl) {
            return (HorizontalVisibilityImpl) horizontalVisibility;
        } else {
            return Builder.from(horizontalVisibility).build();
        }
    }

    public static Optional<HorizontalVisibilityImpl> immutableCopyOf(final Optional<HorizontalVisibility> horizontalVisibility) {
        checkNotNull(horizontalVisibility);
        return horizontalVisibility.map(HorizontalVisibilityImpl::immutableCopyOf);
    }

    public abstract Builder toBuilder();

    public static class Builder extends HorizontalVisibilityImpl_Builder {

        public static Builder from(final HorizontalVisibility value) {
            return new HorizontalVisibilityImpl.Builder().setPrevailingVisibility(NumericMeasureImpl.immutableCopyOf(value.getPrevailingVisibility()))
                    .setPrevailingVisibilityOperator(value.getPrevailingVisibilityOperator())
                    .setMinimumVisibility(NumericMeasureImpl.immutableCopyOf(value.getMinimumVisibility()))
                    .setMinimumVisibilityDirection(NumericMeasureImpl.immutableCopyOf(value.getMinimumVisibilityDirection()));
        }

        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setPrevailingVisibility(final NumericMeasure prevailingVisibility) {
            return super.setPrevailingVisibility(prevailingVisibility);
        }

        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setMinimumVisibility(final NumericMeasure minimumVisibility) {
            return super.setMinimumVisibility(minimumVisibility);
        }

        @Override
        @JsonDeserialize(as = NumericMeasureImpl.class)
        public Builder setMinimumVisibilityDirection(final NumericMeasure minimumVisibilityDirection) {
            return super.setMinimumVisibilityDirection(minimumVisibilityDirection);
        }
    }
}
