package ar.edu.uno.items.decorators;

import ar.edu.uno.units.Unit;

public abstract class UnitDecorator extends Unit {
	
	Unit unit;
	
	public UnitDecorator(Unit unit){
	
		super(unit.getLife(), unit.getDamage(), unit.getDistanceMinToAttak(), unit.getDistanceToAttack(), unit.getCoordanateX(), unit.getCoordanateY(), unit
				.getMaxMovsInX(), unit.getMaxMovsInY(), unit.getUnitDescription());
		
		this.setUnit(unit);
	
	}
	
	public Unit getUnit() {
	
		return unit;
	}
	
	public void setUnit(Unit unit) {
	
		this.unit = unit;
	}
	
	public String getUnitDescription(){
		
		return getUnit().getUnitDescription();
	
	}
	
}
