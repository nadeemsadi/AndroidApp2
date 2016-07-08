package com.example.user.manupulatedata;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by user on 7/8/2016.
 */
public class BackgroundTask extends AsyncTask<String,Product,String> {

    Context ctx;
    ProductAdapter productAdapter;
    Activity activity;
    ListView listView;
    BackgroundTask(Context ctx){

        this.ctx = ctx;
        activity = (Activity) ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        DbOperations dbOperations = new DbOperations(ctx);
        if(method.equals("add_info"))
        {
            String Id = params[1];
            String Name = params[2];
            int price = Integer.parseInt(params[3]);
            int qty = Integer.parseInt(params[4]);
            SQLiteDatabase db = dbOperations.getWritableDatabase();
            dbOperations.addInformations(db,Id,Name,price,qty);
            return "One Row Inserted....";
        }

        else if(method.equals("get_info")){

            listView = (ListView) activity.findViewById(R.id.display_listview);
            SQLiteDatabase db = dbOperations.getReadableDatabase();
                Cursor cursor = dbOperations.getInformations(db);
            productAdapter = new ProductAdapter(ctx,R.layout.display_product_row);
            String id,name;
            int price,qty;

            while (cursor.moveToNext()){

                id = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.ID));
                name = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.NAME));
                price = cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.PRICE));
                qty = cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.QTY));
                Product product = new Product(id,name,price,qty);
                publishProgress(product);

            }
                return "get_info";
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Product... values) {
       productAdapter.add(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("get_info")){
            listView.setAdapter(productAdapter);
        }
        else {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
    }
}
