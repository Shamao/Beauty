package princessmakeup.buykee.com.common.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.drakeet.multitype.ItemViewBinder;
import princessmakeup.buykee.com.common.bean.MolUserBean;
import princessmakeup.buykee.com.common.view.holder.UserViewHolder;

/**
 * @author lsd
 * @date 2017/11/14.
 */

public class UserProvider extends ItemViewBinder<MolUserBean, UserViewHolder> {
    @NonNull
    @Override
    protected UserViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(UserViewHolder.getLayoutId(), parent, false);
        return new UserViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull UserViewHolder holder, @NonNull MolUserBean item) {

    }
}
