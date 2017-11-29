package buykee.com.common.bean;

import android.graphics.Typeface;

/**
 * 布局相关数据
 * 注意:不是单例
 *
 * @author lsd
 * @date 2017/11/9.
 */

public class MolLayoutBean {

    private int mWidth;
    private int mHeight;

    private int mBgResId;

    private int mTitleColorRes;
    private int mTitleSizeSp;
    private int mTitleGravity;
    private Typeface mTitleTypeFace;


    private MolLayoutBean() {

    }

    public static MolLayoutBean getInstance() {
        return new MolLayoutBean();
    }

    public MolLayoutBean withLayoutParams(int width, int height) {
        mWidth = width;
        mHeight = height;
        return this;
    }

    public MolLayoutBean withBgResId(int resId) {
        mBgResId = resId;
        return this;
    }

    public MolLayoutBean withTitle(int titleColorRes, int titleSizeSp, int titleGravity) {
        this.mTitleColorRes = titleColorRes;
        this.mTitleSizeSp = titleSizeSp;
        this.mTitleGravity = titleGravity;
        return this;
    }

    public MolLayoutBean withTitleTypeface(Typeface typeface) {
        mTitleTypeFace = typeface;
        return this;
    }



    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getBgResId() {
        return mBgResId;
    }

    public int getTitleColorRes() {
        return mTitleColorRes;
    }

    public int getTitleSizeSp() {
        return mTitleSizeSp;
    }

    public Typeface getTitleTypeFace() {
        return mTitleTypeFace;
    }

    public int getTitleGravity() {
        return mTitleGravity;
    }
}
