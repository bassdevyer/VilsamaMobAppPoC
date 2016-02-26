package com.tie_vilsama.mobapppoc.db;

import android.provider.BaseColumns;

/**
 * Created by mac on 26/2/16.
 */
public class TestDBContract {

    public static abstract class TestTable implements BaseColumns {
        public static final String TABLE_NAME = "test";
        public static final String COLUMN_NAME_TEXT = "text";
    }

}
