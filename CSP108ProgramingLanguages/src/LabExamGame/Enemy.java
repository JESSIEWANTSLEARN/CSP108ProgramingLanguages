package LabExamGame;

public class Enemy extends Entity {
    private String specialSkill;

    public Enemy(int type) {
        super("Unknown Monster", 50, 0, 10, 2, 0.05, 0.02);
        setupMonster(type);
    }

    private void setupMonster(int type) {
        if (type == 0) {
            this.name = "Goblin"; this.maxHp = 40; this.hp = 40; this.atk = 10; this.def = 2; this.specialSkill = "Dagger Slash";
        } else if (type == 1) {
            this.name = "Orc"; this.maxHp = 75; this.hp = 75; this.atk = 16; this.def = 6; this.specialSkill = "Club Smash";
        } else if (type == 2) {
            this.name = "Baby Dragon"; this.maxHp = 110; this.hp = 110; this.atk = 22; this.def = 10; this.specialSkill = "Fire Breath";
        } else {
            this.name = "Niki Minaj the Black Dragon (BOSS)"; 
            this.maxHp = 250; this.hp = 250; 
            this.atk = 35; this.def = 18; 
            this.critChance = 0.15; this.dodgeChance = 0.05;
            this.specialSkill = "My Anaconda Breath";
        }
    }

    @Override
    public int executeAttack(int choice, Entity target) {
        int damage;
        // Boss rolls
        double specialMoveOdds = this.name.contains("BOSS") ? 0.25 : 0.25;

        if (random.nextDouble() < specialMoveOdds) {
            System.out.println("\n" + name + " releases its ultimate move: " + specialSkill + "!");
            damage = calculateDamageValue((int)(atk * 1.5), target.getDef(), critChance);
        } else {
            System.out.println(name + " lunges forward with a crushing basic strike.");
            damage = calculateDamageValue(atk, target.getDef(), critChance);
        }
        return damage;
    }
}