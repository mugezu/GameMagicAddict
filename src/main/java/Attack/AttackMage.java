package Attack;

import Hesoes.Hero;

import java.util.List;

/**
 * Created by user on 12.09.2016.
 */
public class AttackMage extends Attack {

    public AttackMage(List<Hero> herous, Hero our, List<Hero> enemy) {
        super(herous, our, enemy);
        loadFromFile();
        for (InfoSkill s: attackInfo) {
            s.setManaCost((int)(our.getLevel()*s.getManaCost()*0.5));
        }
    }

    public AttackMage(Hero our) {
        super(our);
        loadFromFile();
        for (InfoSkill s: attackInfo) {
            s.setManaCost((int)(our.getLevel()*s.getManaCost()*0.5));
        }
    }


}
