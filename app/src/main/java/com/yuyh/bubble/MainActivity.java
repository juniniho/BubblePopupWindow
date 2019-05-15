package com.yuyh.bubble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yuyh.library.BubblePopupWindow;

public class MainActivity extends AppCompatActivity {

    private BubblePopupWindow leftTopWindow;
    private BubblePopupWindow rightTopWindow;
    private BubblePopupWindow leftBottomWindow;
    private BubblePopupWindow rightBottomWindow;
    private BubblePopupWindow centerWindow;

    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftTopWindow = new BubblePopupWindow(MainActivity.this);
        rightTopWindow = new BubblePopupWindow(MainActivity.this);
        leftBottomWindow = new BubblePopupWindow(MainActivity.this);
        rightBottomWindow = new BubblePopupWindow(MainActivity.this);
        centerWindow = new BubblePopupWindow(MainActivity.this);

        inflater = LayoutInflater.from(this);
    }

    public void leftTop(View view) {
        View bubbleView = inflater.inflate(R.layout.layout_popup_view, null);
        TextView tvContent = (TextView) bubbleView.findViewById(R.id.tvContent);
        tvContent.setText("HelloWorld");
        leftTopWindow.setBubbleView(bubbleView);
        leftTopWindow.show(view, Gravity.BOTTOM);
    }

    public void rightTop(View view) {
        //测试自定义布局
        View bubbleView = inflater.inflate(R.layout.view_popup_menu, null);
        centerWindow.setBubbleView(bubbleView);
        centerWindow.show(view, Gravity.BOTTOM, dip2px(103),-dip2px(30),100);
    }

    public void leftBottom(View view) {
        View bubbleView = inflater.inflate(R.layout.layout_popup_view, null);
        leftBottomWindow.setBubbleView(bubbleView);
        leftBottomWindow.show(view);
    }

    public void rightBottom(View view) {
        View bubbleView = inflater.inflate(R.layout.layout_popup_view, null);
        rightBottomWindow.setBubbleView(bubbleView);
        rightBottomWindow.show(view, Gravity.RIGHT, 0,0,0);
    }

    public void center(View view) {
        View bubbleView = inflater.inflate(R.layout.layout_popup_view, null);
        centerWindow.setBubbleView(bubbleView);
        centerWindow.show(view, Gravity.BOTTOM, 0,0,0);
    }

    /**
     * dip转换px
     */
    public int dip2px(int dip) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

}
