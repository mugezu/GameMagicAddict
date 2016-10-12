package Hesoes;

/**
 * Created by user on 12.09.2016.
 */
public class Rogue extends Hero {
    public Rogue(String name){
        this.name=name;

        power = 4;
        intellect = 1;

        stamina =2;
        spirit = 2;
        agillity = 4;
        hit = 5;
        help();
        setClas(ClassType.Rogue);
    }
}
