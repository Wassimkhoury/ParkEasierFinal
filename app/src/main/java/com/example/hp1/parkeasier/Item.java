package com.example.hp1.parkeasier;

/**
 * Created by Hp1 on 27/09/2017.
 */

public class Item {
    private String title;
    private int imageId;

    public Item(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {

        return title;
    }

    public int getImageId() {
        return imageId;
    }
}
