package Attack;

import Hesoes.Hero;

/**
 * Created by user on 15.09.2016.
 */
public class AttackEnemyMage extends AttackEnemy {


    public AttackEnemyMage(Hero our) {
        super(our);
        fillingInfoAttack();
        for (InfoSkill s: attackInfo) {
            s.setManaCost((int)(our.getLevel()*s.getManaCost()*0.5));
        }
    }


}
