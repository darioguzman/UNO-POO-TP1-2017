package ar.edu.uno.testcase;

import junit.framework.TestCase;

import org.junit.Test;

import ar.edu.uno.units.Knight;
import ar.edu.uno.units.Soldier;


public class KnightTestCase extends TestCase {
	
	@Test
	public void testAttackToUnitOutOfRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitOutOfRange");
		
		Knight knight1 = new Knight(0, 0);
		
		Knight knight2 = new Knight(3, 3);
		
		knight1.attackToUnit(knight2);
		
		assertEquals(200.0, knight2.getLife());
		
		assertEquals(false, knight1.isHorseRebellious());
		
	}
	
	@Test
	public void testAttackToUnitInRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitInRange");
		
		Knight knight1 = new Knight(0, 0);
		
		Knight knight2 = new Knight(2, 2);
		
		knight1.attackToUnit(knight2);
		
		assertEquals(150.0, knight2.getLife());
		
		assertEquals(false, knight1.isHorseRebellious());
	}
	
	@Test
	public void testKnightDead() {
	
		System.out.println("###############################");
		System.out.println("Test testKnightDead");
		
		Knight knight1 = new Knight(0, 0);
		
		Knight knight2 = new Knight(2, 2);
		
		knight1.setLife(0.0);
		
		knight1.attackToUnit(knight2);
		
		assertEquals(200.0, knight2.getLife());
		
	}
	
	@Test
	public void testKnightAttackWhenHorseIsRebellious() {
	
		System.out.println("###############################");
		System.out.println("Test testKnightAttackWhenHorseIsRebellious");
		
		Knight knight1 = new Knight(0, 0);
		
		Knight knight2 = new Knight(2, 2);
		
		knight1.getHorse().setNumberOfExecutedAttacks(4);
		
		knight1.attackToUnit(knight2);
		
		assertEquals(200.0,knight2.getLife());
		
		assertEquals(true , knight1.isHorseRebellious());
		
	}
	
	@Test
	public void testKnightAttackUnitDead() {
	
		System.out.println("###############################");
		System.out.println("Test testKnightAttackUnitDead");
		
		Knight knight1 = new Knight(0, 0);
		
		Knight knight2 = new Knight(2, 2);
		
		knight2.setLife(0.0);
		
		knight1.attackToUnit(knight2);
		
		assertEquals(0.0, knight2.getLife());
		
		assertEquals(new Integer (0), knight1.getHorse().getNumberOfExecutedAttacks());
		
	}
	
	@Test
	public void testAttackUntilTheHorseBecomesRebellious(){
		
		System.out.println("###############################");
		System.out.println("Test testAttackUntilTheHorseBecomesRebellious");
		
		Soldier soldier1 = new Soldier(0,0);
		
		Knight knight1 = new Knight(1,1);
		
		knight1.attackToUnit(soldier1);
		knight1.attackToUnit(soldier1);
		
		assertEquals(false, knight1.isHorseRebellious());
		assertEquals(new Integer(2), knight1.getHorse().getNumberOfExecutedAttacks());

		knight1.attackToUnit(soldier1);
		
		assertEquals(new Integer(3), knight1.getHorse().getNumberOfExecutedAttacks());
		
		assertEquals(true, knight1.isHorseRebellious());
		
		knight1.attackToUnit(soldier1);
		
		assertEquals(true, knight1.isHorseRebellious());
	}
	
	@Test
	public void testAttackItself(){
		
		System.out.println("###############################");
		System.out.println("Test testAttackItself");
		
		Knight knight = new Knight(0,0);
		
		knight.attackToUnit(knight);
		
		assertEquals(new Integer(0), knight.getHorse().getNumberOfExecutedAttacks());
		
		assertEquals(new Double(200.0), knight.getLife());
		
	}
	
	@Test
	public void testMoveUnit() {
	
		System.out.println("###############################");
		System.out.println("Test testMoveUnit");
		
		Knight knight = new Knight(0,0);
		
		knight.move(1, 1);
		
		assertEquals(new Integer(1), knight.getCoordanateX());
		assertEquals(new Integer(1), knight.getCoordanateY());
		
		knight.move(2, 2);
		
		assertEquals(new Integer(3), knight.getCoordanateX());
		assertEquals(new Integer(3), knight.getCoordanateY());
		
		knight.move(4, 4);
		
		assertEquals(new Integer(7), knight.getCoordanateX());
		assertEquals(new Integer(7), knight.getCoordanateY());
		
		knight.move(0, 1);
		
		assertEquals(new Integer(7), knight.getCoordanateX());
		assertEquals(new Integer(8), knight.getCoordanateY());

		knight.move(1, 0);
		
		assertEquals(new Integer(8), knight.getCoordanateX());
		assertEquals(new Integer(8), knight.getCoordanateY());
		
		knight.move(6, 6);
		
		assertEquals(new Integer(8), knight.getCoordanateX());
		assertEquals(new Integer(8), knight.getCoordanateY());
		
		
	}
	
}
