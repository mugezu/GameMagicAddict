import Battle.Fight;
import Hesoes.EnemyMage;
import Hesoes.Hero;
import Hesoes.Mage;
import Other.SaveInfoSkilIInFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.09.2016.
 */
public class Main {
    public static void main(String... a) {
        new SaveInfoSkilIInFile().allSaveSkillFile();
        Hero Lenya = new Mage("Lenya");
        Hero ass = new EnemyMage("Враг1");
        Hero Lenya1 = new Mage("Lenya1");
        Hero ass1 = new EnemyMage("Враг2");
        Lenya1.saveProgress();
        Lenya=Lenya.loadProgress();
        System.out.println(Lenya.loadProgress());
        List<Hero> heroes = new ArrayList<>();
        heroes.add(Lenya);
        heroes.add(Lenya1);
        List<Hero> enemys = new ArrayList<>();
        enemys.add(ass);
        enemys.add(ass1);
        Fight.fight(heroes, enemys);
        //AttackMage aww=new AttackMage(Lenya);
        // aww.listAllSkill();
        // Lenya.listAttack(ass);
        //Fight.fight(Lenya,ass);
    }
}
