package ar.edu.uno.units;

public class Archer extends Unit {

	private Integer arrows;

	private final Integer ARROW_PACKAGE = 6;

	public Archer(Integer coordanateX, Integer coordanateY) {

		super(50.0, 5.0, 2, 5, coordanateX, coordanateY, 1, 1, "Archer");

		this.setArrows(20);

	}

	/**
	 * Gives a arrow package this archer to recover 6 arrows.
	 */
	public void giveArrowsPackage() {

		if (this.getArrows() > 14) {

			System.err.println("This unit still can not reload arrows.");

		} else {

			this.setArrows(this.getArrows() + ARROW_PACKAGE);

			System.out.println("Now, this unit has " + this.getArrows() + " arrows left.");
		}
	}

	/**
	 * Verifies that the Archer has arrows to attack.
	 * 
	 * @return <code>true</code> if the energy is greater than attack cost (10).
	 *         <code>false</code> if the distance is less than attack cost (10).
	 */

	private boolean hasArrows() {

		return this.getArrows() > 0;
	}

	/**
	 * @return the arrows
	 */
	public Integer getArrows() {

		return arrows;
	}

	/**
	 * @param arrows
	 *            the arrows to set
	 */
	public void setArrows(Integer arrows) {

		this.arrows = arrows;
	}

	@Override
	public Object getSpecialCaractericts() {
	
		return this.getArrows();
		
	}
	
	@Override
	public boolean hasTheSpecialRequeriments() {
	
		if (!hasArrows()) {

			System.err.println("The unit has not left arrows!.");

			return false;
		}
		
		return true;
	}
	@Override
	public void unsetSpecialCaractericts() {
	
		this.setArrows(this.getArrows() - 1);
		
	}
	
	@Override
	public void increaseSpecialCaractericts(Integer number) {
	
		this.setArrows(getArrows() + number);
		
	}

	@Override
	public void giveSpecialItem() {
	
		giveArrowsPackage();
	}
}
