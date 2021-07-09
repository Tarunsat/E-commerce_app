package com.example.testlist.data;

import android.provider.BaseColumns;

public final class Contract {

    public static abstract class HeadphoneEntry implements BaseColumns {

        public static final String TABLE_NAME = "inventory";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_STYLE = "style";

        public static final String COLUMN_ID ="id";

        /**
         * Possible values for the style of the headphone.
         */
        public static final int STYLE_EAR_BUD = 0;
        public static final int STYLE_ON_EAR = 1;
        public static final int STYLE_OVER_EAR = 2;
        public static final int STYLE_BONE_CONDUCTION = 3;


        public static final String TABLE1_NAME = "users";
        public static final String COLUMN1_NAME = "name";
        public static final String COLUMN1_MOBILE = "mobile";
        public static final String COLUMN1_PASS = "password";

        public static final String COLUMN1_ID ="id";
    }
}
