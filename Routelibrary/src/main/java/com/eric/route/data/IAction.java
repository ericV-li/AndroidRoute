package com.eric.route.data;

import android.content.Context;

import java.util.HashMap;

/**
 * @author li
 * @Package com.eric.route.data
 * @Title: IAction
 * @Description: Copyright (c)
 * Create DateTime: 2017/4/18
 * 逻辑行为接口
 */

public interface IAction {
    /**
     * 同步方法
     *
     * @param context     上下文
     * @param requestData 请求参数
     * @return RouteResponse对象
     */
    RouteResponse invoke(Context context, HashMap<String, Object> requestData);

    /**
     * 异步方法
     *
     * @param context     上下文
     * @param requestData 请求参数
     * @param listener    回调监听
     */
    void asyncInvoke(final Context context, final HashMap<String, Object> requestData, final RouteResultListener listener);
}
