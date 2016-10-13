package Attack;

import Hesoes.Hero;

import java.util.List;

/**
 * Created by user on 12.09.2016.
 */
public class AttackMage extends Attack {

    public AttackMage(List<Hero> herous, Hero our, List<Hero> enemy) {
        super(herous, our, enemy);

    }

    public AttackMage(Hero our) {
        super(our);

    }


}
