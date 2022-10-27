package handlers;

import common.LimitsTable;
import common.Type;

public abstract class Approver {

    protected Approver next;

    /**
     * If needed, be free to change signature of abstract methods.
     */
    public void approve(int id, double cost, Type type) {
    	if(cost > 0L) {
    		if (canApprove(cost, type)) {
				System.out.println(getPositionName() + " approved purchase with id " + id + " that costs " + cost);
				return;
			}

			System.out.println("Purchase with id " + id + " needs approval from higher position than "+  getPositionName() +".");
			next.approve(id, cost, type);
	} else {
		System.out.println("Purchase with id " + id + " has a negative cost which is not allowed.");
	}

  }
    
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
