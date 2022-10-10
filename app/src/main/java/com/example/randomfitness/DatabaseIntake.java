package com.example.randomfitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseIntake extends SQLiteOpenHelper {

    public static final String DIET_INTAKE = "DIET_INTAKE";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_BREAKFAST = "BREAKFAST";
    public static final String COLUMN_LUNCH = "LUNCH";
    public static final String COLUMN_DINNER = "DINNER";
    public static final String COLUMN_SNACKS = "SNACKS";
    public static final String COLUMN_DAILY = "DAILY_INTAKE";
    public static final String COLUMN_ID = "ID";

    public static final String SETTINGS = "SETTINGS";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_AGE = "AGE";
    public static final String COLUMN_HEIGHT = "HEIGHT";
    public static final String COLUMN_WEIGHT = "WEIGHT";
    public static final String COLUMN_BMI = "BMI";
    public static final String COLUMN_GOAL = "GOAL";
    public static final String COLUMN_RATE = "RATE";
    public static final String COLUMN_MAINTENANCE = "MAINTENANCE";
    public static final String COLUMN_BUDGET = "BUDGET";
    public static final String COLUMN_HEIGHT_UNITS = "HEIGHT_UNITS";
    public static final String COLUMN_WEIGHT_UNITS = "WEIGHT_UNITS";
    public static final String COLUMN_ENERGY_UNITS = "ENERGY_UNITS";

    public static final String EXERCISE = "EXERCISE";


    public DatabaseIntake(@Nullable Context context) {
        super(context, "fitness.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createIntakeTableStatement = "CREATE TABLE " + DIET_INTAKE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE + " TEXT, " + COLUMN_BREAKFAST + " INT, " + COLUMN_LUNCH + " INT, " + COLUMN_DINNER + " INT, " + COLUMN_SNACKS + " INT, " + COLUMN_DAILY + " INT)";
        String createSettingsTableStatement = "CREATE TABLE " + SETTINGS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FIRST_NAME + " TEXT, " + COLUMN_LAST_NAME + " TEXT, " + COLUMN_AGE + " INT, " + COLUMN_HEIGHT_UNITS + " INT, " + COLUMN_WEIGHT_UNITS + " INT, " + COLUMN_ENERGY_UNITS + " INT, " + COLUMN_HEIGHT + " REAL, " + COLUMN_WEIGHT + " REAL, " + COLUMN_BMI + " REAL, " + COLUMN_GOAL + " REAL, " + COLUMN_RATE + " INT, " + COLUMN_MAINTENANCE + " REAL, " + COLUMN_BUDGET + " REAL)";
        // exercise table to  be filled with relevant fields
        String createExerciseTableStatement = "CREATE TABLE " + EXERCISE + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT)";

        db.execSQL(createIntakeTableStatement);
        db.execSQL(createSettingsTableStatement);
        db.execSQL(createExerciseTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean addOne(IntakeModel intakeModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BREAKFAST, intakeModel.getBreakfast());
        cv.put(COLUMN_LUNCH, intakeModel.getLunch());
        cv.put(COLUMN_DINNER, intakeModel.getDinner());
        cv.put(COLUMN_SNACKS, intakeModel.getSnacks());
        cv.put(COLUMN_DAILY, intakeModel.getDaily());

        long insert = db.insert(DIET_INTAKE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }

    }

    public boolean addOne(SettingsModel settingsModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FIRST_NAME, settingsModel.getFirstName());
        cv.put(COLUMN_LAST_NAME, settingsModel.getLastName());
        cv.put(COLUMN_AGE, settingsModel.getAge());
        cv.put(COLUMN_HEIGHT_UNITS, settingsModel.getMeasurementUnit());
        cv.put(COLUMN_ENERGY_UNITS, settingsModel.getEnergyUnit());
        cv.put(COLUMN_HEIGHT, settingsModel.getHeight());
        cv.put(COLUMN_WEIGHT, settingsModel.getWeight());
        cv.put(COLUMN_BMI, settingsModel.getBmi());
        cv.put(COLUMN_GOAL, settingsModel.getGoal());
        cv.put(COLUMN_RATE, settingsModel.getRate());
        cv.put(COLUMN_MAINTENANCE, settingsModel.getMaintenance());
        cv.put(COLUMN_BUDGET, settingsModel.getBudget());

        long insert = db.insert(SETTINGS, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }

    }



    // displaying db items in list
    public List<IntakeModel> getAll() {

        List<IntakeModel> returnlist = new ArrayList<>();

        String queryIntake = "SELECT * FROM " + DIET_INTAKE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryIntake, null);

        if (cursor.moveToFirst()) {
            do {
                int breakfast = cursor.getInt(2);
                int lunch = cursor.getInt(3);
                int dinner = cursor.getInt(4);
                int snacks = cursor.getInt(5);
                int daily = cursor.getInt(6);

                IntakeModel newIntake = new IntakeModel(breakfast, lunch, dinner, snacks, daily);
                returnlist.add(newIntake);

            } while (cursor.moveToNext());
        }
        else {
            // add nothing to list
        }

        cursor.close();
        db.close();

        return returnlist;

    }

    public Double setGoal() {
        String queryGoal = "SELECT GOAL FROM SETTINGS ORDER BY ID DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryGoal, null);

        if (cursor != null) {
            cursor.moveToFirst();
            Double goal = cursor.getDouble(0);
            return goal;
        }
        return null;
    }

}
