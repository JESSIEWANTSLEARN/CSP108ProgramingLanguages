package LabExamGame;

	public class Player extends Entity {
	    private String playerClass;
	    private String skillName, ultName;
	    private int skillCost, ultCost;
	    private Inventory inventory = new Inventory();


	    // --- LEVELING VARIABLES ---
	    private int level;
	    private int exp;
	    private int nextLevelExp;

	    public Player(String name, int classChoice) {
	        super(name, 100, 50, 15, 5, 0.10, 0.05); 
	        this.level = 1;
	        this.exp = 0;
	        this.nextLevelExp = 50; // Initial EXP requirement to reach level 2
	        setupClass(classChoice);
	        inventory.addItem(new Item("Potion", "Restores HP"));
	        inventory.addItem(new Item("Mana", "Restores Mana"));


	    }

	    
	    
	    private void setupClass(int choice) {
	        if (choice == 1) {
	            this.playerClass = "Warrior";
	            this.maxHp = 120; this.hp = 120; this.maxMp = 30; this.mp = 30; this.atk = 15; this.def = 10;
	            this.critChance = 0.10; this.dodgeChance = 0.05;
	            this.skillName = "Shield Bash"; this.skillCost = 10;
	            this.ultName = "Whirlwind"; this.ultCost = 25;
	        } else if (choice == 2) {
	            this.playerClass = "Magician";
	            this.maxHp = 80; this.hp = 80; this.maxMp = 80; this.mp = 80; this.atk = 22; this.def = 4;
	            this.critChance = 0.05; this.dodgeChance = 0.05;
	            this.skillName = "Fireball"; this.skillCost = 15;
	            this.ultName = "Meteor Strike"; this.ultCost = 40;
	        } else {
	            this.playerClass = "Archer";
	            this.maxHp = 95; this.hp = 95; this.maxMp = 45; this.mp = 45; this.atk = 18; this.def = 6;
	            this.critChance = 0.25; this.dodgeChance = 0.20;
	            this.skillName = "Steady Shot"; this.skillCost = 12;
	            this.ultName = "Arrow Storm"; this.ultCost = 30;
	        }
	    }

	    // --- GAIN EXP & LEVEL UP LOGIC ---
	    public void gainExp(int amount) {
	        this.exp += amount;
	        System.out.println("You gained " + amount + " EXP! (" + this.exp + "/" + this.nextLevelExp + ")");
	        
	        while (this.exp >= this.nextLevelExp) {
	            this.exp -= this.nextLevelExp;
	            this.level++;
	            this.nextLevelExp = (int)(this.nextLevelExp * 1.5); // Scaled exponential EXP curve
	            
	            // Stat Growth Factors based on Character Archetype
	            if (playerClass.equals("Warrior")) {
	                this.maxHp += 25;
	                this.maxMp += 5;
	                this.atk += 4;
	                this.def += 3;
	            } else if (playerClass.equals("Magician")) {
	                this.maxHp += 15;
	                this.maxMp += 20;
	                this.atk += 6;
	                this.def += 1;
	            } else { // Archer
	                this.maxHp += 18;
	                this.maxMp += 10;
	                this.atk += 5;
	                this.def += 2;
	            }
	            
	            // Full heal on level up
	            this.hp = this.maxHp;
	            this.mp = this.maxMp;
	            
	            System.out.println("\n=========================================");
	            System.out.println(" LEVEL UP! You reached Level " + this.level + "!");
	            System.out.println(" Maximum HP and MP have increased!");
	            System.out.println(" Base ATK and DEF have grown stronger!");
	            System.out.println("=========================================");
	        }
	    }

	    public void applyInnatePassive() {
	        if (hp <= 0) return;
	        if (playerClass.equals("Warrior")) {
	            setHp(hp + 4);
	            System.out.println("[Innate Passive] Warrior recovers 4 HP.");
	        } else if (playerClass.equals("Magician")) {
	            setMp(mp + 5);
	            System.out.println("[Innate Passive] Magician recovers 5 MP.");
	        }
	    }

	    public void rest() {
	        int healHp = (int) (maxHp * 0.30);
	        int healMp = (int) (maxMp * 0.30);
	        setHp(hp + healHp);
	        setMp(mp + healMp);
	        System.out.println("You rest. Restored " + healHp + " HP and " + healMp + " MP.");
	    }

	    @Override
	    public int executeAttack(int choice, Entity target) {
	        int damage = 0;
	        if (choice == 1) {
	            System.out.println(name + " uses Basic Attack!");
	            damage = calculateDamageValue(atk, target.getDef(), critChance);
	        } else if (choice == 2) {
	            if (mp >= skillCost) {
	                mp -= skillCost;
	                System.out.println(name + " casts " + skillName + "!");
	                damage = calculateDamageValue((int)(atk * 1.6), target.getDef(), critChance);
	            } else {
	                System.out.println("Not enough MP! Desperation strike hits poorly.");
	                damage = calculateDamageValue((int)(atk * 0.5), target.getDef(), 0);
	            }
	        } else if (choice == 3) {
	            if (mp >= ultCost) {
	                mp -= ultCost;
	                System.out.println(name + " unleashes Ultimate: " + ultName + "!");
	                damage = calculateDamageValue((int)(atk * 2.5), target.getDef(), critChance + 0.15);
	            } else {
	                System.out.println("Not enough MP! The ultimate fizzled out.");
	            }
	        }
	        return damage;
	    }

	    // Getters for Level metrics
	    public int getLevel() { return level; }
	    public int getExp() { return exp; }
	    public int getNextLevelExp() { return nextLevelExp; }
	    
	    public Inventory getInventory() {
	    	return inventory; }

	    public String getPlayerClass() { return playerClass; }
	    public String getSkillName() { return skillName; }
	    public String getUltName() { return ultName; }
	    public int getSkillCost() { return skillCost; }
	    public int getUltCost() { return ultCost; }
	}