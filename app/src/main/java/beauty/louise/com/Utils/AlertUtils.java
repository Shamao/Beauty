package beauty.louise.com.Utils;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import beauty.louise.com.CosmeApp;
import beauty.louise.com.bean.bean.MAlert;
import beauty.louise.com.ui.views.UIDialogTextView;
import princessmakeup.buykee.com.common.manager.AppManager;

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
                new AlertDialog.Builder(AppManager.getInstance().getCurActivity())
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
