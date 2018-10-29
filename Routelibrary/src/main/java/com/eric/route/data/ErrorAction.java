package com.eric.route.data;

import android.content.Context;

import com.eric.route.utils.ExecutorServiceHelper;

import java.util.HashMap;


/**
 * @author li
 * @Package com.eric.route.data
 * @Title: ErrorAction
 * @Description: Copyright (c)
 * Create DateTime: 2017/4/18
 * 错误执行
 */

public class ErrorAction implements IAction {

    private static final String DEFAULT_MESSAGE = "Not found the action !";
    private int mCode;
    private String mMessage;

    /**
     * 无参构造方法
     */
    public ErrorAction() {
        mCode = RouteResponse.CODE_NOT_FOUND;
        mMessage = DEFAULT_MESSAGE;
    }

    /**
     * 同步方法，具体业务逻辑实现，默认实现
     *
     * @param context     上下文
     * @param requestData 调用参数
     * @return RouteResponse行为结果对象
     */

    @Override
    public RouteResponse invoke(Context context, HashMap<String, Object> requestData) {
        return new RouteResponse.Builder().code(mCode).msg(mMessage).data(null).build();
    }

    /**
     * 异步方法,具体业务逻辑实现，默认实现
     *
     * @param context     上下文
     * @param requestData 调用参数
     * @param listener    回调监听
     */

    @Override
    public void asyncInvoke(final Context context, final HashMap<String, Object> requestData, final RouteResultListener
            listener) {
        ExecutorServiceHelper.getInstance().execRun(new Runnable() {
            @Override
            public void run() {
                RouteResponse routeResponse = invoke(context, requestData);
                listener.onResult(routeResponse);
            }
        });
    }


}
