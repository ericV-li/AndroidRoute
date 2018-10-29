package com.eric.route.data;

/**
 * @author li
 * @Package com.eric.route.data
 * @Title: RouteResultListener
 * @Description: Copyright (c)
 * Create DateTime: 2017/4/18
 * 路由结果监听者
 */
public interface RouteResultListener {

    /**
     * 回调方法
     *
     * @param response RouteResponse结果对象
     */
    void onResult(RouteResponse response);
}
