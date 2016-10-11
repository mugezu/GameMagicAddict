package Attack;

import Hesoes.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 12.09.2016.
 */
public class AttackMage extends Attack {

    public AttackMage(List<Hero> herous, Hero our, List<Hero> enemy) {
        super(herous, our, enemy);
        fillingInfoAttack();
    }

    public AttackMage(Hero our) {
        super(our);
        fillingInfoAttack();
        //attackInfo.add(new InfoSkill(1,1,"Ледяная стрела","",1));
    }

    protected void fillingInfoAttack() {
        Random rand = new Random();

        Integer stroka[][] = {
                {10,0},
                {37},
                {4, 5, 6, 7, 8, 9},
                {100},
                {37,0}
        };

        damageLists = new ArrayList<ArrayList>();
        for (int i = 0; i < stroka.length; i++) {
            ArrayList<Integer> loc = new ArrayList<Integer>();
            for (int j = 0; j < stroka[i].length; j++) {
                loc.add(stroka[i][j]);
            }
            damageLists.add(loc);
            loc = null;
        }
        TypeAttack strokaT[][] = {{TypeAttack.Point,TypeAttack.HimSelf},
                {TypeAttack.Point},
                {TypeAttack.Point, TypeAttack.Point, TypeAttack.Point, TypeAttack.Point, TypeAttack.Point, TypeAttack.Point},
                {TypeAttack.PointFriend},
                {TypeAttack.Point,TypeAttack.HimSelf}
        };

        typesAttack = new ArrayList<ArrayList>();
        for (int i = 0; i < strokaT.length; i++) {
            ArrayList<TypeAttack> locT = new ArrayList<TypeAttack>();
            for (int j = 0; j < strokaT[i].length; j++) {

                locT.add(strokaT[i][j]);
            }
            typesAttack.add(locT);
            locT = null;
        }
        TypeBuffDebuff strokaE[][] = {{TypeBuffDebuff.Stun,TypeBuffDebuff.None},
                {TypeBuffDebuff.debuffArmor},
                {TypeBuffDebuff.None, TypeBuffDebuff.None, TypeBuffDebuff.None, TypeBuffDebuff.None, TypeBuffDebuff.None, TypeBuffDebuff.None},
                {TypeBuffDebuff.None},
                {TypeBuffDebuff.debuffAgillity,TypeBuffDebuff.buffAgillity}
        };

        typesEffect = new ArrayList<ArrayList>();
        for (int i = 0; i < strokaE.length; i++) {
            ArrayList<TypeBuffDebuff> locE = new ArrayList<>();
            for (int j = 0; j < strokaT[i].length; j++) {

                locE.add(strokaE[i][j]);
            }
            typesEffect.add(locE);
            locE = null;
        }
        int i = 0;
        attackInfo.add(new InfoSkill(1, 1, "Ледяная стрела", "", 2, (int) (27 * our.getLevel() * 0.5), damageLists.get(i), typesAttack.get(i), typesEffect.get(i++), 2));
        attackInfo.add(new InfoSkill(2, 1, "Огненная глыба", "", 2, (int) (30 * our.getLevel() * 0.5), damageLists.get(i), typesAttack.get(i), typesEffect.get(i++), 3));
        attackInfo.add(new InfoSkill(3, 4, "Енергетический поток", "", 1, (int) (27 * our.getLevel() * 0.5), damageLists.get(i), typesAttack.get(i++)));
        attackInfo.add(new InfoSkill(4, 4, "Лечение", "", 1, (int) (27 * our.getLevel() * 0.5), damageLists.get(i), typesAttack.get(i++)));
        attackInfo.add(new InfoSkill(5, 4, "Подрезать сухожилье", "", 2, (int) (30 * our.getLevel() * 0.5), damageLists.get(i), typesAttack.get(i), typesEffect.get(i++), 2));
    }
}
