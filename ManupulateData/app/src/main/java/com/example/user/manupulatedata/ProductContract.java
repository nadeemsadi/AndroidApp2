package com.example.user.manupulatedata;

/**
 * Created by user on 7/8/2016.
 */
public final class ProductContract {

    ProductContract(){}

    public static abstract class ProductEntry{

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PRICE = "price";
        public static final String QTY = "qty";

        public static final String TABLE_NAME = "product_table";




    }
}
