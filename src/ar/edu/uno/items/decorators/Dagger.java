package ar.edu.uno.items.decorators;

import ar.edu.uno.units.Unit;

public class Dagger extends UnitDecorator {
	
	private final Double ATTACK_DISCOUNT = 3.0;
	
	private final Double ATTACK_INCREASE = 3.0;
	
	public Dagger(Unit unit){
	
		super(unit);
		
	}
	
	@Override
	public Double getPointsDamage() {
	
		return getUnit().getPointsDamage() + ATTACK_INCREASE;
	}
	
	@Override
	public Double getPointsDefenseFromAttack(Double damage) {
		
		return getUnit().getPointsDefenseFromAttack(damage) + ATTACK_DISCOUNT;
	};
	
	
	@Override
	public String getUnitDescription() {
	
		String description;
		
		if (getUnit().getUnitDescription().contains("with") && getUnit().getUnitDescription().contains("and")) {
			
			description = getUnit().getUnitDescription().replaceAll("and", ",") + " and Dagger";
			
		}
		
		if (getUnit().getUnitDescription().contains("with")) {
			
			description = getUnit().getUnitDescription() + " and Dagger";
			
		} else {
			
			description = getUnit().getUnitDescription() + " with Dagger";
			
		}
		
		return description;
	}
	
	@Override
	public void unsetSpecialCaractericts() {
	
		getUnit().unsetSpecialCaractericts();
	}
	
	@Override
	public boolean hasTheSpecialRequeriments() {
	
		return getUnit().hasTheSpecialRequeriments();
		
	}
	
	@Override
	public Object getSpecialCaractericts() {
	
		return getUnit().getSpecialCaractericts();
	}

	@Override
	public void increaseSpecialCaractericts(Integer number) {
	
		getUnit().increaseSpecialCaractericts(number);
	}

	@Override
	public void giveSpecialItem() {
	
		getUnit().giveSpecialItem();
	}
	
}
