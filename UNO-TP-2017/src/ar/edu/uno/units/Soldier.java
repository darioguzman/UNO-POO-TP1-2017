package ar.edu.uno.units;

public class Soldier extends Unit{

	private Integer energy;
	
	private Integer attackCost;
	
	public Soldier(Integer coordenateX, Integer coordenateY){
	
		super(200.0, 10.0,1, 1, coordenateX,coordenateY, 3, 3);
		
		this.energy = 100;
		
		this.attackCost = 10;

	}
	
	@Override
	/**
	 * Tests if this unit can attack to another unit.
	 * @param 
	 * Unit to be attack.
	 * 
	 * @return
	 * 
	 * <code>true</code> if the distance to the other unit is within the minimum and maximum range of attack, if this unit has
	 * enough energy to attack, and if you are not attacking yourself.  And also, this unit is alive;
	 * <code>false</code> if the distance to the other unit is outside the minimum and maximum range of attack.
	 * Or, if this unit is dead.
	 */
	public boolean canAttack(Unit unit){
		
		if (equals(unit)){
			
			System.err.println("The unit can not attack itself!.");
			
			return false;
			
		}

		Integer distToAnotherUnit = distanceToAnotherUnit(unit);

		if (! (distToAnotherUnit.intValue() == getDistanceToAttack().intValue()) ){
			
			System.err.println("The unit is not in range to be attacked.");
			
			return false;
		}
		
		if (! hasEnergyToAttack() ){
			
			System.err.println("Unit has no energy to attack.");
			
			return false;
		}
		
		if (! isAlive()){
		
			System.err.println("Unit is dead!.");
			
			return false;
		}
		
		return true;
		
	}
	
	@Override
	/**
     * This method attacks the passed unit by parameter. Before invoke method <code>canAttack({@link Unit})</code> to validate
	 * if can attack.
	 * After the attack. Reduces energy by 10.
	 * @param Unit
	 * Unit to be attack.
	 */
	public void attackToUnit(Unit unit){
		
		if (canAttack(unit)){

			if (unit.getLife() <= 0.0){
				
				System.err.println("The unit to be attack is dead!.");
				
				return;
			
			}
			
			this.setEnergy(this.getEnergy() - this.getAttackCost());
			
			unit.setLife(unit.getLife() - this.getDamage());
			
			System.out.println("Attack complete!.");
		
		}
		
	}
	
	/**
	 * Gives a potion of water to this soldier to recover its energy.
	 */
	public void drinkWaterPotion(){
		
		this.setEnergy(100);
		
		System.out.println("Now, this unit has " + this.getEnergy() +" energy left.");
		
	}
	
	/**
	 * Verifies that the soldier has energy to attack.
	 * @return
	 * <code>true</code> if the energy is greater than attack cost (10).
	 * <code>false</code> if the distance is less than attack cost (10).
	 */
	private boolean hasEnergyToAttack(){
		
		return this.getEnergy() >= this.getAttackCost();
	}

	
	/**
	 * @return the energy
	 */
	public Integer getEnergy() {
	
		return energy;
	}

	
	/**
	 * @param energy the energy to set
	 */
	public void setEnergy(Integer energy) {
	
		this.energy = energy;
	}

	
	/**
	 * @return the attackCost
	 */
	public Integer getAttackCost() {
	
		return attackCost;
	}

	
	/**
	 * @param attackCost the attackCost to set
	 */
	public void setAttackCost(Integer attackCost) {
	
		this.attackCost = attackCost;
	}

	
	
}
