package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAO {
    MyDatabaseHelper dbHelper;
    SQLiteDatabase db;

    public DAO (Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    public void openWrite() { db = dbHelper.getWritableDatabase(); }
    public void openRead() { db = dbHelper.getReadableDatabase(); }
    public void close() { db.close(); }

    public void addOffre(Offre o) {
        openWrite();
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.COL_POSTE, o.getPoste());
        values.put(MyDatabaseHelper.COL_DESC, o.getDescription());
        db.insert(MyDatabaseHelper.TABLE, null, values);
        close();
    }

    public ArrayList<Offre> getAllOffres() {
        ArrayList<Offre> list = new ArrayList<>();
        openRead();
        Cursor c = db.rawQuery("SELECT * FROM " + MyDatabaseHelper.TABLE, null);

        if (c.moveToFirst()) {
            do {
                Offre o = new Offre(
                        c.getInt(0),
                        c.getString(1),
                        c.getString(2)
                );
                list.add(o);
            } while (c.moveToNext());
        }
        c.close();
        close();
        return list;
    }

    public void updateOffre(Offre o) {
        openWrite();
        ContentValues v = new ContentValues();
        v.put(MyDatabaseHelper.COL_POSTE, o.getPoste());
        v.put(MyDatabaseHelper.COL_DESC, o.getDescription());

        db.update(MyDatabaseHelper.TABLE, v, "id=?", new String[]{String.valueOf(o.getId())});
        close();
    }

    public void deleteOffre(int id) {
        openWrite();
        db.delete(MyDatabaseHelper.TABLE, "id=?", new String[]{String.valueOf(id)});
        close();
    }
}
