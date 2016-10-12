package Battle;

import Hesoes.Hero;

import java.util.List;
import java.util.Random;

/**
 * Created by user on 13.09.2016.
 */
public class Fight {
    public static void fight(List<Hero> herous, List<Hero> enemys) {
        while (!checkHp(herous) && !checkHp(enemys)) {
            GroupInfo(herous);
            GroupInfo(enemys);
            System.out.println("Ход номер - "+ enemys.get(0).getCurrentTurn());
            System.out.println("Ход героев");
            offEffectGroup(herous);
            groupMenuBattle(herous,enemys);
            enemys.get(0).setCurrentTurn(enemys.get(0).getCurrentTurn()+1);
            System.out.println("Ход номер - "+ enemys.get(0).getCurrentTurn());
            System.out.println("Ход врагов");
            offEffectGroup(enemys);
            groupMenuBattle(enemys,herous);
            enemys.get(0).setCurrentTurn(enemys.get(1).getCurrentTurn()+1);
        }
        System.out.println("Битва окончена");
    }

   /* private static void check(List<Hero> herous){
        for (Hero one : herous) {
            one.get
        }
    }*/
   private static void offEffectGroup(List<Hero> herous) {
       for (Hero one : herous) {
           one.offEffect();
       }
   }
    private static void groupMenuBattle(List<Hero> herous, List<Hero> enemys) {
        for (Hero one : herous) {
            one.battleMenu(herous,enemys);
        }
    }
    /*private static void list*/
    private static void GroupInfo(List<Hero> heros) {
        System.out.println();
        System.out.println("------------------------------------");
        for (Hero one : heros) {
            one.showInfo();
        }
    }
    public static boolean leaveBattle(List<Hero> herous, List<Hero> enemys){
        Random rand= new Random();
            switch (enemys.get(0).getLevel()-herous.get(0).getLevel()) {
                case 0: {
                    return true;
                              }
                case 1: {
                    if (rand.nextInt(5)<=4)
                    return true;
                    else return false;
                }
                case 2: {
                    if (rand.nextInt(5)<=3)
                        return true;
                    else return false;
                }
                case 3: {
                    if (rand.nextInt(5)<=2)
                        return true;
                    else return false;
                }
                case 4: {
                    if (rand.nextInt(5)<=1)
                        return true;
                    else return false;
                }
                default:{
                    return false;
                }
            }
    }
    private static boolean checkHp(List<Hero> list) {
        int flag = 0;
        for (Hero a : list) {
            if (a.getCurrentHp() <= 0)
                flag++;
        }
        return flag == list.size();
    }
}
