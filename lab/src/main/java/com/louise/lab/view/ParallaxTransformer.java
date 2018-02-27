package com.louise.lab.view;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

/**
 * @// TODO: 2018/2/8
 * @author lsd
 * @date 2018/2/8.
 */

public class ParallaxTransformer implements PageTransformer {

    /**
     * Apply a property transformation to the given page.
     *
     * @param page     Apply the transformation to this page
     * @param position Position of page relative to the current front-and-center
     *                 position of the pager. 0 is front and center. 1 is one full
     *                 page position to the right, and -1 is one page position to the left.
     */
    @Override
    public void transformPage(@NonNull View page, float position) {

    }
}
