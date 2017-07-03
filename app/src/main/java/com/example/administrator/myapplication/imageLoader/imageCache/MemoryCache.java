package com.example.administrator.myapplication.imageLoader.imageCache;

/**
 * Created by Administrator on 2017/7/3.
 */

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 处理图片缓存
 */
public class MemoryCache implements ImageCache {
    // 图片缓存
    LruCache<String, Bitmap> mImageCache;

    public MemoryCache(){
        initImageCache();
    }

    private void initImageCache() {
        // 计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // 取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;

        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap){
        mImageCache.put(url, bitmap);
    }

    public Bitmap get(String url){
        return mImageCache.get(url);
    }
}
