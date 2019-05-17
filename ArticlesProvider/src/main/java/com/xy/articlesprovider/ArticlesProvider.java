package com.xy.articlesprovider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class ArticlesProvider extends ContentProvider {

    private static final String DB_NAME = "Articles.db";
    private static final String DB_TABLE = "ArticlesTable";
    private static final int DB_VERSION = 1;

    private static final String SQL_CREATE_TABLE =
            "create table " + DB_TABLE
                    + "(" + Articles.ID + " integer primary key autoincrement"
                    + Articles.TITLE + " text not null"
                    + Articles.ABSTRACT + " text not null"
                    + Articles.URL + " text not null);";


    private static final UriMatcher uriMatcher = null;

    static {
        uriMatcher.addURI(Articles.AUTORITY, "item", Articles.ITEM);
        uriMatcher.addURI(Articles.AUTORITY, "item/#", Articles.ITEM_ID);
        uriMatcher.addURI(Articles.AUTORITY, "pos/#", Articles.ITEM_POS);
    }

    private DBHelper dbHelper = null;
    private ContentResolver contentResolver;

    @Override
    public boolean onCreate() {

        Context context = getContext();
        contentResolver = context.getContentResolver();

        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);

        return true;
    }



    @androidx.annotation.Nullable
    @Override
    public String getType(@androidx.annotation.NonNull Uri uri) {

        String type = null;

        switch (uriMatcher.match(uri)) {

            case Articles.ITEM:

                type = Articles.CONTENT_TYPE;

                break;

            case Articles.ITEM_ID:
            case Articles.ITEM_POS:

                type = Articles.CONTENT_ITEM_TYPE;

                break;
        }

        return type;
    }

    @androidx.annotation.Nullable
    @Override
    public Uri insert(@androidx.annotation.NonNull Uri uri, @androidx.annotation.Nullable ContentValues values) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(DB_TABLE,Articles.ID,values);

        return null;
    }

    @Override
    public int delete(@androidx.annotation.NonNull Uri uri, @androidx.annotation.Nullable String selection, @androidx.annotation.Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@androidx.annotation.NonNull Uri uri, @androidx.annotation.Nullable ContentValues values, @androidx.annotation.Nullable String selection, @androidx.annotation.Nullable String[] selectionArgs) {
        return 0;
    }

    @androidx.annotation.Nullable
    @Override
    public Cursor query(@androidx.annotation.NonNull Uri uri, @androidx.annotation.Nullable String[] projection, @androidx.annotation.Nullable String selection, @androidx.annotation.Nullable String[] selectionArgs, @androidx.annotation.Nullable String sortOrder) {
        return null;
    }
}
