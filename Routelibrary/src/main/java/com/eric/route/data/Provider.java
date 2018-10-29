package com.eric.route.data;

import java.util.HashMap;


/**
 * @author li
 * @Package com.eric.route.data
 * @Title: Provider
 * @Description: Copyright (c)
 * Create DateTime: 2017/4/18
 * 抽象服务提供者
 */
public abstract class Provider {
    private HashMap<String, IAction> mActions;

    /**
     * 无参构造方法
     */
    public Provider() {
        mActions = new HashMap<>();
        registerActions();
    }

    /**
     * 注册行为逻辑
     *
     * @param actionName 行为逻辑名称
     * @param action     具体行为逻辑实现类
     */
    protected final void registerAction(String actionName, IAction action) {
        mActions.put(actionName, action);
    }

    /**
     * 根据名称查找对应的行为逻辑实现类
     *
     * @param actionName 行为逻辑名称
     * @return 具体的行为逻辑实现
     */
    protected final IAction findAction(String actionName) {
        return mActions.get(actionName);
    }

    /**
     * 抽象方法，注册行为逻辑
     */
    protected abstract void registerActions();

     void unRegisterAllAction() {
        if (mActions != null) {
            mActions.clear();
        }
    }

}
