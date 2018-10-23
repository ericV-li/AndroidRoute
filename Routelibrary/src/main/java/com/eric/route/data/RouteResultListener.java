/**
 * @Package com.transfar.router.link
 * @Title: RouteResultListener
 * @Description (业务逻辑结果调用监听者)
 * Copyright (c) 传化公路港物流有限公司版权所有
 * Create DateTime: 2017/6/13
 * @Author czl 2017/6/13
 */
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
