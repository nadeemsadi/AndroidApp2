package com.example.user.manupulatedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 7/8/2016.
 */
public class DbOperations extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "product_info.db";
    private static final String CREATE_QUERY = "create table "+ProductContract.ProductEntry.TABLE_NAME+
            "("+ ProductContract.ProductEntry.ID+ " text,"+ ProductContract.ProductEntry.NAME+" text,"+
            ProductContract.ProductEntry.PRICE+ " integer,"+ ProductContract.ProductEntry.QTY+ " integer);";

    DbOperations(Context ctx){

        super(ctx,DB_NAME,null,DB_VERSION);
        Log.d("Database operations","Database created......");
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created......");
    }

    public void addInformations(SQLiteDatabase db,String id,String name,int price,int qty)
    {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ProductContract.ProductEntry.ID,id);
        contentValues.put(ProductContract.ProductEntry.NAME,name);
        contentValues.put(ProductContract.ProductEntry.PRICE,price);
        contentValues.put(ProductContract.ProductEntry.QTY,qty);
        db.insert(ProductContract.ProductEntry.TABLE_NAME,null,contentValues);
        Log.d("Database operations", "One Row Inserted......");
    }

    public Cursor getInformations(SQLiteDatabase db){

        String[] projections = {ProductContract.ProductEntry.ID,ProductContract.ProductEntry.NAME,
                ProductContract.ProductEntry.PRICE,ProductContract.ProductEntry.QTY };

        Cursor cursor = db.query(ProductContract.ProductEntry.TABLE_NAME,projections,

                null,null,null,null,null);

        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int olVersion, int newVersion){


    }
}
