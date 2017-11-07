package ar.edu.uno.units;

public class Lancer extends Unit {

	public Lancer(Integer coordanateX, Integer coordanateY) {

		super(150.0, 25.0, 1, 3, coordanateX, coordanateY, 2, 2);

	}

	@Override
	public boolean hasTheSpecialRequeriments() {
	
		return true;
		
	}

	@Override
	public void unsetSpecialCaractericts() {
	
		
	}

}
