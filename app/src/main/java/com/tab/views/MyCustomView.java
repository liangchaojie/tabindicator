package com.tab.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sina.licaishi.commonuilib.indicator.impl.IMeasureablePagerTitleView;
import com.tab.R;


/**
 * 自定义一组合布局，包括一个TextView和ImageView
 */
public class MyCustomView extends ViewGroup implements IMeasureablePagerTitleView {
    private ImageView mImageView;
    private TextView mTextView;
    private Context context;

    protected int mSelectedColor;
    protected int mNormalColor;

    public boolean isShowArrow() {
        return showArrow;
    }

    private boolean showArrow;//显示箭头吗?
    public MyCustomView(Context context) {
        this(context,null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        View view= LayoutInflater.from(context).inflate(R.layout.tab_item, this);
        initView(view);
    }

    private void initView(View view) {
        mTextView = view.findViewById(R.id.tv_title);
        mImageView = view.findViewById(R.id.img_arrow);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        View view = getChildAt(0);
        view.layout(0,0,view.getMeasuredWidth(),view.getMeasuredHeight());
    }

    @Override
    public int getContentLeft() {
        return 0;
    }

    @Override
    public int getContentTop() {
        return 0;
    }

    @Override
    public int getContentRight() {
        return 0;
    }

    @Override
    public int getContentBottom() {
        return 0;
    }

    @Override
    public void onSelected(int i, int i1) {
        if(mImageView==null || mTextView==null) return;

        mTextView.setTextColor(mSelectedColor);

        if(showArrow){
            mImageView.setVisibility(VISIBLE);
        }else {
            mImageView.setVisibility(GONE);
        }
    }

    @Override
    public void onDeselect(int i, int i1) {
        if(mTextView!=null){
            mTextView.setTextColor(mNormalColor);
        }
        if(mImageView!=null){
            mImageView.setVisibility(GONE);
        }
    }

    @Override
    public void inLeave(int i, int i1, float v, boolean b) {
    }

    @Override
    public void onEnter(int i, int i1, float v, boolean b) {
    }

    @Override
    public void setText(String s) {
        if(mTextView!=null){
            mTextView.setText(s);
        }
    }

    public void  setArrowDirection(int direction){
        if(mImageView==null) return;

        if(direction==0){
            //todo  设置方向朝上
            Toast.makeText(getContext(),"箭头朝上了",Toast.LENGTH_SHORT).show();
        }else {
            //todo  设置方向朝下
            Toast.makeText(getContext(),"箭头朝下了",Toast.LENGTH_SHORT).show();
        }

    }

    public void  setTextSize(float f){
        if(mTextView!=null){
            mTextView.setTextSize(f);
        }
    }
    public void setmSelectedColor(int mSelectedColor) {
        this.mSelectedColor = mSelectedColor;
    }

    public void setmNormalColor(int mNormalColor) {
        this.mNormalColor = mNormalColor;
    }

    public void setShowArrow(boolean showArrow) {
        this.showArrow = showArrow;
    }
}
