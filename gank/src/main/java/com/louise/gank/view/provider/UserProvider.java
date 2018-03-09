package com.louise.gank.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.louise.gank.bean.MUserBean;
import com.louise.gank.databinding.GankItemUserBinding;
import com.louise.gank.view.holder.UserViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lsd
 * @date 2018/3/5.
 */

public class UserProvider extends ItemViewBinder<MUserBean, UserViewHolder> {
    GankItemUserBinding binding;

    @NonNull
    @Override
    protected UserViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        binding = GankItemUserBinding.inflate(inflater, parent, false);
        return new UserViewHolder(binding.getRoot());
    }

    @Override
    protected void onBindViewHolder(@NonNull UserViewHolder holder, @NonNull MUserBean item) {
        binding.setUser(item);
    }
}
