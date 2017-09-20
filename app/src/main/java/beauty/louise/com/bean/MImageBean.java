package beauty.louise.com.bean;

import beauty.louise.com.R;

/**
 * Created by lsd on 17/8/31.
 */

public class MImageBean {
    private String mImageUrl;
    private int mImageRes;
    private int mHorizontalWeight;
    private int mVerticalWeight;

    public MImageBean() {
        this(R.drawable.ic_loading, 2, 1);
    }

    public MImageBean(int imgRes, int horizontalWeight, int verticalWeight) {
        mImageRes = imgRes;
        mHorizontalWeight = horizontalWeight;
        mVerticalWeight = verticalWeight;
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

    public int getHorizontalWeight() {
        return mHorizontalWeight;
    }

    public void setHorizontalWeight(int horizontalWeight) {
        mHorizontalWeight = horizontalWeight;
    }

    public int getVerticalWeight() {
        return mVerticalWeight;
    }

    public void setVerticalWeight(int verticalWeight) {
        mVerticalWeight = verticalWeight;
    }
}
