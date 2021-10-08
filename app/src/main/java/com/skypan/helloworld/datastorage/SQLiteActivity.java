package com.skypan.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.skypan.helloworld.R;

public class SQLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

    }

    public void createDB(View view) {
        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase readableDatabase = helper.getReadableDatabase();
    }

    public void query(View view) {
        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from persons", null);
            while (cursor.moveToNext()) {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                Log.d("sqlite", "query: _id: " + id + " name: " + name);
            }
            // 关闭游标和数据库
            cursor.close();
        } else {
            Log.d("sqlite", "[query] db is not open");
        }
        db.close();
    }

    public void insert(View view) {
        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db.isOpen()) {
            String sql = "insert into persons(name) values('Derry老师')";
            db.execSQL(sql);
        } else {
            Log.d("sqlite", "[insert] db is not open");
        }

        db.close();
    }

    public void update(View view) {
        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db.isOpen()) {
            String sql = "update persons set name = ? where _id = ?";
            db.execSQL(sql, new Object[]{"chl", 1});
        } else {
            Log.d("sqlite", "[update] db is not open");
        }

        db.close();
    }

    public void delete(View view) {
        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        if (db.isOpen()) {
            String sql = "delete from persons where _id = ?";
            db.execSQL(sql, new Object[]{5});
        } else {
            Log.d("sqlite", "[delete] db is not open");
        }

        db.close();
    }
}