package com.example.randomfitness;

public class SettingsModel {

    private String firstName;
    private String lastName;
    private int age;
    private int heightUnit;
    private int weightUnit;
    private int energyUnit;

    // constructors

    public SettingsModel(String firstName, String lastName, int age, int heightUnit, int weightUnit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightUnit = heightUnit;
        this.weightUnit = weightUnit;
        this.energyUnit = energyUnit;
    }

    public SettingsModel () {
    }

    // getters and setters

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
}
