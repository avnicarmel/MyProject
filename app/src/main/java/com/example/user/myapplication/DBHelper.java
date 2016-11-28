package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by carmel on 27/11/2016.
 */
/**
 * DBResult enum for DB returned value for error handling.
 */
 enum DBResult {
    GENERIC_ERROR, OK, ITEM_NOT_EXISTS_ERROR, ITEM_NOT_EXISTS, ITEM_EXISTS
}
public class DBHelper extends SQLiteOpenHelper {


    /*ALL THE STATIC VARIABLES*/
    private static final String TAG = "DBDebug";
    private static final String DB_NAME = "DBNAME";
    private static final int DB_VERSION = 1;
    public static final String PROFESSOR_TABLE = "professor";
    public static final String COURSE_TABLE = "course";
    public static final String RANK_TABLE = "rank";
    public static final String MEMBER_TABLE = "member";
    public static final String PROF_ID = "pid";
    public static final String COURSE_ID = "cid";
    public static final String MEMBER_ID = "mid";
    public static final String USER_NAME = "firstName";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String COURSE_NAME = "courseName";
    public static final String PASSWORD ="password";
    public static final String INSTITUTE ="institute";
    public static final String ATTITUDE = "attitude";
    public static final String PREPARE = "preparedness";
    public static final String INTEREST = "interest";
    public static final String TEACH_LVL="teachingLevel";
    public static final String GENERAL_RANK="generalRank";
    public static final String SEMESTER="semester";
    private Context context;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database.
     */
    public DBHelper(Context context) {
        //The second parameter is th DB name, null for debug purpose.
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;

        Log.d(TAG, "DB creation started");
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate   !!!!!!!!!   ******    !!!!!!");
        updateMyDB(db, 0, DB_VERSION);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDB(db, oldVersion, newVersion);
    }

    /**
     * Updates the DB according to the version.
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    private void updateMyDB(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            Log.d(TAG, "DB creation start.");
            create_tables(db);
            Log.d(TAG, "DB creation finished.");
        }
    }

    /**
     * Creates the DB tables.
     */
    private void create_tables(SQLiteDatabase db) {
        String sql_create_table;
        Log.d(TAG, "create_tables start.");
        // create professor table
        sql_create_table = "create table " + PROFESSOR_TABLE
                + " ("+PROF_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FIRST_NAME+" TEXT,"+LAST_NAME+" TEXT);";
        db.execSQL(sql_create_table);

        //create courses table
        sql_create_table = "create table " + COURSE_TABLE
                + " ("+COURSE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COURSE_NAME+" TEXT);";
        db.execSQL(sql_create_table);

        //create member table
        sql_create_table ="create table "+MEMBER_TABLE
                +" ("+MEMBER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
        +USER_NAME+" TEXT,"+PASSWORD+" TEXT,"+INSTITUTE+" TEXT);";
        db.execSQL(sql_create_table);

        sql_create_table="create table "+RANK_TABLE+" ("+PROF_ID +" INTEGER ,"+COURSE_ID+" INTEGER, "
                +SEMESTER+" TEXT, "+ATTITUDE+" DECIMAL,"+PREPARE
                +" DECIMAL,"+INTEREST+" DECIMAL,"+TEACH_LVL+" DECIMAL, "
                +"PRIMARY KEY ("+PROF_ID+","+COURSE_ID+"), "
                +"FOREIGN KEY ("+PROF_ID+") REFERENCES "+PROFESSOR_TABLE+" ("+PROF_ID+") ON DELETE CASCADE ON UPDATE NO ACTION, "
                +"FOREIGN KEY ("+COURSE_ID+") REFERENCES "+COURSE_TABLE+" ("+COURSE_ID+") ON DELETE CASCADE ON UPDATE NO ACTION);";

       db.execSQL(sql_create_table);

        Log.d(TAG, "create_tables end.");
       // db.close(); TODO: check if needed
    }

