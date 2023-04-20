package com.mydomain.autom8.model;

public class TaskCenterItems {

    public final int id;
    public final String titleName;
    public final String subtitle;
    public final String iconName;

    public TaskCenterItems(int id, String titleName, String subtitle, String iconName) {
        this.id = id;
        this.titleName = titleName;
        this.subtitle = subtitle;
        this.iconName = iconName;
    }
}
