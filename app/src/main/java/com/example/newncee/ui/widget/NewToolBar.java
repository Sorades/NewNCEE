package com.example.newncee.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;

import com.example.newncee.R;

import java.util.zip.Inflater;

/**
 * @Author Sora
 * Time: 2021/10/16  23:06
 * Description:
 */
public class NewToolBar extends Toolbar {
    private LayoutInflater mInflater;

    private View mView;
    private TextView mTextTitle;
    private EditText mSearchView;
    private ImageButton mRightImageButton;

    public NewToolBar(@NonNull Context context) {
        super(context);
        initView();
        mSearchView.setVisibility(VISIBLE);
    }

    public NewToolBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
        mSearchView.setVisibility(VISIBLE);
    }

    @SuppressLint("RestrictedApi")
    public NewToolBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();

        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, R.styleable.NewToolBar, defStyleAttr, 0);

            final Drawable rightIcon = a.getDrawable(R.styleable.NewToolBar_rightButtonIcon);
            if (rightIcon != null)
                setRightButtonIcon(rightIcon);
            boolean isShowSearchView = a.getBoolean(R.styleable.NewToolBar_isShowSearchView, false);
            if (isShowSearchView) {
                showSearchView();
                hideTitleView();
            }

            a.recycle();
        }
    }

    private void initView() {
        mInflater = LayoutInflater.from(getContext());

        if (mView == null) {

            mView = mInflater.inflate(R.layout.toolbar_search, null);

            mTextTitle = (TextView) mView.findViewById(R.id.tb_title);
            mSearchView = (EditText) mView.findViewById(R.id.tb_searchView);
            Drawable drawable = getResources().getDrawable(R.drawable.ic_search_white);
            drawable.setBounds(0, 0, 40, 40);
            mSearchView.setCompoundDrawables(drawable, null, null, null);
            mRightImageButton = (ImageButton) mView.findViewById(R.id.tb_rightButton);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);
        }
    }

    public void setRightButtonIcon(Drawable icon) {
        if (mRightImageButton != null) {
            mRightImageButton.setImageDrawable(icon);
            mRightImageButton.setVisibility(VISIBLE);
        }
    }

    @Override
    public void setTitle(int resId) {
        super.setTitle(resId);
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (mTextTitle != null)
            mTextTitle.setText(title);
        showTitleView();
    }

    public void showSearchView() {
        if (mSearchView == null)
            return;
        mSearchView.setVisibility(VISIBLE);
    }

    public void hideSearchView() {
        if (mSearchView == null)
            return;
        mSearchView.setVisibility(GONE);
    }

    public void showTitleView() {
        if (mTextTitle == null)
            return;
        mTextTitle.setVisibility(VISIBLE);
    }

    public void hideTitleView() {
        if (mTextTitle == null)
            return;
        mTextTitle.setVisibility(GONE);
    }
}
