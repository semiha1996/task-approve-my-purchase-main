package handlers;

import common.LimitsTable;
import common.Type;

public abstract class Approver {

    protected Approver next;

    /**
     * If needed, be free to change signature of abstract methods.
     */
    public abstract void approve(int id, double cost, Type type);
    
    public abstract String getPositionName();
    
    protected boolean canApprove(double cost, Type type) {
    	Long maximumAllowance = LimitsTable.getMaximumAllowance(getPositionName(), type);
    	
    	return maximumAllowance >= cost;
    }

    /**
     * Method used for registering next approver level.
     * DO NOT CHANGE IT.
     */
    public Approver registerNext(Approver next) {
        this.next = next;
        return next;
    }
}
