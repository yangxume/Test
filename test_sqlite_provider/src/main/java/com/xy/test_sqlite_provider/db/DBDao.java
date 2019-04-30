package com.xy.test_sqlite_provider.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.xy.test_sqlite_provider.AppConfig;

public class DBDao {

    private static final String TAG = DBDao.class.getSimpleName();

    private static DBDao instance;

    private final DBHelper dbHelper;
    private static SQLiteDatabase db = null;

    public DBDao(Context ctx){

        dbHelper = new DBHelper(ctx, AppConfig.db_name, null, AppConfig.db_version);
        db = dbHelper.getWritableDatabase();

    }

//    public static DBDao getInstance(){
//
//        if (instance == null){
//            synchronized (DBDao.class){
//                instance = new DBDao();
//            }
//        }
//        return instance;
//    }



    public static void insert(String mName,String mNumber){

        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConfig.name,mName);
        contentValues.put(AppConfig.number,mNumber);

        db.insert(AppConfig.table_name,null,contentValues);


//        String sql = "insert to "+AppConfig.table_name
//                +"(name,number) "
//                +"values("+mName+","+mNumber+")";
//        db.execSQL(sql);
    }

}
