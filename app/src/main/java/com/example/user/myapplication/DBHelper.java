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
 * Created by dell on 27/11/2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "@string/db_name";
    private static final int DB_VERSION = 1;


    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     **/

    public DBHelper(Context context) {
        //The second parameter is th DB name, null for debug purpose.
        super(context, null, null, DB_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        updateMyDB(db, 0, DB_VERSION);

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
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
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    public void updateMyDB(SQLiteDatabase db, int oldVersion, int newVersion) {

        if ( oldVersion < 1)
        {
            String sql_create_table;
            sql_create_table = "CREATE TABLE songs ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "artist_name TEXT, "
                    + "song_name TEXT); ";
            db.execSQL(sql_create_table);
        }

    }
}
