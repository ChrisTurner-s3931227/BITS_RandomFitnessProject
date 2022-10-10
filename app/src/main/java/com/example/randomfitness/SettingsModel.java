package com.example.randomfitness;

public class SettingsModel {

    private String firstName;
    private String lastName;
    private int age;
    private int measurementUnit;
    private int energyUnit;
    private double height;
    private double weight;
    private double bmi;
    private double goal;
    private int rate;
    private double maintenance;
    private double budget;

    public SettingsModel(String firstName, String lastName, int age, int measurementUnit, int energyUnit, double height, double weight, double bmi, double goal, int rate, double maintenance, double budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.measurementUnit = measurementUnit;
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

    public int getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(int measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public int getEnergyUnit() {
        return energyUnit;
    }

    public void setEnergyUnit(int energyUnit) {
        this.energyUnit = energyUnit;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}


