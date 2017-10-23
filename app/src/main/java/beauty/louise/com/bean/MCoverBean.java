package beauty.louise.com.bean;

import beauty.louise.com.R;

/**
 * Created by lsd on 17/8/31.
 */

public class MCoverBean {
    private String mImageUrl;
    private int mImageRes;
    private int mWidth;
    private int mHeight;


    public MCoverBean(String imageUrl, int width, int height) {
        mImageUrl = imageUrl;
        mWidth = width;
        mHeight = height;
    }

    public MCoverBean() {
        this(R.drawable.ph_planet, 0, 0);
    }

    public MCoverBean(int imgRes, int width, int height) {
        mImageRes = imgRes;
        mWidth = width;
        mHeight = height;
    }

    public MCoverBean(String imageUrl, int imageRes, int width, int height) {
        mImageUrl = imageUrl;
        mImageRes = imageRes;
        mWidth = width;
        mHeight = height;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public int getImageRes() {
        return mImageRes;
    }

    public void setImageRes(int imageRes) {
        mImageRes = imageRes;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }
}