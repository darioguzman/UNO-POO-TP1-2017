package ar.edu.uno.items.decorators;

import ar.edu.uno.units.Unit;

public class Cap extends UnitDecorator {
	
	private final Integer ATTACK_DISCOUNT = 10;
	
	public Cap(Unit unit){
	
		super(unit);
		
		if (null != unit.getUnitDescription() && unit.getUnitDescription().contains("Soldier")) {
			
			increaseSpecialCaractericts();
			
		}
		
	}
	
	@Override
	public String getUnitDescription() {
	
		String description;
		
		if (getUnit().getUnitDescription().contains("with") && getUnit().getUnitDescription().contains("and")) {
			
			description = getUnit().getUnitDescription().replaceAll("and", ",") + " and Cap";
			
		}
		
		if (getUnit().getUnitDescription().contains("with")) {
			
			description = getUnit().getUnitDescription() + " and Cap";
			
		} else {
			
			description = getUnit().getUnitDescription() + " with Cap";
			
		}
		
		return description;
	}
	
	@Override
	public Double getPointsDamage() {
	
		return getUnit().getPointsDamage() - ((getUnit().getPointsDamage() * ATTACK_DISCOUNT) / 100);
		
	}
	
	@Override
	public Double getPointsDefenseFromAttack(Double damage) {
	
		return getUnit().getPointsDefenseFromAttack(damage);
	}
	
	@Override
	public boolean hasTheSpecialRequeriments() {
	
		return getUnit().hasTheSpecialRequeriments();
	}
	
	@Override
	public void unsetSpecialCaractericts() {
	
		getUnit().unsetSpecialCaractericts();
		
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
	
	private void increaseSpecialCaractericts() {
		
		getUnit().increaseSpecialCaractericts(2);
		
	}
	
}
