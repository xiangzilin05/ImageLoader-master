package com.example.administrator.myapplication.imageLoader.imageCache;

/**
 * Created by Administrator on 2017/7/3.
 */

import android.graphics.Bitmap;

/**
 * 双缓存。获取图片时先从内存中获取，如果内存中没有缓存该图片，再从SD卡中获取。
 * 缓存图片在内存和SD卡中都缓存一份。
 */
public class DoubleCache implements ImageCache {
    MemoryCache mMemoryCahe = new MemoryCache();
    DiskCache mDiskCache = new DiskCache();

    // 先从内存缓存中获取图片，如果没有，再从SD卡中获取
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCahe.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    // 将图片缓存到内存和SD卡中
    public void put(String url, Bitmap bitmap){
        mMemoryCahe.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
