package com.louise.base.manager;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

import com.louise.base.utils.ALogger;

import java.lang.ref.WeakReference;

/**
 * 全局的Handler 使用
 *
 * @author liusaideng
 * @date 2018/9/26 上午9:54
 */
public class HandlerManager {

    private static final String TAG = "Handler";
    private static MyHandler mHandler = new MyHandler();

    public static void register(int what, OnHandleMessageListener listener) {
        mHandler.register(what, listener);
    }

    public static void unRegister(int what) {
        mHandler.unRegister(what);
    }

    public static void sendEmptyMessage(int what) {
        mHandler.sendEmptyMessage(what);
    }

    public static void sendMessage(Message msg) {
        mHandler.sendMessage(msg);
    }

    public static void sendMessageDelayed(Message msg, long delay) {
        mHandler.sendMessageDelayed(msg, delay);
    }

    public static class MyHandler extends Handler {

        private SparseArray<WeakReference<OnHandleMessageListener>> mWeakReferences;

        public MyHandler() {
            mWeakReferences = new SparseArray<>();
        }

        public void register(int what, OnHandleMessageListener listener) {
            mWeakReferences.put(what, new WeakReference<OnHandleMessageListener>(listener));
        }

        public void unRegister(int what) {
            mWeakReferences.remove(what);
            removeMessages(what);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            WeakReference<OnHandleMessageListener> weakReference = mWeakReferences.get(msg.what);
            if (weakReference == null) {
                ALogger.d(TAG, "current msg without OnHandleMessageListener");
            } else if (weakReference.get() == null) {
                ALogger.d(TAG, "listener is alloc");
                mWeakReferences.remove(msg.what);
            } else {
                weakReference.get().handleMessage(msg);
            }
        }
    }

    public interface OnHandleMessageListener {
        void handleMessage(Message msg);
    }
}
