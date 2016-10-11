package Attack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 13.09.2016.
 */
public class InfoSkill {
    private int number;
    private int level;
    private String name;
    private String info = null;
    private int rank;
    private int manaCost;
    private ArrayList<Integer> damage = new ArrayList<>();
    private ArrayList<TypeAttack> typeAttack = new ArrayList<>();
    private ArrayList<TypeBuffDebuff>   effeckt=new ArrayList<>();;
    private Integer time;

    public InfoSkill(int number, int level, String name, String info, int rank, int manaCost, ArrayList<Integer> damage, ArrayList<TypeAttack> typeAttack, ArrayList<TypeBuffDebuff> effeckt, int time) {
        this.number = number;
        this.level = level;
        this.name = name;
        this.info = info;
        this.rank = rank;
        this.manaCost = manaCost;
        this.damage = damage;
        this.typeAttack = typeAttack;
        this.effeckt = effeckt;
        this.time = time;
    }

    public InfoSkill(int number, int level, String name, String info, int rank, int manaCost, ArrayList<Integer> damage, List<TypeAttack> typeAttack) {
        this.number = number;
        this.level = level;
        this.name = name;
        this.info = info;
        this.rank = rank;
        this.manaCost = manaCost;
        int i;

        for (i = 0; i < damage.size(); i++) {
            this.damage.add(damage.get(i));
            this.typeAttack.add(typeAttack.get(i));
        }
    }

    public String toString() {
        return number + ". " + name + " " + level + " " + rank + info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ArrayList<TypeBuffDebuff> getEffeckt() {
        return effeckt;
    }

    public void setEffeckt(ArrayList<TypeBuffDebuff> effeckt) {
        this.effeckt = effeckt;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public int getManaCost() {
        return manaCost;
    }

    public TypeAttack getTypeAttack(int i) {
        return typeAttack.get(i);
    }

    public void setTypeAttack(TypeAttack typeAttack, int i) {
        this.typeAttack.set(i, typeAttack);
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getDamage(int i) {
        return damage.get(i);
    }

    public void setDamage(int damage, int i) {
        this.damage.set(i, damage);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDamageList() {
        return damage;
    }

}
