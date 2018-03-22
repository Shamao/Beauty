package com.louise.base.base.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author lsd
 * @date 2018/3/22.
 */

public interface IBaseView {

    Intent getIntentAlias();

    Bundle getArgumentAlias();

    Context getContext();
}
