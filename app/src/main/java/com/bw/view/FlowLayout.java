package com.bw.view;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bw.wangqing20181221.R;

public class FlowLayout extends FrameLayout {

    public FlowLayout(@NonNull Context context) {
        super(context);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //点击搜索,,,将输入框的内容添加进去
    public void getData(String data) {
        //加载布局
        TextView textView = (TextView) View.inflate(getContext(), R.layout.text_layout, null);
        //设置文字
        textView.setText(data);
        //设置文字自适应
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        //添加视图
        addView(textView);

    }


    //布局
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //获取本控件的宽度
        int width = getWidth();
        int row = 0;//行数
        int disWidth = 20;//子控件左边的坐标
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);//查找子控件
            int viewWidth = view.getWidth();//获取子控件的宽度
            int viewHeight = view.getHeight();//获取子控件的高度
            //如果所有子控件的宽度和左边距加起来超过父控件的宽度，则进行换行
            if (disWidth + viewWidth > width) {
                //换行
                row++;
                disWidth = 20;//下一行的子控件的第一个控件的左边距相等
            }
            //设置子空间的位置
            view.layout(disWidth, viewHeight * row, disWidth + viewWidth, viewHeight * (row + 1));
            //记录下一次子控件的坐标
            disWidth += viewWidth;

        }
    }

}

