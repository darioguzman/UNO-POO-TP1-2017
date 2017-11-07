package ar.edu.uno.units;

public class Knight extends Unit {

	private Horse horse;

	public Knight(Integer coordanateX, Integer coordanateY) {

		super(200.0, 50.0, 1, 2, coordanateX, coordanateY, 5, 5);

		this.setHorse(new Horse());

	}

	@Override
	public boolean hasTheSpecialRequeriments() {
	
		if (isHorseRebellious()) {

			System.err.println("The horse is rebellius!.");

			return false;
		}
		
		return true;
	}

	@Override
	public void unsetSpecialCaractericts() {
	
		this.getHorse().increaseNumberOfAttacks();
	
	}
	
	/**
	 * Verifies that the horse has not rebellious.
	 * 
	 * @return <code>true</code> if the horse attacked less than 4 times.
	 *         <code>false</code> if the horse attacked more than 4 times.
	 */
	public boolean isHorseRebellious() {

		return this.getHorse().isRebellious();
	}

	/**
	 * Gives a potion of water to the horse to calm him.
	 */
	public void giveWaterPotion() {

		this.getHorse().drinkWaterPotion();

		System.out.println("Now, the horse has " + this.getHorse().getNumberOfExecutedAttacks() + " attacks.");

	}

	/**
	 * @return the horse
	 */
	public Horse getHorse() {

		return horse;
	}

	/**
	 * @param horse
	 *            the horse to set
	 */
	public void setHorse(Horse horse) {

		this.horse = horse;
	}

}
