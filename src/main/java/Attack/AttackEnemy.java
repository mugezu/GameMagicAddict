package Attack;

import Hesoes.Hero;

import java.util.List;
import java.util.Random;

/**
 * Created by user on 12.09.2016.
 */
public class AttackEnemy extends Attack {

    public AttackEnemy(List<Hero> herous, Hero our, List<Hero> enemy) {
        super(herous, our, enemy);
        switch (our.getClas()) {
            case Mage: {
                AttackEnemyMage a = new AttackEnemyMage(our);
                this.attackInfo = a.attackInfo;
                break;
            }
            case Warrior: {
                AttackEnemyWarrior a = new AttackEnemyWarrior(our);
                this.attackInfo = a.attackInfo;
                break;
            }
            case Priest: {
                AttackEnemyPriest a = new AttackEnemyPriest(our);
                this.attackInfo = a.attackInfo;
                break;
            }
            case Rogue: {
                AttackEnemyRogue a = new AttackEnemyRogue(our);
                this.attackInfo = a.attackInfo;
                break;
            }
        }
    }

    public AttackEnemy(Hero our) {
        super(our);
        loadFromFile();
        for (InfoSkill s: attackInfo) {
            s.setManaCost((int)(our.getLevel()*s.getManaCost()*0.5));
        }
    }

    public boolean listSkill() {
        Random rand = new Random();
        int choise;
        for (int i = 0; i < our.getSlotSkill().size(); i++) {
            if (manaCheck(our.getSlotSkill().get(i))) {
                boolean flag = false;
                do {
                    do {
                        choise = rand.nextInt(our.getSlotSkill().size()) - 0;
                    } while (choise <= -1 || choise > our.getSlotSkill().size() - 1);
                    if (manaCheck(our.getSlotSkill().get(choise)))
                        flag = true;
                    else {
                        flag = false;
                    }
                } while (!flag);
                attack(our.getSlotSkill().get(choise));
                return true;
            }
        }
        return true;

    }

    public Hero choiseTarget(List<Hero> targetList) {
        Random rand = new Random();
        if (targetList.size() == 1)
            return targetList.get(0);
        else {
            int target;
            boolean flag = false;
            do {
                do {
                    target = rand.nextInt(targetList.size());
                } while (target < 0 || target > targetList.size());
                if (targetList.get(target).isOpportunityAttackHero()) flag = false;
                else {
                    flag = true;
                }
            } while (flag);
            return targetList.get(target);

        }
    }


}