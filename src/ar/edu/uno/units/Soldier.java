package ar.edu.uno.units;

public class Soldier extends Unit {

	private Integer energy;

	private Integer attackCost;

	public Soldier(Integer coordenateX, Integer coordenateY) {

		super(200.0, 10.0, 1, 1, coordenateX, coordenateY, 3, 3);

		this.energy = 100;

		this.attackCost = 10;

	}

	@Override
	public void unsetSpecialCaractericts() {
		
		this.setEnergy(this.getEnergy() - this.getAttackCost());

	}
	/**
	 * Gives a potion of water to this soldier to recover its energy.
	 */
	public void drinkWaterPotion() {

		this.setEnergy(100);

		System.out.println("Now, this unit has " + this.getEnergy() + " energy left.");

	}

	/**
	 * Verifies that the soldier has energy to attack.
	 * 
	 * @return <code>true</code> if the energy is greater than attack cost (10).
	 *         <code>false</code> if the distance is less than attack cost (10).
	 */
	private boolean hasEnergyToAttack() {

		return this.getEnergy() >= this.getAttackCost();
	}

	/**
	 * @return the energy
	 */
	public Integer getEnergy() {

		return energy;
	}

	/**
	 * @param energy
	 *            the energy to set
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
	 * @param attackCost
	 *            the attackCost to set
	 */
	public void setAttackCost(Integer attackCost) {

		this.attackCost = attackCost;
	}

	@Override
	public boolean hasTheSpecialRequeriments() {
	
		if (!hasEnergyToAttack()) {

			System.err.println("Unit has no energy to attack.");

			return false;
		}
		
		return true;
	}

}
