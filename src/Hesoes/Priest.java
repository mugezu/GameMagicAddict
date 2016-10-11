package Hesoes;

/**
 * Created by user on 12.09.2016.
 */
public class Priest extends Hero {
    public Priest(String name) {
        this.name = name;
        power = 1;
        intellect = 4;
        stamina = 3;
        spirit = 5;
        agillity = 3;
        hit = 2;
        help();
        setClas(ClassType.Priest);
    }


}
