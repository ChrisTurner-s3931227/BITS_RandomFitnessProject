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
    public static final String COLUMN_BREAKFAST = "BREAKFAST";
    public static final String COLUMN_LUNCH = "LUNCH";
    public static final String COLUMN_DINNER = "DINNER";
    public static final String COLUMN_SNACKS = "SNACKS";
    public static final String COLUMN_ID = "ID";

    public DatabaseIntake(@Nullable Context context) {
        super(context, "intake.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + DIET_INTAKE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_BREAKFAST + " INT, " + COLUMN_LUNCH + " INT, " + COLUMN_DINNER + " INT, " + COLUMN_SNACKS + " INT)";

        db.execSQL(createTableStatement);
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

        long insert = db.insert(DIET_INTAKE, null, cv);
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
                int breakfast = cursor.getInt(1);
                int lunch = cursor.getInt(2);
                int dinner = cursor.getInt(3);
                int snacks = cursor.getInt(4);

                IntakeModel newIntake = new IntakeModel(breakfast, lunch, dinner, snacks);
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

}
