package com.example.administrator.myapplication.windowView;

/**
 * Created by Administrator on 2017/7/3.
 */

public abstract class View {
    public abstract void draw();
    public void measure(int width, int height){
        // 测量视图大小
    }
}
