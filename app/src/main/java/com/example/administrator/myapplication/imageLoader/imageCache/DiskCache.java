package com.example.administrator.myapplication.imageLoader.imageCache;

/**
 * Created by Administrator on 2017/7/3.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.administrator.myapplication.utils.CloseUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将图片缓存到SD卡中
 */
public class DiskCache implements ImageCache{
    static String cacheDir = "sdcard/cache/";

    // 从缓存中获取图片
    public Bitmap get(String url){
        return BitmapFactory.decodeFile(cacheDir + url);
    }

    // 将图片缓存到内存中
    public void put(String url, Bitmap bitmap){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeQuietly(fileOutputStream);
        }
    }
}










