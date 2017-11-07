package ar.edu.uno.units;

public abstract class Unit {
	
	private Double life;
	
	private Double damage;
	
	private Integer distanceToAttack;
	
	private Integer coordanateX;
	
	private Integer coordanateY;
	
	private Integer distanceMinToAttak;
	
	private Integer maxMovsInX;
	
	private Integer maxMovsInY;
	
	public Unit(Double life, Double damage, Integer distanceMinToAttak, Integer distanceToAttack, Integer coordanateX, Integer coordanateY, Integer maxMovsInX,
			Integer maxMovsInY){
	
		this.setDamage(damage);
		this.setLife(life);
		this.setDistanceToAttack(distanceToAttack);
		this.setCoordanateX(coordanateX);
		this.setCoordanateY(coordanateY);
		this.setDistanceMinToAttak(distanceMinToAttak);
		this.setMaxMovsInX(maxMovsInX);
		this.setMaxMovsInY(maxMovsInY);
		
	}
	
	/**
	 * This method attacks the passed unit by parameter. Before invoke method
	 * <code>canAttack({@link Unit})</code> to validate if can attack. After the
	 * attack invoke method <code>unsetEspecialCaractericts</code>
	 * 
	 * @param Unit
	 *            Unit to be attack.
	 */
	public void attackToUnit(Unit unit) {
	
		if (canAttack(unit)) {
			
			if (unit.getLife() <= 0.0) {
				
				System.err.println("The unit to be attack is dead!.");
				
				return;
				
			}
			
			unsetSpecialCaractericts();
			
			System.out.println("Attack complete!.");
			
		}
		
	}
	
	public abstract void unsetSpecialCaractericts();
	
	/**
	 * Tests if this unit can attack to another unit.
	 * 
	 * @param Unit
	 *            to be attack.
	 * @return
	 * 
	 *         <code>true</code> if the distance to the other unit is within the
	 *         minimum and maximum range of attack. And also, this unit is
	 *         alive; <code>false</code> if the distance to the other unit is
	 *         outside the minimum and maximum range of attack. Or, if this unit
	 *         is dead.
	 */
	public boolean canAttack(Unit unit){
		
		if (equals(unit)) {

			System.err.println("The unit can not attack itself!.");

			return false;

		}

		Integer distToAnotherUnit = distanceToAnotherUnit(unit);

		if (!(distToAnotherUnit.intValue() == getDistanceToAttack().intValue())) {

			System.err.println("The unit is not in range to be attacked.");

			return false;
		}

		if (!hasTheSpecialRequeriments()) {

			return false;
		
		}

		if (!isAlive()) {

			System.err.println("Unit is dead!.");

			return false;
		}

		return true;
	}
	
	
	public abstract boolean hasTheSpecialRequeriments();
	/**
	 * This method return the distance to other unit.
	 * 
	 * @param unit
	 * @return Using {@link Math} calculates distance to other unit.
	 */
	protected Integer distanceToAnotherUnit(Unit unit) {
	
		Double distance = Math.sqrt(Math.pow(this.getCoordanateX() - unit.getCoordanateX(), 2) + Math.pow(this.getCoordanateY() - unit.getCoordanateY(), 2));
		
		return new Integer(distance.intValue());
		
	}
	
	/**
	 * This method evaluate if this unit is alive
	 * 
	 * @return <code>true</code> if and only if @life > 0 <code>false</code> if @life
	 *         <= 0.
	 */
	public boolean isAlive() {
	
		return life > 0;
	}
	
	/**
	 * This method set positionX and positionY. Before moving to the unit, valid
	 * not to exceed the maximum number of movements
	 * 
	 * @param moveX
	 * @param moveY
	 */
	public void move(Integer moveX, Integer moveY) {
	
		if (moveX > this.getMaxMovsInX() || moveY > this.getMaxMovsInY()) {
			
			System.err.println("This unit can't move more than " + this.getMaxMovsInX() + " space/s in X and " + this.getMaxMovsInY() + " in Y.");
			
			return;
			
		}
		
		this.setCoordanateX(getCoordanateX() + moveX);
		
		this.setCoordanateY(getCoordanateY() + moveY);
		
	}
	
	@Override
	/**
	 * Compares this unit to the specified object.  The result is {@code
	 * true} if and only if the argument is not {@code null} and is a {@code
	 * Unit} object has the same damage and is located in the same position.
	 *
	 * @param  anObject
	 *         The object to compare this {@code Unit} against
	 *
	 * @return  {@code true} if the given object represents a {@code Unit}
	 *           is the same as this Unit, {@code false} otherwise
	 *
	 */
	public boolean equals(Object obj) {
	
		if (this == obj) {
			
			return true;
			
		}
		
		if (obj instanceof Unit) {
			
			if ((this.getDamage().equals(((Unit) obj).getDamage())) && (this.getCoordanateX().equals(((Unit) obj).getCoordanateX()))
					&& (this.getCoordanateY().equals(((Unit) obj).getCoordanateY()))) {
				return true;
			}
		}
		
		return false;
		
	}
	
	/**
	 * @return the life
	 */
	public Double getLife() {
	
		return life;
	}
	
	/**
	 * @param life
	 *            the life to set
	 */
	public void setLife(Double life) {
	
		this.life = life;
	}
	
	/**
	 * @return the damage
	 */
	public Double getDamage() {
	
		return damage;
	}
	
	/**
	 * @param damage
	 *            the damage to set
	 */
	public void setDamage(Double damage) {
	
		this.damage = damage;
	}
	
	/**
	 * @return the distanceToAttack
	 */
	public Integer getDistanceToAttack() {
	
		return distanceToAttack;
	}
	
	/**
	 * @param distanceToAttack
	 *            the distanceToAttack to set
	 */
	public void setDistanceToAttack(Integer distanceToAttack) {
	
		this.distanceToAttack = distanceToAttack;
	}
	
	/**
	 * @return the coordanateX
	 */
	public Integer getCoordanateX() {
	
		return coordanateX;
	}
	
	/**
	 * @param coordanateX
	 *            the coordanateX to set
	 */
	public void setCoordanateX(Integer coordanateX) {
	
		this.coordanateX = coordanateX;
	}
	
	/**
	 * @return the coordanateY
	 */
	public Integer getCoordanateY() {
	
		return coordanateY;
	}
	
	/**
	 * @param coordanateY
	 *            the coordanateY to set
	 */
	public void setCoordanateY(Integer coordanateY) {
	
		this.coordanateY = coordanateY;
	}
	
	/**
	 * @return the distanceMinToAttak
	 */
	public Integer getDistanceMinToAttak() {
	
		return distanceMinToAttak;
	}
	
	/**
	 * @param distanceMinToAttak
	 *            the distanceMinToAttak to set
	 */
	public void setDistanceMinToAttak(Integer distanceMinToAttak) {
	
		this.distanceMinToAttak = distanceMinToAttak;
	}
	
	/**
	 * @return the maxMovsInX
	 */
	public Integer getMaxMovsInX() {
	
		return maxMovsInX;
	}
	
	/**
	 * @param maxMovsInX
	 *            the maxMovsInX to set
	 */
	public void setMaxMovsInX(Integer maxMovsInX) {
	
		this.maxMovsInX = maxMovsInX;
	}
	
	/**
	 * @return the maxMovsInY
	 */
	public Integer getMaxMovsInY() {
	
		return maxMovsInY;
	}
	
	/**
	 * @param maxMovsInY
	 *            the maxMovsInY to set
	 */
	public void setMaxMovsInY(Integer maxMovsInY) {
	
		this.maxMovsInY = maxMovsInY;
	}
	
}
