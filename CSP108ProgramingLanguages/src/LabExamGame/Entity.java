package LabExamGame;

import java.util.Random;

public abstract class Entity {
    protected String name;
    protected int hp, maxHp, mp, maxMp, atk, def;
    protected double critChance, dodgeChance;
    protected Random random = new Random();

    public Entity(String name, int maxHp, int maxMp, int atk, int def, double critChance, double dodgeChance) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxMp = maxMp;
        this.mp = maxMp;
        this.atk = atk;
        this.def = def;
        this.critChance = critChance;
        this.dodgeChance = dodgeChance;
    }

    public boolean tryDodge() {
        return random.nextDouble() < dodgeChance;
    }

    public abstract int executeAttack(int choice, Entity target);


    protected int calculateDamageValue(int baseAtk, int targetDef, double currentCritChance) {
        boolean isCrit = random.nextDouble() < currentCritChance;
        int rawDamage = Math.max(1, baseAtk - (targetDef / 2));
        
        if (isCrit) {
            rawDamage = (int) (rawDamage * 1.5);
            System.out.print("[CRITICAL HIT] ");
        }
        return rawDamage;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = Math.max(0, Math.min(maxHp, hp)); }
    public int getMaxHp() { return maxHp; }
    public int getMp() { 
    	return mp; }
    public void setMp(int mp) {
    	this.mp = Math.max(0, Math.min(maxMp, mp)); }
    public int getMaxMp() { return maxMp; }
    public int getAtk() { return atk; }
    public int getDef() { return def; }
    public double getCritChance() { return critChance; }
    public double getDodgeChance() { return dodgeChance; }
}