    /**
     * Initialize the DB
     */
    public void start() {

        insert_to_table();

    }
    private void insert_to_table()
            throws SQLiteConstraintException {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        ContentValues values2 = new ContentValues();
        ContentValues values3 = new ContentValues();
        ContentValues values4 = new ContentValues();
        ContentValues values11 = new ContentValues();
        ContentValues values22 = new ContentValues();
        ContentValues values33 = new ContentValues();
        ContentValues values44 = new ContentValues();
        ContentValues values111 = new ContentValues();
        ContentValues values222 = new ContentValues();
        ContentValues values333 = new ContentValues();
        ContentValues values444 = new ContentValues();

        //for professor
        values1.put(FIRST_NAME, "Litaf");
        values1.put(LAST_NAME, "Kupfer");
        //values1.put(INSTITUTE, "Braude");
        //for courses
        values2.put(COURSE_NAME,"Matam");
        //for member
        values3.put(USER_NAME,"NofarT");
        values3.put(PASSWORD,"123");
        values3.put(INSTITUTE,"Braude");
        //for rank
        values4.put(PROF_ID,1);
        values4.put(COURSE_ID,1);
        values4.put(SEMESTER,"a");
        values4.put(ATTITUDE,5);
        values4.put(PREPARE,5);
        values4.put(INTEREST,5);
        values4.put(TEACH_LVL,5);
       // values4.put(GENERAL_RANK,5);

        //for professor
        values11.put(FIRST_NAME, "Carmel");
        values11.put(LAST_NAME, "Avni");
        //values11.put(INSTITUTE, "Braude");
        //for courses
        values22.put(COURSE_NAME,"Malam");
        //for member
        values33.put(USER_NAME,"Negev");
        values33.put(PASSWORD,"123");
        values33.put(INSTITUTE,"Haifa University");
        //for rank
        values44.put(PROF_ID,2);
        values44.put(COURSE_ID,2);
        values44.put(SEMESTER,"b");
        values44.put(ATTITUDE,10);
        values44.put(PREPARE,10);
        values44.put(INTEREST,10);
        values44.put(TEACH_LVL,10);
        //values44.put(GENERAL_RANK,10);

        //for professor
        values111.put(FIRST_NAME, "Eli");
        values111.put(LAST_NAME, "Bar Yahalom");
        //values111.put(INSTITUTE, "Braude");
        //for courses
        values222.put(COURSE_NAME,"Logica");
        //for member
        values333.put(USER_NAME,"Viki");
        values333.put(PASSWORD,"123");
        values333.put(INSTITUTE,"Tel Hai");
        //for rank
        values444.put(PROF_ID,3);
        values444.put(COURSE_ID,3);
        values444.put(SEMESTER,"a");
        values444.put(ATTITUDE,5);
        values444.put(PREPARE,7);
        values444.put(INTEREST,7);
        values444.put(TEACH_LVL,5);
       // values444.put(GENERAL_RANK,6);


        try {
            db.insertOrThrow(PROFESSOR_TABLE, null, values1);
            db.insertOrThrow(COURSE_TABLE, null, values2);
            db.insertOrThrow(MEMBER_TABLE, null, values3);
           db.insertOrThrow(RANK_TABLE, null, values4);

            db.insertOrThrow(PROFESSOR_TABLE, null, values11);
            db.insertOrThrow(COURSE_TABLE, null, values22);
            db.insertOrThrow(MEMBER_TABLE, null, values33);
           // db.insertOrThrow(RANK_TABLE, null, values44);

            db.insertOrThrow(PROFESSOR_TABLE, null, values111);
            db.insertOrThrow(COURSE_TABLE, null, values222);
            db.insertOrThrow(MEMBER_TABLE, null, values333);
         //   db.insertOrThrow(RANK_TABLE, null, values444);
        } catch (SQLiteConstraintException e) {

        }
        finally {
            db.close();
        }
    }

    /**
     *  Check if the user is in the DB
     * @param username - the user id
     * @param password - the user password
     * @return Returns the user institute if he exist, else return null
     */
    public ArrayList<String> login(String username, String password) {
        ArrayList<String> res=new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor result = db.rawQuery("SELECT * FROM member WHERE firstName LIKE '"+username+"' AND password LIKE '"+password
                    +"' ",null);



            if (result == null || result.getCount() <= 0) // didn't found user
            {
                result.close();
                return null;
            } else if (result.moveToFirst()) {
                String institute = result.getString(3);
                res.add(institute);
            }
            result.close();
            return res;
        }
        catch (SQLiteException e)
        {
            return null;
        }


    }

    /**
     * Insert new member to DB
     * @param name member name
     * @param password member password
     * @param institute member institute
     * @return true if success, else false
     */
    public boolean register(String name, String password, String institute ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(name == null || password == null || institute==null)
            return false;
        values.put(USER_NAME,name);
        values.put(PASSWORD,password);
        values.put(INSTITUTE,institute);
        try {
            db.insertOrThrow(MEMBER_TABLE, null, values);

        } catch (SQLiteConstraintException e) {
            return false;
        }
        finally {
            db.close();
        }
        return true;
    }
    public ArrayList<String> getProfByInstitude(String institude) {
        ArrayList<String> res=new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result=null;
        try {
            result = db.rawQuery("SELECT * FROM " + PROFESSOR_TABLE, null);
            if(result== null || result.getCount() <= 0) // didn't found user
            {
                result.close();
                return null;
            }
            else  if (result.moveToFirst()) {
                do {
                    String firstName = result.getString(1);
                    String lastName = result.getString(2);
                    String name = firstName+" "+lastName;
                    res.add(name);
                } while(result.moveToNext());

            }
            result.close();
        }
        catch(SQLiteConstraintException e)
        {
            return null;
        }
        finally {
            if(result !=null)
                result.close();
        }
        return res;

    }

    public ArrayList<String> getCourseByInstitude(String institude) {
        ArrayList<String> res=new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result=null;
        try {
            result = db.rawQuery("SELECT * FROM " + COURSE_TABLE, null);
            if(result== null || result.getCount() <= 0) // didn't found user
            {
                result.close();
                return null;
            }
            else  if (result.moveToFirst()) {
                do {
                    String num = result.getString(0);
                    String cName = result.getString(1);
                    String name = num+" "+cName;
                    res.add(name);
                } while(result.moveToNext());

            }
            result.close();
        }
        catch(SQLiteConstraintException e)
        {
            return null;
        }
        finally {
            if(result !=null)
                result.close();
        }
        return res;

    }

    public ArrayList<String> getProfRanks(String firstName, String lastName){
        ArrayList<String> res=new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result=null;
        try {
            result = db.rawQuery("SELECT * FROM " + PROFESSOR_TABLE+" WHERE "+FIRST_NAME+" = "+firstName+" AND "+LAST_NAME+" = "+lastName, null);
            if(result== null || result.getCount() <= 0) // didn't found user
            {
                result.close();
                return null;
            }
            else  if (result.moveToFirst()) {
                    String id = result.getString(0);
                if(id!=null){
                    result = db.rawQuery("SELECT * FROM "+RANK_TABLE+" WHERE "+PROF_ID+" = "+id,null);

                }
            }

            result.close();
        }
        catch(SQLiteConstraintException e)
        {
            return null;
        }
        finally {
            if(result !=null)
                result.close();
        }

        return null;
    }

}