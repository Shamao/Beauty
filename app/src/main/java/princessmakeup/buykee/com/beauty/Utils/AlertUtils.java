package princessmakeup.buykee.com.beauty.Utils;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import princessmakeup.buykee.com.beauty.AppManager;
import princessmakeup.buykee.com.beauty.CosmeApp;
import princessmakeup.buykee.com.beauty.bean.bean.MAlert;
import princessmakeup.buykee.com.beauty.ui.views.UIDialogTextView;

/**
 * Created by Steam on 16/12/13.
 */

public class AlertUtils {

    /**
     * 显示默认alert
     * @param alertModel
     */
    public static void showAlert(final MAlert alertModel) {
        if (alertModel == null) {
            return;
        }

        UIDialogTextView messageTv = new UIDialogTextView(CosmeApp.getInstance());
        AlertDialog.Builder builder =
                new AlertDialog.Builder(AppManager.getInstance().currentActivity())
                        .setView(messageTv);
        if (alertModel.getPositive() != null) {
            builder.setPositiveButton(alertModel.getPositive().getName(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    CosmeApp.getInstance().redirectSchema(alertModel.getPositive().getRedirectSchema());
                }
            });
        }
        if (alertModel.getNegative() != null) {
            builder.setNegativeButton(alertModel.getNegative().getName(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    CosmeApp.getInstance().redirectSchema(alertModel.getNegative().getRedirectSchema());
                }
            });
        }
        if (alertModel.getNeutral() != null) {
            builder.setNeutralButton(alertModel.getNegative().getName(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    CosmeApp.getInstance().redirectSchema(alertModel.getNegative().getRedirectSchema());
                }
            });
        }
        builder.show();
    }


}
