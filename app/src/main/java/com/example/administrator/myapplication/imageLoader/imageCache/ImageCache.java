package com.example.administrator.myapplication.imageLoader.imageCache;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017/7/3.
 */

public interface ImageCache {
    public Bitmap get(String url);

    public void put(String url, Bitmap bitmap);
}
