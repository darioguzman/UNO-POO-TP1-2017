package ar.edu.uno.testcase;

import org.junit.Test;

import ar.edu.uno.units.Lancer;
import junit.framework.TestCase;


public class LancerTestCase extends TestCase {
	
	@Test
	public void testAttackToUnitOutOfRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitOutOfRange");
		
		Lancer lancer1 = new Lancer(0, 0);
		
		Lancer lancer2 = new Lancer(4, 4);
		
		lancer1.attackToUnit(lancer2);
		
		assertEquals(150.0, lancer2.getLife());
		
	}
	
	@Test
	public void testAttackToUnitInRange() {
	
		System.out.println("###############################");
		System.out.println("Test testAttackToUnitInRange");
		
		Lancer lancer1 = new Lancer(0, 0);
		
		Lancer lancer2 = new Lancer(1, 1);
		
		lancer1.attackToUnit(lancer2);
		
		assertEquals(125.0, lancer2.getLife());
		
	}
	
	@Test
	public void testLancerDead() {
	
		System.out.println("###############################");
		System.out.println("Test testLancerDead");
		
		Lancer lancer1 = new Lancer(0, 0);
		
		Lancer lancer2 = new Lancer(2, 2);
		
		lancer1.setLife(0.0);
		
		lancer1.attackToUnit(lancer2);
		
		assertEquals(150.0, lancer2.getLife());
		
	}
	
	@Test
	public void testLancerAttackUnitDead() {
	
		System.out.println("###############################");
		System.out.println("Test testLancerAttackUnitDead");
		
		Lancer lancer1 = new Lancer(0, 0);
		
		Lancer lancer2 = new Lancer(2, 2);
		
		lancer2.setLife(0.0);
		
		lancer1.attackToUnit(lancer2);
		
		assertEquals(0.0, lancer2.getLife());
		
	}
	
	@Test
	public void testAttackItself(){
		
		System.out.println("###############################");
		System.out.println("Test testAttackItself");
		
		Lancer lancer = new Lancer(0, 0);
		
		lancer.attackToUnit(lancer);
		
		assertEquals(new Double(150.0), lancer.getLife());
		
	}
	
	@Test
	public void testMoveUnit() {
	
		System.out.println("###############################");
		System.out.println("Test testMoveUnit");
		
		Lancer lancer = new Lancer(0,0);
		
		lancer.move(1, 1);
		
		assertEquals(new Integer(1), lancer.getCoordanateX());
		assertEquals(new Integer(1), lancer.getCoordanateY());
		
		lancer.move(2, 2);
		
		assertEquals(new Integer(3), lancer.getCoordanateX());
		assertEquals(new Integer(3), lancer.getCoordanateY());
		
		lancer.move(4, 4);
		
		assertEquals(new Integer(3), lancer.getCoordanateX());
		assertEquals(new Integer(3), lancer.getCoordanateY());
		
		lancer.move(0, 1);
		
		assertEquals(new Integer(3), lancer.getCoordanateX());
		assertEquals(new Integer(4), lancer.getCoordanateY());

		lancer.move(1, 0);
		
		assertEquals(new Integer(4), lancer.getCoordanateX());
		assertEquals(new Integer(4), lancer.getCoordanateY());
		
		
		
	}
	
	
}
