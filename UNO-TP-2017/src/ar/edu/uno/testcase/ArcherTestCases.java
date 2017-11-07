package ar.edu.uno.testcase;

import junit.framework.TestCase;

import org.junit.Test;

import ar.edu.uno.units.Archer;
import ar.edu.uno.units.Lancer;


public class ArcherTestCases extends TestCase {
	
	@Test
	public void testAttackToUnitOutOfRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitOutOfRange");
		
		Archer archer1 = new Archer(0, 0);
		
		Archer archer2 = new Archer(0, 0);
		
		archer1.attackToUnit(archer2);
		
		assertEquals(50.0, archer2.getLife());
		
		assertEquals(new Integer(20), archer1.getArrows());
		
		archer2.move(1, 1);
		
		archer1.attackToUnit(archer2);
		
		assertEquals(50.0, archer2.getLife());
		
		assertEquals(new Integer(20), archer1.getArrows());
		
	}
	
	@Test
	public void testAttackToUnitInRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitInRange");
		
		Archer archer1 = new Archer(0, 0);
		
		Archer archer2 = new Archer(2, 2);
		
		archer1.attackToUnit(archer2);
		
		assertEquals(45.0, archer2.getLife());
		
		assertEquals(new Integer(19), archer1.getArrows());
	}
	
	@Test
	public void testArcherDead() {
	
		System.out.println("###############################");
		System.out.println("Test testArcherDead");
		
		Archer archer1 = new Archer(0, 0);
		
		Archer archer2 = new Archer(2, 2);
		
		archer1.setLife(0.0);
		
		archer1.attackToUnit(archer2);
		
		assertEquals(50.0, archer2.getLife());
		
		assertEquals(new Integer(20), archer1.getArrows());
		
	}
	
	@Test
	public void testArcherWithoutArrows() {
	
		System.out.println("###############################");
		System.out.println("Test testArcherWithoutArrows");
		
		Archer archer1 = new Archer(0, 0);
		
		Archer archer2 = new Archer(2, 2);
		
		archer1.setArrows(0);
		
		archer1.attackToUnit(archer2);
		
		assertEquals(50.0, archer2.getLife());
		
		assertEquals(new Integer(0), archer1.getArrows());
		
	}
	
	@Test
	public void testArcherAttackUnitDead() {
	
		System.out.println("###############################");
		System.out.println("Test testArcherAttackUnitDead");
		
		Archer archer1 = new Archer(0, 0);
		
		Archer archer2 = new Archer(2, 2);
		
		archer2.setLife(0.0);
		
		archer1.attackToUnit(archer2);
		
		assertEquals(0.0, archer2.getLife());
		
		assertEquals(new Integer(20), archer1.getArrows());
		
	}
	
	@Test
	public void testArcherWithoutArrowsAndAfterGiveArrowPackage() {
	
		System.out.println("###############################");
		System.out.println("Test testArcherWithoutArrowsAndAfterGiveArrowPackage");
		
		Archer archer1 = new Archer(0, 0);
		
		Archer archer2 = new Archer(2, 2);
		
		archer1.setArrows(0);
		
		archer1.attackToUnit(archer2);
		
		assertEquals(50.0, archer2.getLife());
		
		assertEquals(new Integer(0), archer1.getArrows());
		
		archer1.giveArrowsPackage();
		
		assertEquals(new Integer(6), archer1.getArrows());
		
	}
	
	@Test
	public void testArcherMaxArrowsAndGiveArrowPackage() {
	
		System.out.println("###############################");
		System.out.println("Test testArcherMaxArrowsAndGiveArrowPackage");
		
		Archer archer1 = new Archer(0, 0);
		
		assertEquals(new Integer(20), archer1.getArrows());
		
		archer1.giveArrowsPackage();
		
		assertEquals(new Integer(20), archer1.getArrows());
		
	}
	
	@Test
	public void testAttackItself(){
		
		System.out.println("###############################");
		System.out.println("Test testAttackItself");
		
		Archer archer = new Archer(0, 0);
		
		archer.attackToUnit(archer);
		
		assertEquals(new Double(50.0), archer.getLife());
		
	}
	
	@Test
	public void testMoveUnit() {
	
		System.out.println("###############################");
		System.out.println("Test testMoveUnit");
		
		Archer archer = new Archer(0,0);
		
		archer.move(1, 1);
		
		assertEquals(new Integer(1), archer.getCoordanateX());
		assertEquals(new Integer(1), archer.getCoordanateY());
		
		archer.move(2, 2);
		
		assertEquals(new Integer(1), archer.getCoordanateX());
		assertEquals(new Integer(1), archer.getCoordanateY());
		
		archer.move(4, 4);
		
		assertEquals(new Integer(1), archer.getCoordanateX());
		assertEquals(new Integer(1), archer.getCoordanateY());
		
		archer.move(0, 1);
		
		assertEquals(new Integer(1), archer.getCoordanateX());
		assertEquals(new Integer(2), archer.getCoordanateY());

		archer.move(1, 0);
		
		assertEquals(new Integer(2), archer.getCoordanateX());
		assertEquals(new Integer(2), archer.getCoordanateY());
		
		
		
	}
	
}
