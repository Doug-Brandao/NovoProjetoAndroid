package com.example.novoprojeto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static int versao = 1;
    private static String nomeDB = "Aplicativo.db";

    String[] sql = {
            "CREATE TABLE Login(username TEXT PRIMARY KEY, password TEXT);"
    };

    public Conexao(@Nullable Context context) {
        super(context, nomeDB, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (int i = 0; i < sql.length; i++) {
            db.execSQL(sql[i]);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        versao++;
        db.execSQL("DROP TABLE IF EXISTS Login");
        onCreate(db);
    }
}
