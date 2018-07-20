package com.bill.compilermodule;

import javax.lang.model.element.VariableElement;

/**
 * Created by yuanweibiao on 2018/7/20.
 */

public class VariableInfo {
    // 被注解 View 的 Id 值
    int viewId;
    // 被注解 View 的信息：变量名称、类型
    VariableElement variableElement;

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    public void setVariableElement(VariableElement variableElement) {
        this.variableElement = variableElement;
    }

    public int getViewId() {
        return viewId;
    }

    public VariableElement getVariableElement() {
        return variableElement;
    }
}
