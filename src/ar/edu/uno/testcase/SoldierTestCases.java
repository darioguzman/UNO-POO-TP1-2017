package ar.edu.uno.testcase;

import junit.framework.TestCase;

import org.junit.Test;

import ar.edu.uno.items.decorators.Cap;
import ar.edu.uno.items.decorators.Dagger;
import ar.edu.uno.items.decorators.Shield;
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
		
		Unit soldier1 = new Soldier(0,0);
		
		Unit soldier2 = new Soldier(1,1);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(190.0, soldier2.getLife());
		
		assertEquals(new Integer(90), soldier1.getSpecialCaractericts());
		
	}
	
	@Test
	public void testAttackToUnitWithShieldInRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitWithShieldInRange");
		
		Unit soldier1 = new Soldier(0,0);
		
		Unit soldier2 = new Soldier(1,1);
		
		soldier1 = new Dagger(soldier1);
		
		soldier2 = new Shield(soldier2);
		soldier2 = new Dagger(soldier2);
		
		soldier1 = new Cap(soldier1);
		
		System.out.println(soldier1.getPointsDamage());
//		System.out.println(soldier2.getPointsDamage());
		System.out.println(soldier2.getPointsDefenseFromAttack(soldier1.getPointsDamage()));
		
		soldier1.attackToUnit(soldier2);
		
		System.out.println(soldier1.getUnitDescription());
		System.out.println(soldier2.getUnitDescription());
		
		assertEquals(195.98, soldier2.getLife());
		
		assertEquals(new Integer(190), soldier1.getSpecialCaractericts());
		
		assertEquals(new Integer(100), soldier2.getSpecialCaractericts());
		
	}
	
	@Test
	public void testSoldierDead(){
		
		System.out.println("###############################");
		System.out.println("Test testSoldierDead");
		
		Unit soldier1 = new Soldier(0,0);
		
		Unit soldier2 = new Soldier(1,1);
		
		soldier1.setLife(0.0);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(200.0, soldier2.getLife());
	}
	
	@Test
	public void testSoldierWithoutEnergy(){
		
		System.out.println("###############################");
		System.out.println("Test testSoldierWithoutEnergy");
		
		Unit soldier1 = new Soldier(0,0);
		
		Unit soldier2 = new Soldier(1,1);
		
		soldier1.increaseSpecialCaractericts(0);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(200.0, soldier2.getLife());
	}
	
	@Test
	public void testSoldierWithoutEnergyAndDrinkWaterPotion(){
		
		System.out.println("###############################");
		System.out.println("Test testSoldierWithoutEnergyAndDrinkWaterPotion");
		
		Unit soldier1 = new Soldier(0,0);
		
		Unit soldier2 = new Soldier(1,1);
		
		soldier1.increaseSpecialCaractericts(0);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(new Integer(0), soldier1.getSpecialCaractericts());
		
		assertEquals(200.0, soldier2.getLife());
		
		soldier1.giveSpecialItem();
		
		assertEquals(new Integer(100), soldier1.getSpecialCaractericts());
	
	}
	
	@Test
	public void testAttackToDeadUnitInRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToDeadUnitInRange");
		
		Unit soldier1 = new Soldier(0,0);
		
		Unit soldier2 = new Soldier(1,1);
		
		soldier2.setLife(0.0);
		
		soldier1.attackToUnit(soldier2);
		
		assertEquals(0.0, soldier2.getLife());
		
		assertEquals(new Integer(100), soldier1.getSpecialCaractericts());
		
	}
	
	@Test
	public void testAttackItself(){
		
		System.out.println("###############################");
		System.out.println("Test testAttackItself");
		
		Unit soldier = new Soldier(0,0);
		
		soldier.attackToUnit(soldier);
		
		assertEquals(new Integer(100), soldier.getSpecialCaractericts());
		assertEquals(new Double(200.0), soldier.getLife());
		
	}
	
	@Test
	public void testAttackUntilEndOfEnergy(){
		
		System.out.println("###############################");
		System.out.println("Test testAttackToDeadUnitInRange");
		
		Unit soldier1 = new Soldier(0,0);
		
		Unit knight1 = new Knight(1,1);
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(90), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(190), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(80), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(180), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(70), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(170), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(60), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(160), knight1.getLife());

		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(50), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(150), knight1.getLife());

		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(40), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(140), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(30), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(130), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(20), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(120), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(10), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(110), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(0), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(100), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(0), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(100), knight1.getLife());
		
		soldier1.attackToUnit(knight1);
		
		assertEquals(new Integer(0), soldier1.getSpecialCaractericts());
		
		assertEquals(new Double(100), knight1.getLife());
		
		soldier1.giveSpecialItem();
		
	}
	
	
	@Test
	public void testMoveUnit() {
	
		System.out.println("###############################");
		System.out.println("Test testMoveUnit");
		
		Unit soldier1 = new Soldier(0,0);
		
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
