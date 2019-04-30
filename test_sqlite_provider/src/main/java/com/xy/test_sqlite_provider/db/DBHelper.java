package com.xy.test_sqlite_provider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.xy.test_sqlite_provider.AppConfig;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表SQL语句
        String stu_table = "create table "+AppConfig.table_name
                +"(_id integer primary key autoincrement,"
                +AppConfig.name+" text,"
                +AppConfig.number+" text)";
        //执行SQL语句
        db.execSQL(stu_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
