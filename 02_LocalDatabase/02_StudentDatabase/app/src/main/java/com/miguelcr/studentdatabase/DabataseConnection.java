package com.miguelcr.studentdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.miguelcr.studentdatabase.dao.DaoMaster;
import com.miguelcr.studentdatabase.dao.DaoSession;
import com.miguelcr.studentdatabase.dao.StudentDao;

/**
 * Created by miguelcampos on 25/2/16.
 */
public class DabataseConnection {
    private static SQLiteDatabase db;

    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public static StudentDao getStudentDao(Context ctx) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(ctx, "student-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        return daoSession.getStudentDao();
    }
}
