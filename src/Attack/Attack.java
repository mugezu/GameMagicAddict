package Attack;

import Hesoes.Hero;
import Hesoes.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.09.2016.
 */
public abstract class Attack {
    protected Hero our;
    protected List<Hero> enemy;
    protected List<Hero> herous;
    protected int id;
    //переменная с инфой про скиллы
    protected List<InfoSkill> attackInfo = new ArrayList<InfoSkill>();
    List<ArrayList> damageLists;
    List<ArrayList> typesAttack;
    List<ArrayList> typesEffect;

    public Attack(List<Hero> herous, Hero our, List<Hero> enemy) {
        this.our = our;
        this.enemy = enemy;
        this.herous = herous;
    }

    public void attack(int id) {
        Hero target = null;
        System.out.println("Использовано "+ attackInfo.get(id).getName());
        for (int i = 0; i < attackInfo.get(id).getDamageList().size(); i++) {
            switch (attackInfo.get(id).getTypeAttack(i)) {
                case Point: {
                    int value = 0;
                    if (i == 0) {
                        target = choiseTarget(enemy);
                    }
                    if (attackInfo.get(id).getRank() == 1 || attackInfo.get(id).getRank() == 2) {
                        value = -attackInfo.get(id).getDamageList().get(i);
                    }
                    if (attackInfo.get(id).getRank() == 3) {
                        value = (int) ((-attackInfo.get(id).getDamageList().get(i)) * 1.5);
                    }

                    if (attackInfo.get(id).getRank() >= 2) {
                        if (attackInfo.get(id).getEffeckt().get(i) == TypeBuffDebuff.None) ;
                        else {
                            boolean flag = false;
                            for (int j = 0; j < target.getEffeckt().size(); j++)
                                if (target.getEffeckt().get(j) == attackInfo.get(id).getEffeckt().get(i)) {
                                    target.getTurnStopEffeckt().set(j, (attackInfo.get(id).getTime() + Hero.getCurrentTurn()));
                                    flag = true;
                                }
                            if (flag == false) {
                                target.setEffeckt(attackInfo.get(id).getEffeckt().get(i));
                                target.setTurnStopEffeckt(attackInfo.get(id).getTime());
                            }
                        }
                    }
                    target.changeHp(value, our);
                    break;
                }
                case Mass: {
                    // Hero target = choiseTarget(enemy);
                    int value = 0;
                    for (Hero targe : enemy) {

                        if (attackInfo.get(id).getRank() == 1 || attackInfo.get(id).getRank() == 2) {
                            value = -attackInfo.get(id).getDamageList().get(i);
                        }
                        if (attackInfo.get(id).getRank() == 3) {
                            value = (int) ((-attackInfo.get(id).getDamageList().get(i)) * 1.5);
                        }
                        if (attackInfo.get(id).getRank() >= 2) {
                            if (attackInfo.get(id).getEffeckt().get(i) == TypeBuffDebuff.None) ;
                            else {
                                boolean flag = false;
                                for (int j = 0; j < targe.getEffeckt().size(); j++)
                                    if (targe.getEffeckt().get(j) == attackInfo.get(id).getEffeckt().get(i)) {
                                        targe.getTurnStopEffeckt().set(j, (attackInfo.get(id).getTime() + Hero.getCurrentTurn()));
                                        flag = true;
                                    }
                                if (flag == false) {
                                    targe.setEffeckt(attackInfo.get(id).getEffeckt().get(i));
                                    targe.setTurnStopEffeckt(attackInfo.get(id).getTime());
                                }
                            }

                        }
                        targe.changeHp(value, our);
                    }
                    break;
                }
                case PointFriend: {
                    int value = 0;
                    if (i == 0) {
                        target = choiseTarget(herous);
                    }
                    if (attackInfo.get(id).getRank() == 1 || attackInfo.get(id).getRank() == 2) {
                        value = attackInfo.get(id).getDamageList().get(i);
                    }
                    if (attackInfo.get(id).getRank() == 3) {
                        value = (int) ((attackInfo.get(id).getDamageList().get(i)) * 1.5);
                    }
                    if (attackInfo.get(id).getRank() >= 2) {
                        if (attackInfo.get(id).getEffeckt().get(i) == TypeBuffDebuff.None) ;
                        else {
                            boolean flag = false;
                            for (int j = 0; j < target.getEffeckt().size(); j++)
                                if (target.getEffeckt().get(j) == attackInfo.get(id).getEffeckt().get(i)) {
                                    target.getTurnStopEffeckt().set(j, (attackInfo.get(id).getTime() + Hero.getCurrentTurn()));
                                    flag = true;
                                }
                            if (flag == false) {
                                target.setEffeckt(attackInfo.get(id).getEffeckt().get(i));
                                target.setTurnStopEffeckt(attackInfo.get(id).getTime());
                            }
                        }

                    }
                    target.changeHp(value, our);
                    break;
                }
                case MassFriend: {
                    int value = 0;
                    for (Hero targe : herous) {

                        if (attackInfo.get(id).getRank() == 1 || attackInfo.get(id).getRank() == 2) {
                            value = attackInfo.get(id).getDamageList().get(i);
                        }
                        if (attackInfo.get(id).getRank() == 3) {
                            value = (int) ((attackInfo.get(id).getDamageList().get(i)) * 1.5);
                        }
                        if (attackInfo.get(id).getRank() >= 2) {
                            if (attackInfo.get(id).getEffeckt().get(i) == TypeBuffDebuff.None) ;
                            else {
                                boolean flag = false;
                                for (int j = 0; j < targe.getEffeckt().size(); j++)
                                    if (targe.getEffeckt().get(j) == attackInfo.get(id).getEffeckt().get(i)) {
                                        targe.getTurnStopEffeckt().set(j, (attackInfo.get(id).getTime() + Hero.getCurrentTurn()));
                                        flag = true;
                                    }
                                if (flag == false) {
                                    targe.setEffeckt(attackInfo.get(id).getEffeckt().get(i));
                                    targe.setTurnStopEffeckt(attackInfo.get(id).getTime());
                                }
                            }
                        }
                        targe.changeHp(value, our);
                    }
                    break;
                }
                case HimSelf:{
                    int value = 0;
                        target = our;
                    if (attackInfo.get(id).getRank() == 1 || attackInfo.get(id).getRank() == 2) {
                        value = attackInfo.get(id).getDamageList().get(i);
                    }
                    if (attackInfo.get(id).getRank() == 3) {
                        value = (int) ((attackInfo.get(id).getDamageList().get(i)) * 1.5);
                    }
                    if (attackInfo.get(id).getRank() >= 2) {
                        if (attackInfo.get(id).getEffeckt().get(i) == TypeBuffDebuff.None) ;
                        else {
                            boolean flag = false;
                            for (int j = 0; j < target.getEffeckt().size(); j++)
                                if (target.getEffeckt().get(j) == attackInfo.get(id).getEffeckt().get(i)) {
                                    target.getTurnStopEffeckt().set(j, (attackInfo.get(id).getTime() + Hero.getCurrentTurn()));
                                    flag = true;
                                }
                            if (flag == false) {
                                target.setEffeckt(attackInfo.get(id).getEffeckt().get(i));
                                target.setTurnStopEffeckt(attackInfo.get(id).getTime());
                            }
                        }

                    }
                    target.changeHp(value, our);
                    break;

                }
            }
        }
        our.changeMp(-attackInfo.get(id).getManaCost());
    }

