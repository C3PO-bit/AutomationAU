package com.mydomain.autom8.model;

import android.graphics.drawable.Drawable;

public class Dashboard {

    public final int position;
    public final String itemIcon;
    public final String itemDescription;
    public final int itemBackgroundColor;
    public Dashboard(int position, String itemIcon, String itemDescription, int itemBackgroundColor) {
        this.position = position;
        this.itemIcon = itemIcon;
        this.itemDescription = itemDescription;
        this.itemBackgroundColor = itemBackgroundColor;
    }
}
