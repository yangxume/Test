package com.xy.articlesprovider;

import android.net.Uri;

public class Articles {

    public static final String ID = "_id";
    public static final String TITLE = "_title";
    public static final String ABSTRACT = "_abstract";
    public static final String URL = "_url";

    public static final String DEFAULT_SORT_ORDER = "_id asc";

    public static final String METHOD_GET_ITEM_COUNT ="method_get_item_count";
    public static final String KEY_ITEM_COUNT = "key_item_count";

    public static final int ITEM = 1;
    public static final int ITEM_ID = 2;
    public static final int ITEM_POS = 3;

    public static final String AUTORITY = "com.xy.articlesprovider";

    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.xy.articles";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.xy.articles";

    public static final Uri CONTENT_URL = Uri.parse("content://"+AUTORITY+"/item");
    public static final Uri CONTENT_POS_URL = Uri.parse("content://"+AUTORITY+"/pos");

}
