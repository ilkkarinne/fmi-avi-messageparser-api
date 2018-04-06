package fi.fmi.avi.model.metar;

import org.inferred.freebuilder.FreeBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@FreeBuilder
@JsonDeserialize(builder = METAR.Builder.class)
public interface METAR extends MeteorologicalTerminalAirReport {

    boolean isDelayed();

    Builder toBuilder();

    class Builder extends METAR_Builder {

    }


}
