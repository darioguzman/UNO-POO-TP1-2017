package ar.edu.uno.testcase;

import junit.framework.TestCase;

import org.junit.Test;

import ar.edu.uno.units.Knight;
import ar.edu.uno.units.Soldier;
import ar.edu.uno.units.Unit;


public class SoldierTestCases extends TestCase{
	
	@Test
	public void testAttackToUnitOutOfRange() {
		
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitOutOfRange");
		
		Unit soldier1 = new Soldier(0,1);
		
		Unit soldier2 = new Soldier(5,5);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(200.0, soldier2.getLife());
		
	}
	@Test
	public void testAttackToUnitInRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitInRange");
		
		Soldier soldier1 = new Soldier(0,0);
		
		Soldier soldier2 = new Soldier(1,1);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(190.0, soldier2.getLife());
		
		assertEquals(new Integer(90), soldier1.getEnergy());
		
	}
	
	@Test
	public void testSoldierDead(){
		
		System.out.println("###############################");
		System.out.println("Test testSoldierDead");
		
		Soldier soldier1 = new Soldier(0,0);
		
		Soldier soldier2 = new Soldier(1,1);
		
		soldier1.setLife(0.0);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(200.0, soldier2.getLife());
	}
	
	@Test
	public void testSoldierWithoutEnergy(){
		
		System.out.println("###############################");
		System.out.println("Test testSoldierWithoutEnergy");
		
		Soldier soldier1 = new Soldier(0,0);
		
		Soldier soldier2 = new Soldier(1,1);
		
		soldier1.setEnergy(0);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(200.0, soldier2.getLife());
	}
	
	@Test
	public void testSoldierWithoutEnergyAndDrinkWaterPotion(){
		
		System.out.println("###############################");
		System.out.println("Test testSoldierWithoutEnergyAndDrinkWaterPotion");
		
		Soldier soldier1 = new Soldier(0,0);
		
		Soldier soldier2 = new Soldier(1,1);
		
		soldier1.setEnergy(0);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(new Integer(0), soldier1.getEnergy());
		
		assertEquals(200.0, soldier2.getLife());
		
		soldier1.drinkWaterPotion();
		
		assertEquals(new Integer(100), soldier1.getEnergy());
	
	}
	
	@Test
	public void testAttackToDeadUnitInRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToDeadUnitInRange");
		
		Soldier soldier1 = new Soldier(0,0);
		
		Soldier soldier2 = new Soldier(1,1);
		
		soldier2.setLife(0.0);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(0.0, soldier2.getLife());
		
		assertEquals(new Integer(100), soldier1.getEnergy());
		
	}
	
	@Test
	public void testAttackItself(){
		
		System.out.println("###############################");
		System.out.println("Test testAttackItself");
		
		Soldier soldier = new Soldier(0,0);
		
		soldier.attackToUnit(soldier);
		
		assertEquals(new Integer(100), soldier.getEnergy());
		assertEquals(new Double(200.0), soldier.getLife());
		
	}
	
	@Test
	public void testAttackUntilEndOfEnergy(){
		
		System.out.println("###############################");
		System.out.println("Test testAttackToDeadUnitInRange");
		
		Soldier soldier1 = new Soldier(0,0);
		
		Knight knight1 = new Knight(1,1);
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(90), soldier1.getEnergy());
		
		assertEquals(new Double(190), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(80), soldier1.getEnergy());
		
		assertEquals(new Double(180), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(70), soldier1.getEnergy());
		
		assertEquals(new Double(170), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(60), soldier1.getEnergy());
		
		assertEquals(new Double(160), knight1.getLife());

		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(50), soldier1.getEnergy());
		
		assertEquals(new Double(150), knight1.getLife());

		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(40), soldier1.getEnergy());
		
		assertEquals(new Double(140), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(30), soldier1.getEnergy());
		
		assertEquals(new Double(130), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(20), soldier1.getEnergy());
		
		assertEquals(new Double(120), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(10), soldier1.getEnergy());
		
		assertEquals(new Double(110), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(0), soldier1.getEnergy());
		
		assertEquals(new Double(100), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(0), soldier1.getEnergy());
		
		assertEquals(new Double(100), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(0), soldier1.getEnergy());
		
		assertEquals(new Double(100), knight1.getLife());
		
		soldier1.drinkWaterPotion();
		
	}
	
	
	@Test
	public void testMoveUnit() {
	
		System.out.println("###############################");
		System.out.println("Test testMoveUnit");
		
		Soldier soldier1 = new Soldier(0,0);
		
		soldier1.move(1, 1);
		
		assertEquals(new Integer(1), soldier1.getCoordanateX());
		assertEquals(new Integer(1), soldier1.getCoordanateY());
		
		soldier1.move(2, 2);
		
		assertEquals(new Integer(3), soldier1.getCoordanateX());
		assertEquals(new Integer(3), soldier1.getCoordanateY());
		
		soldier1.move(4, 4);
		
		assertEquals(new Integer(3), soldier1.getCoordanateX());
		assertEquals(new Integer(3), soldier1.getCoordanateY());
		
		soldier1.move(0, 1);
		
		assertEquals(new Integer(3), soldier1.getCoordanateX());
		assertEquals(new Integer(4), soldier1.getCoordanateY());
		
		
		
	}
}
