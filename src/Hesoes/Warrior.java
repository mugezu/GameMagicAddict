package Hesoes;

/**
 * Created by user on 12.09.2016.
 */
public class Warrior extends Hero {
    public Warrior(String name) {
        this.name=name;

        power = 5;
        intellect = 1;

        stamina = 4;
        spirit = 2;
        agillity = 2;
        hit = 3;
        help();
        setClas(ClassType.Warrior);
    }




}
