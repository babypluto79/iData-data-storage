package com.example.msafi.idata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccDatabase {
    DatabaseHelper helper;
    public AccDatabase(Context context){
        helper = new DatabaseHelper(context);
    }
    public long insertData(String name, String value){
        SQLiteDatabase dbb = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(VALUE, value);
        long id = dbb.insert(TABLE_NAME, null, contentValues);
        return id;
    }
    public Cursor getData() throws SQLException{
        SQLiteDatabase dbb = helper.getWritableDatabase();
        Cursor cursor = dbb.query(TABLE_NAME, new String[] {UID, NAME, VALUE}, null,
                null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public int delete(String uname){
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] whereArgs = {uname};
        int count = db.delete(TABLE_NAME, NAME+"= ?", whereArgs);
        return count;
    }
    private static final String DATABASE_NAME = "ACCs";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "acc";

    public static final String UID = "_id";
    public static final String NAME = "name";
    public static final String VALUE = "value";

    private static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME +
            "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(225), " +
            VALUE + " INTEGER );";
    public static class DatabaseHelper extends SQLiteOpenHelper{
        private Context context;
        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }
        public void onCreate(SQLiteDatabase db){
            try{
                db.execSQL(CREATE_TABLE);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            try{
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                onCreate(db);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
