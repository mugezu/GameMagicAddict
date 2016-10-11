package Hesoes;

import Attack.AttackMage;

import java.util.List;

/**
 * Created by user on 12.09.2016.
 */
public class Mage extends Hero {
    public Mage(String name) {
        this.name = name;
        power = 1;
        intellect = 5;
        stamina = 2;
        spirit = 4;
        agillity = 20;
        hit = 20;
        clas=ClassType.Mage;
        help();
    }
   /* @Override
    public void battleMenu(List<Hero> Herous, List<Hero> enemy) {
        int choise;
        System.out.println("1. Атаковать врага\n2. ");
        do {
            choise = util.read("Выберете пункт меню") - 1;
        } while (choise < 0 || choise > 4);
    }*/

    @Override
    public void listAttack(List<Hero> heroes,List<Hero> enemy) {
        if (!this.isOpportunityAttack()){return;}
            else {
            AttackMage tmp = new AttackMage(heroes, this, enemy);
            tmp.listActiveStot();
          if( tmp.listSkill());
            else this.battleMenu(heroes,enemy);



        }
    }


}

