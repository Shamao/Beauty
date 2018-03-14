package com.louise.lab.adapter;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;

import java.util.List;

/**
 * @author lsd
 * @date 2018/3/13.
 */

public class MainDiffCallBack extends DiffUtil.Callback {
    private List<Object> mOldList;
    private List<Object> mNewList;

    public MainDiffCallBack(List<Object> oldList, List<Object> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList == null ? 0 : mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList == null ? 0 : mNewList.size();

    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Logger.d(ConstTag.S_VIEW, "areItemsTheSame", oldItemPosition, newItemPosition);
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        if (areItemsTheSame(oldItemPosition, newItemPosition)) {
            return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
        }
        return false;
    }


    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
