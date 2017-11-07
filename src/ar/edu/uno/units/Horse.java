package ar.edu.uno.units;


public class Horse {
	
	private Integer numberOfExecutedAttacks;
	
	private final Integer ATTACKS_TO_REBELION = 3;
	
	public Horse(){
		
		this.setNumberOfExecutedAttacks(0);
		
	}
	
	/**
	 * increase number of attacks.
	 */
	public void increaseNumberOfAttacks(){
		
		this.setNumberOfExecutedAttacks(getNumberOfExecutedAttacks()+1);
		
	}
	
	/**
	 * @return
	 * <code>true</core> if this horse attacked more than ATTACKS_TO_REBELION (3)
	 */
	public boolean isRebellious(){
		
		return this.getNumberOfExecutedAttacks() >= ATTACKS_TO_REBELION;
		
	}
	
	/**
	 * set number of attacks in 0.
	 */
	public void drinkWaterPotion(){
		
		this.setNumberOfExecutedAttacks(0);
		
	}

	
	/**
	 * @return the numberOfExecutedAttacks
	 */
	public Integer getNumberOfExecutedAttacks() {
	
		return numberOfExecutedAttacks;
	}

	
	/**
	 * @param numberOfExecutedAttacks the numberOfExecutedAttacks to set
	 */
	public void setNumberOfExecutedAttacks(Integer numberOfExecutedAttacks) {
	
		this.numberOfExecutedAttacks = numberOfExecutedAttacks;
	}
	
	
}
