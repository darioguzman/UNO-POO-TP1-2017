package ar.edu.uno.items.decorators;

import ar.edu.uno.units.Unit;

public class Shield extends UnitDecorator {
	
	private final Integer ATTACK_DISCOUNT = 40;
	
	public Shield(Unit unit){
	
		super(unit);
		
	}
	
	@Override
	public Double getPointsDamage() {
	
		return getUnit().getPointsDamage();
	}
	
	@Override
	public Double getPointsDefenseFromAttack(Double damage) {
	
		return getUnit().getPointsDefenseFromAttack(damage) + ((damage * ATTACK_DISCOUNT) / 100);
		
	}
	
	public Integer getATTACK_DISCOUNT() {
	
		return ATTACK_DISCOUNT;
	}
	
	@Override
	public String getUnitDescription() {
	
		String description;
		
		if (getUnit().getUnitDescription().contains("with") && getUnit().getUnitDescription().contains("and")) {
			
			description = getUnit().getUnitDescription().replaceAll("and", ",") + " and Shield";
			
		}
		
		if (getUnit().getUnitDescription().contains("with")) {
			
			description = getUnit().getUnitDescription() + " and Shield";
			
		} else {
			
			description = getUnit().getUnitDescription() + " with Shield";
			
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
