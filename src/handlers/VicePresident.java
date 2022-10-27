package handlers;

import common.Type;


/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver{
	@Override
    public void approve(int id, double cost, Type type) {
        if (canApprove( cost, type)) {
            System.out.println("Vice President approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Vice President.");
        next.approve(id, cost, type);
    }
	@Override
    public String getPositionName() {
    	return "Vice President";
    }
}

