package com.example.randomfitness;

public class IntakeModel {

    private int breakfast;
    private int lunch;
    private int dinner;
    private int snacks;

    // constructors

    public IntakeModel(int breakfast, int lunch, int dinner, int snacks) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snacks = snacks;
    }

    public IntakeModel() {
    }

    // toString is needed to print

    @Override
    public String toString() {
        return "IntakeModel{" +
                "breakfast=" + breakfast +
                ", lunch=" + lunch +
                ", dinner=" + dinner +
                ", snacks=" + snacks +
                '}';
    }

    // getters and setters

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public int getLunch() {
        return lunch;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public int getDinner() {
        return dinner;
    }

    public void setDinner(int dinner) {
        this.dinner = dinner;
    }

    public int getSnacks() {
        return snacks;
    }

    public void setSnacks(int snacks) {
        this.snacks = snacks;
    }
}
