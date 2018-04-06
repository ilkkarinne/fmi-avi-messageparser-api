package fi.fmi.avi.model;

import java.util.Optional;

import org.inferred.freebuilder.FreeBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@FreeBuilder
@JsonDeserialize(builder = Weather.Builder.class)
public interface Weather {

    String getCode();

    Optional<String> getDescription();

    Builder toBuilder();

    class Builder extends Weather_Builder {
    }
}
