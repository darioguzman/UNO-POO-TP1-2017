package ar.edu.uno.funcionalidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ar.edu.uno.units.Archer;
import ar.edu.uno.units.Knight;
import ar.edu.uno.units.Lancer;
import ar.edu.uno.units.Soldier;
import ar.edu.uno.units.Unit;

public class Main {

	public static void main(String[] args) {

		Archer arc1 = new Archer(0, 0);
		Archer arc2 = new Archer(2, 2);

		Soldier sol1 = new Soldier(1, 1);
		Soldier sol2 = new Soldier(3, 3);

		Lancer lan1 = new Lancer(4, 4);
		Lancer lan2 = new Lancer(9, 9);

		Knight kni1 = new Knight(10, 10);
		Knight kni2 = new Knight(11, 11);

		List<Unit> equip1 = new ArrayList<Unit>();
		equip1.add(arc1);
		equip1.add(sol1);
		equip1.add(kni1);
		equip1.add(lan1);
		
		List<Unit> equip2 = new ArrayList<Unit>();
		equip2.add(arc2);
		equip2.add(sol2);
		equip2.add(kni2);
		equip2.add(lan2);

		equip1.get(0).attackToUnit(equip2.get(2));

		for (Unit unit : equip2) {
			for (Unit unit1 : equip1) {

				unit.attackToUnit(unit1);
			}

		}

		for (Unit unit : equip1) {
			for (Unit unit1 : equip2) {

				unit.attackToUnit(unit1);
			}

		}

		Unit unit = equip1.get(new Random().nextInt(equip1.size()));

		for (Unit unit3 : equip2) {

			unit.attackToUnit(unit3);

		}

		kni1.attackToUnit(kni2);
		kni1.attackToUnit(kni2);
		kni1.attackToUnit(kni2);
		kni1.giveWaterPotion();
		kni1.attackToUnit(kni2);
		kni1.attackToUnit(kni2);

	}

}