    //список доступных скиллов
    public void listAllSkill() {
        for (InfoSkill a : attackInfo)
            if (a.getLevel() <= our.getLevel())
                System.out.println(a.toString());
    }

    //список скилов в активных слотах
    public void listActiveStot() {
        System.out.println("0. Назад");
        for (int i = 0; i < our.getSlotSkill().size(); i++)
            // System.out.println(our.getSlotSkill().get(i));
            System.out.println(i + 1 + ". " + attackInfo.get(our.getSlotSkill().get(i)).getName());
    }


    //база данных скиллов
    public boolean listSkill() {
        int choise;
        boolean flag = false;
        do {
            do {
                choise = util.read("выберете скилл") - 1;
                if (choise == -1) return false;
            } while (choise <= -1 || choise > our.getSlotSkill().size() - 1);
            if (manaCheck(our.getSlotSkill().get(choise)))
                flag = true;
            else {
                flag = false;
                System.out.println("/nНехватает маны");
            }
        } while (!flag);
        attack(our.getSlotSkill().get(choise));
        return true;
    }


    public Attack(Hero our) {
        this.our = our;
    }


    public boolean manaCheck(int id) {
        return (our.getCurrentMp() - attackInfo.get(id).getManaCost()) > 0;
    }

    public Hero choiseTarget(List<Hero> targetList) {
        if (targetList.size() == 1)
            return targetList.get(0);
        else {
            int target;
            boolean flag = false;
            do {
                do {
                    target = util.read("Выберете цель") - 1;
                } while (target < 0 || target > targetList.size());
                if (targetList.get(target).isOpportunityAttackHero()) flag = false;
                else {
                    flag = true;
                    System.out.print("Невожмоно выбрать данную цель");
                }
            } while (flag);
            return targetList.get(target);

        }
    }

    protected void fillingInfoAttack() {
    }
}



