package LabExamGame;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private Player player;

    private int posX = 0;
    private int posY = 0;

    private int totalDefeated = 0;
    private int goblinDefeated = 0;
    private int orcDefeated = 0;
    private int dragonDefeated = 0;
    private int bossDefeated = 0;
    
    

    public void start() {
        displayMetadata();
        setupPlayer();
        explorationLoop();
    }

    private void displayMetadata() {
        System.out.println("==================================================");
        System.out.println("DEVELOPED BY: HAKPIN STUDIOS");
        System.out.println("MEMBERS:");
        System.out.println("* Phil Galido (Lead Dev), Phil Galido (Game Designer)");
        System.out.println("* Phil Galido (Graphics Design), Phil Galido (Sound Engineer)");
        System.out.println("* Phil Galido (Producer), Phil Galido (Game Tester)");
        System.out.println("* Phil Galido (Front-End Developer), Phil Galido (Back-End Developer)");
        System.out.println("* Phil Galido (Spiritual/Motivational Support), Phil Galido (Canton Server)");
        System.out.println("==================================================");
        System.out.println("GAME TITLE : MEMA-OOP RPG");
        System.out.println("==================================================\n");
    }

    private void setupPlayer() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Hero";

        System.out.println("\nSelect Your Class:");
        System.out.println("1. Warrior\n2. Magician\n3. Archer");
        int choice = getValidInput(1, 3);

        player = new Player(name, choice);
    }

    private void explorationLoop() {
        String[] randomLines = {
            "You're chilling inside as you hear whispers... you turned around and discover that it was just a group of marites.",
            "You find a mysterious shiny object on the ground! ...Never mind, it's just a discarded candy wrapper.",
            "You saw a moving silhouette ... of what seemingly a big fat bald man that accidentally tripped and fell.",
            "You scan around the foggy mist. You realized it was just smoke from a group of irreg students cutting classes.",
            "No enemies appear. You spend the next few minutes overthinking how you will pass this subject."
        };

        while (true) {
            System.out.println("\n--- EXPLORATION MODE ---");
            System.out.println("Current Coordinates: (" + posX + ", " + posY + ")");
            System.out.println("1. Walk (Move Around)");
            System.out.println("2. Check Stats & Trophies");
            System.out.println("3. Exit Game");
            System.out.println("4.Inventory");
            
            int choice = getValidInput(1, 4);

            if (choice == 3) break;

            if (choice == 1) {
                handleMovement();
                checkSpecialLocations(randomLines);
            } else if (choice == 2) {
                displayStats();
            } else if (choice == 4) {                      //  new function
                player.getInventory().display();

                   if(!player.getInventory().getItems().isEmpty()  ) {
                System.out.println("Use an item? (1. Yes  2. No)");
                    int useChoice = getValidInput(1, 2);

                    if (useChoice == 1) {
                        System.out.println("Enter item name to use:");
                        String itemName = scanner.nextLine();

                        Item chosen = null;
                        for (Item i : player.getInventory().getItems()) {
                            if (i.getName().equalsIgnoreCase(itemName)) {
                                chosen = i;
                                break;
                            }
                        }
                        if (chosen.getName().equals("Potion")) {
                            player.setHp(player.getHp() + 20);
                            player.getInventory().removedItem(chosen);
                            System.out.println("Used " + chosen.getName() + "! Restored 20 HP.");
                        }  else if(chosen.getName().equals("Mana")) {
                            	player.setMp(player.getMp()+20);
                                player.getInventory().removedItem(chosen);
                                System.out.println("Used " + chosen.getName() + "! Restored 20 MP.");

                            
                            
                        } else {
                            System.out.println("Nothing happens.");
                        }
                    }
                }
                
            }
            }
        }
    

    private void handleMovement() {
        System.out.println("\nChoose direction to walk:");
        System.out.println("1. North (Y++) | 2. South (Y--) | 3. East (X++) | 4. West (X--)");
        int direction = getValidInput(1, 4);

        int nextX = posX;
        int nextY = posY;

        if (direction == 1) nextY++;
        else if (direction == 2) nextY--;
        else if (direction == 3) nextX++;
        else nextX--;

        // block
        if (nextX == 1 && nextY == 2) {
            System.out.println("\n[MAP BLOCKAGE] A wild Snorlax is sleeping soundly here! It blocks the entire path.");
            System.out.println("You try to push it, but you realize you do not have a Poke Flute. Movement canceled.");
            System.out.println("You remain at your current coordinates: (" + posX + ", " + posY + ")");
            return;
        }

	if (nextX == 2 && nextY == 1) {
            System.out.println("\n[MAP BLOCKAGE] Manong Guard appeared.");
            System.out.println("He asked for your ID, but you're so stubborn you never really care bringing it. Movement canceled.");
            System.out.println("You remain at your current coordinates: (" + posX + ", " + posY + ")");
            return;
        }

        posX = nextX;
        posY = nextY;
        System.out.println("Walking along the path... You arrived at (" + posX + ", " + posY + ").");
    }

    private void checkSpecialLocations(String[] randomLines) {
        // 1. Dragon Boss Area
        if ((posX == 3 && posY == 3) || (posX == -3 && posY == -3)) {
            System.out.println("\n[BOSS ZONE] The earth rumbles as volcanic smoke fills the room...");
            System.out.println("You have entered the Dragon's Lair!");
            battleMode(3); // Passes integer 3 to spawn the real Dragon Boss!
            return;
        }

        // 2. Healing Canal Area
        if ((posX == -2 && posY == -2) || (posX == 2 && posY == 2)) {
            System.out.println("\n[HEALING CANAL] You discovered a dirty, nasty canal filled with garbage and black mucus.");
            System.out.println("You happily drink the water. Your HP and MP are fully restored!");
            player.setHp(player.getMaxHp());
            player.setMp(player.getMaxMp());
            return;
        }

        // 3. Normal Random Spawns (50% Chance)
        if (random.nextDouble() < 0.50) {
            battleMode(-1);
        } else {
            String line = randomLines[random.nextInt(randomLines.length)];
            System.out.println(line);
        }
    }

    private void battleMode(int forcedType) {
        int enemyType = (forcedType == -1) ? random.nextInt(3) : forcedType;
        Enemy enemy = new Enemy(enemyType);
        
        if (forcedType == 3) {
            System.out.println("\nWARNING: BOSS BATTLE ENGAGED!");
            System.out.println("Prepare yourself, " + player.getName() + "! You face " + enemy.getName() + "!");
        } else {
            System.out.println("\nA wild " + enemy.getName() + " appeared!");
        }
        

        while (player.getHp() > 0 && enemy.getHp() > 0) {
            System.out.println("\n" + player.getName() + " HP: " + player.getHp() + "/" + player.getMaxHp() + " | MP: " + player.getMp() + "/" + player.getMaxMp());
            System.out.println(enemy.getName() + " HP: " + enemy.getHp() + "/" + enemy.getMaxHp());
            System.out.println("1. Fight\n2. Run");
            

            if (getValidInput(1, 2) == 2) {
            	
                if (forcedType == 3) {
                    System.out.println("Bading yarn? You cannot run away from a Boss Battle! Fight or die!");
                } else if (random.nextBoolean()) {
                    System.out.println("Escaped successfully!");
                    return;
                } else {
                    System.out.println("Escape failed! The enemy blocks your exit path.");
                    performTurn(enemy, player, 0);
                    player.applyInnatePassive();
                }
            } else {
                // Player Combat Turn
                System.out.println("1. Basic Attack\n2. " + player.getSkillName() + " (" + player.getSkillCost() + " MP)\n3. " + player.getUltName() + " (" + player.getUltCost() + " MP)");
                int attackChoice = getValidInput(1, 3);
                performTurn(player, enemy, attackChoice);
                
                if (enemy.getHp() <= 0) {
                    break;
                }

                // Monster Turn
                performTurn(enemy, player, 0);
                player.applyInnatePassive();
            }
        }

        handleCombatResult(enemy);
    }

    private void performTurn(Entity attacker, Entity defender, int choice) {
        if (attacker.getHp() <= 0) return;

        if (defender.tryDodge()) {
            System.out.println(defender.getName() + " skillfully dodged the attack!");
            return;
        }

        int damageDealt = attacker.executeAttack(choice, defender);
        defender.setHp(defender.getHp() - damageDealt);
        System.out.println(attacker.getName() + " dealt " + damageDealt + " damage to " + defender.getName() + ".");
    }

    private void handleCombatResult(Enemy enemy) {
        if (player.getHp() <= 0) {
            System.out.println("You died. Game Over.");
            System.exit(0);
        } else {
            System.out.println("You defeated the " + enemy.getName() + "!");
            totalDefeated++;
            
            int expReward = 0;
            if (enemy.getName().equals("Goblin")) {
                goblinDefeated++;
                expReward = 15;
            } else if (enemy.getName().equals("Orc")) {
                orcDefeated++;
                expReward = 30;
            } else if (enemy.getName().equals("Baby Dragon")) {
                dragonDefeated++;
                expReward = 50;
            } else {
                bossDefeated++;
                expReward = 200; // Massive yield for executing the true Dragon Boss
            }
            
            // Apply rewarded experience back to player instance
            player.gainExp(expReward);
            player.getInventory().addItem(new Item("Potion", "Restores HP"));

        }
    }

    private void displayStats() {
        System.out.println("\n=========================================");
        System.out.println("               HERO STATS                ");
        System.out.println("=========================================");
        System.out.println(" Name        : " + player.getName());
        System.out.println(" Class       : " + player.getPlayerClass());
        System.out.println(" Level       : " + player.getLevel());
        System.out.println(" EXP         : " + player.getExp() + " / " + player.getNextLevelExp());
        System.out.println(" Coordinates : (" + posX + ", " + posY + ")");
        System.out.println(" HP          : " + player.getHp() + " / " + player.getMaxHp());
        System.out.println(" MP          : " + player.getMp() + " / " + player.getMaxMp());
        System.out.println(" ATK         : " + player.getAtk());
        System.out.println(" DEF         : " + player.getDef());
        System.out.println(" CRIT        : " + (int)(player.getCritChance() * 100) + "%");
        System.out.println(" DODGE       : " + (int)(player.getDodgeChance() * 100) + "%");
        System.out.println("=========================================");
        System.out.println("            DEFEATED TROPHIES            ");
        System.out.println("=========================================");
        System.out.println(" Goblins Defeated : " + goblinDefeated);
        System.out.println(" Orcs Defeated    : " + orcDefeated);
        System.out.println(" Dragons Defeated : " + dragonDefeated);
        System.out.println(" Bosses Defeated  : " + bossDefeated);
        System.out.println(" Total Defeated   : " + totalDefeated);
        System.out.println("=========================================");
    }
    
    
    

    private int getValidInput(int min, int max) {
        while (true) {
            System.out.print("Enter option: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= min && input <= max)
                	return input;
            } else {
                scanner.nextLine();
            }
            System.out.println("Invalid entry.");
        }
    }
}