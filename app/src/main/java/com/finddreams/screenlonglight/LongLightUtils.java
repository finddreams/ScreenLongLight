package com.finddreams.screenlonglight;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.os.PowerManager;
import android.view.WindowManager;

/**
 * Created by lx on 17-10-26.
 */

public class LongLightUtils {
    /**
     * 是否使屏幕常亮
     *
     * @param activity
     */
    public static void keepScreenLongLight(Activity activity) {
        boolean isOpenLight = CommSharedUtil.getInstance(activity).getBoolean(CommSharedUtil.FLAG_IS_OPEN_LONG_LIGHT, true);
        if (isOpenLight) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }

    }

    /**
     * 打开休眠锁只能保持手机不休眠
     * @param context
     */
    @Deprecated
    public static void openWakeLock(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Service.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Lock");
        //是否需计算锁的数量
        wakeLock.setReferenceCounted(false);
        //请求常亮，onResume()
        wakeLock.acquire();
    }

    /**
     * 关闭休眠锁
     * @param context
     */
    @Deprecated
    public static void closeWakeLock(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Service.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Lock");
        //是否需计算锁的数量
        wakeLock.setReferenceCounted(false);
        //取消屏幕常亮，onPause()
        wakeLock.release();

    }
}
