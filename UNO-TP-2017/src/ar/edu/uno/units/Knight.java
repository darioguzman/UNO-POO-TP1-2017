package ar.edu.uno.units;


public class Knight extends Unit {
	
	private Horse horse;
	
	public Knight(Integer coordanateX, Integer coordanateY){
	
		super(200.0, 50.0, 1, 2, coordanateX, coordanateY, 5, 5);
		
		this.setHorse(new Horse());
		
	}
	
	@Override
	/**
	 * Tests if this unit can attack to another unit.
	 * @param 
	 * Unit to be attack.
	 * 
	 * @return
	 * 
	 * <code>true</code> if the distance to the other unit is within the minimum and maximum range of attack, and if your horse is not
	 * rebellious,and if you are not attacking yourself. And also, this unit is alive;
	 * <code>false</code> if the distance to the other unit is outside the minimum and maximum range of attack.
	 * Or, if this unit is dead.
	 */
	public boolean canAttack(Unit unit) {
	
		if (equals(unit)){
			
			System.err.println("The unit can not attack itself!.");
			
			return false;
			
		}

		Integer distToAnotherUnit = distanceToAnotherUnit(unit);
		
		if (! ((distToAnotherUnit >= getDistanceMinToAttak()) && (distToAnotherUnit <= getDistanceToAttack())) ){
			
			System.err.println("The unit is not in range to be attacked.");
			
			return false;
		}
		
		if (! isAlive()){
			
			System.err.println("Unit is dead!.");
			
			return false;
		}
		
		if (isHorseRebellious()){
		
			System.err.println("The horse is rebellius!.");
			
			return false;
		}
		

		return true;
		
	
	}
	
	@Override
	/**
     * This method attacks the passed unit by parameter. Before invoke method <code>canAttack({@link Unit})</code> to validate
	 * if can attack.
	 * After the attack. Increase the number of attacks  of the horse.
	 * @param Unit
	 * Unit to be attack.
	 */
	public void attackToUnit(Unit unit){
		
		if (canAttack(unit)){

			unit.setLife(unit.getLife() - this.getDamage());
			
			this.getHorse().increaseNumberOfAttacks();
			
			System.out.println("Attack complete!.");
		
		}
		
	}
	
	/**
	 * Verifies that the horse has not rebellious.
	 * @return
	 * <code>true</code> if the horse attacked less than 4 times.
	 * <code>false</code> if the horse attacked more than 4 times.
	 */
	public boolean isHorseRebellious(){
		
		return this.getHorse().isRebellious();
	}

	
	/**
	 * Gives a potion of water to the horse to calm him.
	 */
	public void giveWaterPotion(){
		
		this.getHorse().drinkWaterPotion();
		
		System.out.println("Now, the horse has " + this.getHorse().getNumberOfExecutedAttacks() +" attacks.");
		
	}
	
	/**
	 * @return the horse
	 */
	public Horse getHorse() {
	
		return horse;
	}

	
	/**
	 * @param horse the horse to set
	 */
	public void setHorse(Horse horse) {
	
		this.horse = horse;
	}
	
	
	
	
}
