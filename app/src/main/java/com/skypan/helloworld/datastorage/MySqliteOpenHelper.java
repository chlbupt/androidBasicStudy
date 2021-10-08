package com.skypan.helloworld.datastorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * MySqliteOpenHelper 工具类 单例模式
 */
public class MySqliteOpenHelper extends SQLiteOpenHelper {
    private static SQLiteOpenHelper instance;

    public static synchronized SQLiteOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MySqliteOpenHelper(context, "helloWorldDB.db", null, 1);
        }
        return instance;
    }

    private MySqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table persons(_id integer primary key autoincrement, name text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
