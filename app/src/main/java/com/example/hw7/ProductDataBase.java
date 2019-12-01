package com.example.hw7;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

/*
TODO
    Need test
 */
public class ProductDataBase {

    private static ProductDataBase productDb;
    private SQLiteDatabase db;
    private static final String dbName = "Product";
    private static final String tableName = "Commodity";

    private final String CREATE_PRODUCT = "CREATE TABLE IF NOT EXISTS " + tableName +
                                            "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            "name VARCHAR(32), " +
                                            "price INTEGER)";

    private ProductDataBase (AppCompatActivity activity) {
        db = activity.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
        db.execSQL(CREATE_PRODUCT);
    }

    public ProductDataBase generateDataBase(AppCompatActivity activity) {
        if (productDb == null)
            productDb = new ProductDataBase(activity);
        return productDb;
    }

    public void newProduct (String name, int price) {
        ContentValues cv = new ContentValues(2);

        cv.put("name", name);
        cv.put("price", price);

        db.insert(tableName, null, cv);
    }
}
