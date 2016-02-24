package com.miguelcr.contextmenu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.miguelcr.contextmenu.entities.DaoMaster;
import com.miguelcr.contextmenu.entities.DaoSession;
import com.miguelcr.contextmenu.entities.FruitDao;

/**
 * Created by miguelcampos on 24/2/16.
 */

// Dababase properties


public class DatabaseConnection {
    private static SQLiteDatabase db;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public static FruitDao getFruitDao(Context ctx) {
        // Initialize the database
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(ctx, "fruits-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

        return daoSession.getFruitDao();
    }
}
