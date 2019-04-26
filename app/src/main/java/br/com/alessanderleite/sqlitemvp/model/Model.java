package br.com.alessanderleite.sqlitemvp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.alessanderleite.sqlitemvp.view.DataBaseOpenHelper;
import br.com.alessanderleite.sqlitemvp.view.IMainActivity;

public class Model implements IModel {

    private SQLiteDatabase database;

    public Model(IMainActivity iMainActivity) {
        database = new DataBaseOpenHelper((Context) iMainActivity).getWritableDatabase();
    }

    @Override
    public List<String> getListFromDatabase() {

        List<String> list = new ArrayList<>();
        String sqlQueryText = "SELECT adam, til from test";
        Cursor cursor = this.database.rawQuery(sqlQueryText, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return list;
    }
}
