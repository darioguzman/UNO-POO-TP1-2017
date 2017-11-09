package ar.edu.uno.units;

public class Lancer extends Unit {

	public Lancer(Integer coordanateX, Integer coordanateY) {

		super(150.0, 25.0, 1, 3, coordanateX, coordanateY, 2, 2,"Lancer");

	}

	@Override
	public boolean hasTheSpecialRequeriments() {
	
		return true;
		
	}

	@Override
	public void unsetSpecialCaractericts() {
	
		System.out.println("Lancer has not special caractericts");
	}

	@Override
	public Object getSpecialCaractericts() {
	
		return "Lancer has not special caractericts";
	}
	
	@Override
	public void giveSpecialItem() {
	
		System.out.println("Lancer has not special caractericts");
	}

	@Override
	public void increaseSpecialCaractericts(Integer number) {
	
		System.out.println("Lancer has not special caractericts");
	}

}
