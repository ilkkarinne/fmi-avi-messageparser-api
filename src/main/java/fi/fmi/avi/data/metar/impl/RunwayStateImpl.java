package fi.fmi.avi.data.metar.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fi.fmi.avi.data.NumericMeasure;
import fi.fmi.avi.data.impl.NumericMeasureImpl;
import fi.fmi.avi.data.metar.RunwayState;

/**
 * 
 * @author Ilkka Rinne / Spatineo Inc for the Finnish Meteorological Institute
 * 
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RunwayStateImpl implements RunwayState {

    private boolean allRunways;
    private boolean cleared;
    private boolean estimatedSurfaceFrictionUnreliable;
    private boolean snowClosure;
    private boolean repetition;
    private boolean depthNotMeasurable;
    private boolean runwayNotOperational;
    private String runwayDirectionDesignator;
    private RunwayDeposit deposit;
    private RunwayContamination contamination;
    private NumericMeasure depthOfDeposit;
    private RelationalOperator depthOperator;
    private Double estimatedSurfaceFriction; // null=N/A, otherwise between 0.0 and 0.9
    private BreakingAction breakingAction; // corresponds to code values 91 - 95

    public RunwayStateImpl() {
    }
    
    public RunwayStateImpl(final RunwayState input) {
        this.allRunways = input.isAllRunways();
        this.cleared = input.isCleared();
        this.estimatedSurfaceFrictionUnreliable = input.isEstimatedSurfaceFrictionUnreliable();
        this.snowClosure = input.isSnowClosure();
        this.repetition = input.isRepetition();
        this.runwayDirectionDesignator = input.getRunwayDirectionDesignator();
        this.deposit = input.getDeposit();
        this.contamination = input.getContamination();
        this.depthOfDeposit = new NumericMeasureImpl(input.getDepthOfDeposit());
        this.depthOperator = input.getDepthOperator();
        this.estimatedSurfaceFriction = input.getEstimatedSurfaceFriction();
        this.breakingAction = input.getBreakingAction();
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#isAllRunways()
     */
    @Override
    public boolean isAllRunways() {
        return allRunways;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#isCleared()
     */
    @Override
    public boolean isCleared() {
        return cleared;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#isEstimatedSurfaceFrictionUnreliable()
     */
    @Override
    public boolean isEstimatedSurfaceFrictionUnreliable() {
        return estimatedSurfaceFrictionUnreliable;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#isSnowClosure()
     */
    @Override
    public boolean isSnowClosure() {
        return snowClosure;
    }
    
    @Override
    public boolean isRepetition() {
    	return repetition;
    }
    
    @Override
    public boolean isDepthNotMeasurable() {
    	return this.depthNotMeasurable;
    }
    
    @Override
    public boolean isRunwayNotOperational() {
    	return this.runwayNotOperational;
    }
    

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#getRunwayDirectionDesignator()
     */
    @Override
    public String getRunwayDirectionDesignator() {
        return runwayDirectionDesignator;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#getDeposit()
     */
    @Override
    public RunwayDeposit getDeposit() {
        return deposit;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#getContamination()
     */
    @Override
    public RunwayContamination getContamination() {
        return contamination;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#getDepthOfDeposit()
     */
    @Override
    public NumericMeasure getDepthOfDeposit() {
        return depthOfDeposit;
    }
    
    @Override
    public RelationalOperator getDepthOperator() {
    	return this.depthOperator;
    }
    

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#getEstimatedSurfaceFriction()
     */
    @Override
    public Double getEstimatedSurfaceFriction() {
        return estimatedSurfaceFriction;
    }
    
    @Override
    public BreakingAction getBreakingAction() {
    	return this.breakingAction;
    }


    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setAllRunways(boolean)
     */
    @Override
    public void setAllRunways(final boolean allRunways) {
        this.allRunways = allRunways;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setCleared(boolean)
     */
    @Override
    public void setCleared(final boolean cleared) {
        this.cleared = cleared;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setEstimatedSurfaceFrictionUnreliable(boolean)
     */
    @Override
    public void setEstimatedSurfaceFrictionUnreliable(final boolean estimatedSurfaceFrictionUnreliable) {
        this.estimatedSurfaceFrictionUnreliable = estimatedSurfaceFrictionUnreliable;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setSnowClosure(boolean)
     */
    @Override
    public void setSnowClosure(final boolean snowClosure) {
        this.snowClosure = snowClosure;
    }
    
    @Override
    public void setRepetition(final boolean repetition) {
    	this.repetition = repetition;
    }
    
    @Override
    public void setDepthNotMeasurable(boolean notMeasurable) {
    	this.depthNotMeasurable = notMeasurable;
    }

    @Override
    public void setRunwayNotOperational(boolean notOperational) {
    	this.runwayNotOperational = notOperational;
    }
    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setRunwayDirectionDesignator(java.lang.String)
     */
    @Override
    public void setRunwayDirectionDesignator(final String runwayDirectionDesignator) {
        this.runwayDirectionDesignator = runwayDirectionDesignator;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setDeposit(fi.fmi.avi.data.AviationCodeListUser.RunwayDeposit)
     */
    @Override
    public void setDeposit(final RunwayDeposit deposit) {
        this.deposit = deposit;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setContamination(fi.fmi.avi.data.AviationCodeListUser.RunwayContamination)
     */
    @Override
    public void setContamination(final RunwayContamination contamination) {
        this.contamination = contamination;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setDepthOfDeposit(fi.fmi.avi.data.NumericMeasure)
     */
    @Override
    @JsonDeserialize(as = NumericMeasureImpl.class)
    public void setDepthOfDeposit(final NumericMeasure depthOfDeposit) {
        this.depthOfDeposit = depthOfDeposit;
    }
    
    @Override
    public void setDepthOperator(RelationalOperator operator) {
    	this.depthOperator = operator;
    }

    /* (non-Javadoc)
     * @see fi.fmi.avi.data.RunwayState#setEstimatedSurfaceFriction(java.lang.Double)
     */
    @Override
    public void setEstimatedSurfaceFriction(final Double estimatedSurfaceFriction) {
        this.estimatedSurfaceFriction = estimatedSurfaceFriction;
    }
    
    public void setBreakingAction(final BreakingAction action) {
    	this.breakingAction = action;
    }

}