package com.example.demo;

import javafx.scene.image.ImageView;

public class user_class {

    private ImageView user_img;
    private static user_class gen = null;
    public static user_class getInstance(ImageView a)
    {
        if (gen == null) {
            gen = new user_class(a);
        }
        return gen;
    }
    private user_class(ImageView a) {
        {
            this.user_img= a;
        }
    }

    public ImageView getUser_img() {
        return user_img;
    }

    public void setUser_img(ImageView user_img) {
        this.user_img = user_img;
    }
}