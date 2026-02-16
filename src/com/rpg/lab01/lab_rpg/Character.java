package com.rpg.lab01.lab2;

public class Character {
    private String name;
    private int level;
    private int healthPoints;
    private int maxHealthPoint;
    private int damage;
    private int defense;
    private Weapon weapon;
    private String characterClass;

    public Character(String name, int level, int maxHealthPoint, int damage, int defense, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.healthPoints = maxHealthPoint;
        this.maxHealthPoint = maxHealthPoint;
        this.weapon = weapon;
        this.characterClass = characterClass;
        this.damage = damage;
        this.defense = defense;
    }

    public void displayCharacterDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("  Class: " + characterClass);
        System.out.println("  Level: " + level);
        System.out.println("  Health Points: " + healthPoints + "/" + maxHealthPoint);
        System.out.println("    Weapon: " + weapon.toString());
    }

    public void attack(Character target) {
        if (!target.isAlive()) {
            System.out.println("\n" + target.getName() + " is already defeated. Cannot attack.");
            return;
        }

        System.out.println(this.name + " (" + this.characterClass + ") attacks " + target.getName() + " with " + this.weapon.getName() + "!");
        target.takeDamage(this.damage);
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        int actualDamage = damage - this.defense;
        System.out.println("    Raw Attack damage " + actualDamage + "\n" +
                "    " + this.name + "'s Defense " + this.defense + " (Reduce damage by " + this.defense + ") \n" +
                "    Actual Damage Taken: " + actualDamage + "\n" +
                "    " + this.name + "'s HP: " + this.healthPoints + "/" + this.maxHealthPoint);
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void levelUp() {
        level++;
        int healthIncrease = 10;
        maxHealthPoint += healthIncrease;
        healthPoints = maxHealthPoint;
        System.out.println("\n" + name + " leveled up to Level " + level + "!");
        System.out.println("   Max health increased to " + maxHealthPoint + " (full heal applied)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = Math.min(this.healthPoints ,healthPoints);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getDamage() {
        return damage + weapon.getDamage() + (level * 2);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }
}