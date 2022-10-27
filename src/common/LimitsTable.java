package common;

import java.util.Map;

public class LimitsTable {
	//Represent the table with limits in each category
	private static final Map<String, Map<Type, Long>> map = Map.of(
		"Manager", Map.of(
				Type.CONSUMABLES, 300L,
				Type.CLERICAL, 500L,
				Type.GADGETS, 1000L,
				Type.GAMING, 3000L,
				Type.PC, 5000L),
		"Director", Map.of(
				Type.CONSUMABLES, 500L,
				Type.CLERICAL, 1000L,
				Type.GADGETS, 1500L,
				Type.GAMING, 3500L,
				Type.PC, 6000L),
		"Vice President", Map.of(
				Type.CONSUMABLES, 700L,
				Type.CLERICAL, 1500L,
				Type.GADGETS, 2000L,
				Type.GAMING, 4500L,
				Type.PC, 6000L),
		"President", Map.of(
				Type.CONSUMABLES, 1000L,
				Type.CLERICAL, 2000L,
				Type.GADGETS, 3000L,
				Type.GAMING, 5000L,
				Type.PC, 8000L)
	);
	
	/**
	 * Gets the maximum limit for a position
	 * @param position describes the title of the manager
	 * @param type 
	 * @return 
	 */
	public static Long getMaximumAllowance(String position, Type type) {
		Long result = 0L;
		Map<Type, Long> positionMap = map.get(position);
		if(positionMap != null) {
			result = positionMap.get(type);
		}
		
		return result != null ? result : 0L;
	}

}
