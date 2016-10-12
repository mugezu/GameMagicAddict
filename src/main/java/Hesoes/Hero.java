package Hesoes;

import Attack.TypeBuffDebuff;
import Battle.Fight;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 12.09.2016.
 */
public abstract class Hero implements Serializable {
    protected ClassType clas;
    protected final int quantitySlotSkill = 6;
    protected String name = null;
    protected int step = 0;
    protected int level = 55;
    protected int hp = 100;
    protected int mp = 100;
    protected int armor = 10;
    protected int power = 0;//force
    protected int intellect = 0;//force
    protected int stamina = 0;//xp*stamina
    protected int spirit = 0;//mp*spirit
    protected int agillity = 0;//agillity*3 %
    protected int hit = 0;//hit*2 %
    protected int currentHp = hp;
    protected int currentMp = mp;
    protected int currentArmor = 10;
    protected int currentPower = 0;//force
    protected int currentIntellect = 0;//force
    protected int currentAgillity = 0;//agillity*3 %
    protected int currentHit = 0;//hit*2 %
    protected boolean opportunityAttackHero = true; //возможность атаковать его
    protected boolean opportunityAttack = true;
    protected static int currentTurn = 1;
    protected List<Integer> slotSkill = new ArrayList<>(6);
    protected List<Integer> turnStopEffeckt = new ArrayList<>();
    protected List<TypeBuffDebuff> effeckt = new ArrayList<>();

    public ClassType getClas() {
        return clas;
    }

    public void setClas(ClassType clas) {
        this.clas = clas;
    }

    protected void help() {
        slotSkill.add(0);
        slotSkill.add(1);
        slotSkill.add(3);
        slotSkill.add(4);
        hp = 100 * stamina;
        mp = 50 * spirit;
        currentArmor = armor;
        currentAgillity = agillity;
        currentIntellect = intellect;
        currentPower = power;
        currentHit = hit;
        currentHp = hp;
        currentMp = mp;
    }

