import common.Type;
import handlers.Approver;
import handlers.Manager;

/**
 * Execution class of the application. Be free to modify below line 14 (bellow
 * comment line)
 */
public class PurchaseApprovalExecutor {

	public static void execute() {
		Approver manager = new Manager();
		ApprovalChainGenerator.generate(manager);
		// Be free to modify method below this line

		manager.approve(1, -300.10, Type.CONSUMABLES);
		manager.approve(11, 300.001, Type.CONSUMABLES);
		manager.approve(2, 6500, Type.PC);
		manager.approve(3, 4900, Type.GAMING);
		manager.approve(4, 3000, Type.GADGETS);
		manager.approve(5, 1500, Type.CLERICAL);
	}
}
