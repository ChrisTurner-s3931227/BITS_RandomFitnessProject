package com.example.randomfitness;

public class SettingsModel {

    private String firstName;
    private String lastName;
    private int age;
    private int heightUnit;
    private int weightUnit;
    private int energyUnit;
    private int height;
    private int weight;
    private int bmi;
    private int goal;
    private int rate;
    private int maintenance;
    private int budget;

    public SettingsModel(String firstName, String lastName, int age, int heightUnit, int weightUnit, int energyUnit, int height, int weight, int bmi, int goal, int rate, int maintenance, int budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightUnit = heightUnit;
        this.weightUnit = weightUnit;
        this.energyUnit = energyUnit;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.goal = goal;
        this.rate = rate;
        this.maintenance = maintenance;
        this.budget = budget;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(int heightUnit) {
        this.heightUnit = heightUnit;
    }

    public int getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(int weightUnit) {
        this.weightUnit = weightUnit;
    }

    public int getEnergyUnit() {
        return energyUnit;
    }

    public void setEnergyUnit(int energyUnit) {
        this.energyUnit = energyUnit;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBmi() {
        return bmi;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}