    public void saveProgress() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);
        FileWriter FW = null;
        try {
            FW = new FileWriter("D:\\Save.txt", false);
            FW.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (FW!=null)
                    FW.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Hero loadProgress() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder builder = new StringBuilder();
        FileReader FR = null;
        int c;
        try {
            FR = new FileReader("D:\\Save.txt");
            while ((c = FR.read()) != -1) {
                builder.append((char) c);
            }
            String tmp=builder.toString();
            if (tmp.contains("Mage"))
            return gson.fromJson(tmp,Mage.class).copy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (FR!=null)
                    FR.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public Hero copy(){
        return (Hero)this;
    }
    public List<Integer> getSlotSkill() {
        return slotSkill;
    }

    public void showInfo() {
        System.out.print(name + ": здоровье - " + currentHp + "/" + hp + " мана - " + currentMp + "/" + mp + life() + "\n");
    }


    public String life() {
        if (currentHp > 0 && !isOpportunityAttackHero()) return (" неуязвим");
        else if (currentHp > 0 && isOpportunityAttackHero()) return "";
        else return " мертв";
    }

    public void battleMenu(List<Hero> Herous, List<Hero> enemy) {
        int choise;
        System.out.println();
        //  System.out.println(opportunityAttack);
        if (opportunityAttack == false) return;
        System.out.println("Ход " + this.getName());
        System.out.println
                ("1. Использовать способность\n" +
                        "2. Инвентарь\n" +
                        "3. Пропустить ход\n" +
                        "4. Сбежать");
        do {
            choise = util.read("Выберете пункт меню");
        } while (choise < 0 || choise > 4);
        switch (choise) {
            case 1: {
                this.listAttack(Herous, enemy);
                break;
            }
            case 2: {
                System.out.println("В режиме разработки");
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                //если да то выйти в ту же локацию
                if (Fight.leaveBattle(Herous, enemy)) {
                    break;
                } else battleMenu(Herous, enemy);
            }
        }
    }

    public void listAttack(List<Hero> Herous, List<Hero> enemy) {
    }

    public void listAttack() {
    }

    public void onEffect(Hero enemy) {
        for (TypeBuffDebuff eff : effeckt) {
            switch (eff) {
                case Stun: {
                    this.opportunityAttack = false;
                    break;
                }
                case debuffArmor: {
                    if (enemy.getCurrentIntellect() > enemy.getCurrentPower()) {
                        this.currentArmor = (int) (this.currentArmor - (this.currentArmor / 100 * (10 + enemy.getCurrentIntellect() / 4)));
                    } else
                        this.currentArmor = (int) (this.currentArmor - (this.currentArmor / 100 * (10 + enemy.getCurrentPower() / 4)));
                    break;
                }
                case debuffAgillity: {
                    if (enemy.getCurrentIntellect() > enemy.getCurrentPower()) {
                        this.currentAgillity = (int) (this.currentAgillity - (this.currentAgillity / 100 * (10 + enemy.getCurrentIntellect() / 4)));
                    } else
                        this.currentAgillity = (int) (this.currentAgillity - (this.currentAgillity / 100 * (10 + enemy.getCurrentPower() / 4)));

                }
                case buffAgillity: {
                    if (enemy.getCurrentIntellect() > enemy.getCurrentPower()) {
                        this.currentAgillity = (int) (this.currentAgillity + (this.currentAgillity / 100 * (10 + enemy.getCurrentIntellect() / 4)));
                    } else
                        this.currentAgillity = (int) (this.currentAgillity + (this.currentAgillity / 100 * (10 + enemy.getCurrentPower() / 4)));
                }

            }
        }
    }

    public void offEffect() {
        for (int i = 0; i < turnStopEffeckt.size(); i++) {
            if (turnStopEffeckt.get(i) <= currentTurn) {
                switch (effeckt.get(i)) {
                    case Stun: {
                        this.opportunityAttack = true;
                        effeckt.remove(i);
                        turnStopEffeckt.remove(i);
                        break;
                    }
                    case debuffArmor: {
                        this.currentArmor = armor;
                        effeckt.remove(i);
                        turnStopEffeckt.remove(i);
                        break;
                    }
                    case debuffAgillity: {
                        this.currentAgillity = agillity;
                        effeckt.remove(i);
                        turnStopEffeckt.remove(i);
                        break;
                    }
                    case buffAgillity: {
                        this.currentAgillity = agillity;
                        effeckt.remove(i);
                        turnStopEffeckt.remove(i);
                        break;
                    }

                }
                i--;
            }
        }
    }

    public void changeHp(int value, Hero enemy) {
        onEffect(enemy);
        if (value < 0) {
            Random rand = new Random();
            if ((rand.nextInt(99) + 1) > ((currentAgillity * 3) - enemy.getCurrentHit() * 2)) {
                int damage = (int) (value * (150.0) / ((double) currentArmor + 150.0));
                currentHp += damage;
                if (currentHp < 0) {
                    opportunityAttackHero = false;
                    opportunityAttack = false;
                    currentHp = 0;
                }
                System.out.print(this.getName() + " получил(а) " + damage + "/" + value + " урона от " + enemy.getName() + "\n");
            } else {
                System.out.print("Промах\n");
            }
        } else {
            currentHp += value;
            System.out.println(enemy.getName() + " вылечил(а) " + value + " hp " + getName());
            if (currentHp > hp)
                currentHp = hp;
        }
        System.out.println("Текущая ловкость" + currentAgillity);

    }

    public void changeMp(int value) {

        if (value < 0) {
            currentMp += value;
        } else {
            currentMp += value;
            if (currentMp > mp)
                currentMp = mp;
        }
    }

    public boolean isOpportunityAttackHero() {
        return opportunityAttackHero;
    }

    public void setOpportunityAttackHero(boolean opportunityAttackHero) {
        this.opportunityAttackHero = opportunityAttackHero;
    }

    public boolean isOpportunityAttack() {
        return opportunityAttack;
    }

    public void setOpportunityAttack(boolean opportunityAttack) {
        this.opportunityAttack = opportunityAttack;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getArmor() {
        return armor;
    }

    public int getPower() {
        return power;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getStamina() {
        return stamina;
    }

    public int getSpirit() {
        return spirit;
    }

    public int getAgillity() {
        return agillity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp = currentMp;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public void setAgillity(int agillity) {
        this.agillity = agillity;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getHit() {
        return hit;
    }

    public static int getCurrentTurn() {
        return currentTurn;
    }

    public static void setCurrentTurn(int currentTurn) {
        Hero.currentTurn = currentTurn;
    }

    public List<Integer> getTurnStopEffeckt() {
        return turnStopEffeckt;
    }

    public void setTurnStopEffeckt(Integer turnStopEffeckt) {
        this.turnStopEffeckt.add(turnStopEffeckt + currentTurn);
    }

    public List<TypeBuffDebuff> getEffeckt() {
        return effeckt;
    }

    public void setEffeckt(TypeBuffDebuff effeckt) {
        this.effeckt.add(effeckt);
    }

    public int getCurrentArmor() {
        return currentArmor;
    }

    public void setCurrentArmor(int currentArmor) {
        this.currentArmor = currentArmor;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    public int getCurrentIntellect() {
        return currentIntellect;
    }

    public void setCurrentIntellect(int currentIntellect) {
        this.currentIntellect = currentIntellect;
    }

    public int getCurrentAgillity() {
        return currentAgillity;
    }

    public void setCurrentAgillity(int currentAgillity) {
        this.currentAgillity = currentAgillity;
    }

    public int getCurrentHit() {
        return currentHit;
    }

    public void setCurrentHit(int currentHit) {
        this.currentHit = currentHit;
    }
}


