package com.example.administrator.myapplication.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/3.
 */

public class CloseUtils {
    private CloseUtils(){}

    public static void closeQuietly(Closeable closeable){
        if (null != closeable){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
