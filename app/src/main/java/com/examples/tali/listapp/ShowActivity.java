package com.examples.tali.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.ImageView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent in = getIntent();
        int index = in.getIntExtra("com.examples.tali.ITEM_INDEX", -1);

        if(index > -1){
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }
    private int getImage(int index){
        switch (index){
            case 0: return R.drawable.peach;
            case 1: return  R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;

        }
    }
    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);
        int imageWidth = options.outWidth;
        int screenWidth = screen.getWidth();
        if (imageWidth > screenWidth){
            int ration = Math.round((float) imageWidth/(float) screenWidth);
            options.inSampleSize = ration;
        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);


    }
}
