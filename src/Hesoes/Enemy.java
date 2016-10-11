package Hesoes;

import Attack.AttackEnemy;

import java.util.List;

/**
 * Created by user on 12.09.2016.
 */
public class Enemy extends Hero {
    public Enemy(String name) {
        this.name = name;

        power = 1;
        intellect = 5;

        stamina = 2;
        spirit = 4;
        agillity = 20;
        hit = 3;
        help();
    }

    public void battleMenu(List<Hero> Herous, List<Hero> enemy) {
        if (!opportunityAttack )
            return;
        else
            this.listAttack(Herous, enemy);
    }

    @Override
    public void listAttack(List<Hero> heroes, List<Hero> enemy) {
        new AttackEnemy(heroes, this, enemy).listSkill();

    }


}

