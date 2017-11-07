package ar.edu.uno.units;

public class Archer extends Unit {
	
	private Integer arrows;
	
	private final Integer ARROW_PACKAGE = 6;
	
	public Archer(Integer coordanateX, Integer coordanateY){
	
		super(50.0, 5.0, 2, 5, coordanateX, coordanateY, 1, 1);
		
		this.setArrows(20);
		
	}
	
	
	@Override
	/**
	 * Tests if this unit can attack to another unit.
	 * @param 
	 * Unit to be attack.
	 * 
	 * @return
	 * 
	 * <code>true</code> if the distance to the other unit is within the minimum and maximum range of attack, and if this unit has
	 * enough arrows to attack, and if you are not attacking yourself. And also, this unit is alive;
	 * <code>false</code> if the distance to the other unit is outside the minimum and maximum range of attack.
	 * Or, if this unit is dead.
	 */
	public boolean canAttack(Unit unit){
		
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
		
		if (! hasArrows()){
			
			System.err.println("The unit has not left arrows!.");
			
			return false;
		}
		

		return true;
		
	}
	
	@Override
	/**
     * This method attacks the passed unit by parameter. Before invoke method <code>canAttack({@link Unit})</code> to validate
	 * if can attack.
	 * After the attack. Reduces arrows by 1.
	 * @param Unit
	 * Unit to be attack.
	 */
	public void attackToUnit(Unit unit){
		
		if (canAttack(unit)){

			if (unit.getLife() <= 0.0){
				
				System.err.println("The unit to be attack is dead!.");
				
				return;
			
			}

			this.setArrows(this.getArrows() - 1); 
			
			unit.setLife(unit.getLife() - this.getDamage());
			
			System.out.println("Attack complete!.");
		
		}
		
	}
	

	/**
	 * Gives a arrow package this archer to recover 6 arrows.
	 */
	public void giveArrowsPackage(){
		
		if (this.getArrows() > 14){
			
			System.err.println("This unit still can not reload arrows.");
			
		}else{
			
			this.setArrows(this.getArrows() + ARROW_PACKAGE);
			
			System.out.println("Now, this unit has " + this.getArrows() +" arrows left.");
		}
	}
	
	/**
	 * Verifies that the Archer has arrows to attack.
	 * @return
	 * <code>true</code> if the energy is greater than attack cost (10).
	 * <code>false</code> if the distance is less than attack cost (10).
	 */
	
	private boolean hasArrows(){
		
		return this.getArrows() > 0;
	}

	/**
	 * @return the arrows
	 */
	public Integer getArrows() {
	
		return arrows;
	}

	/**
	 * @param arrows the arrows to set
	 */
	public void setArrows(Integer arrows) {
	
		this.arrows = arrows;
	}
	
	
	
}
