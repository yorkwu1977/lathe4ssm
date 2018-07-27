package com.tap.lathe4ssm.core.generic;

/**
 * 所有自定义枚举类型实现该接口
 * 
 * @author York Wu
 * @since 
 **/
public interface GenericEnum<V, T> {

    /**
     * value: 常量的保存值
     */
    public V getValue();

    /**
     * text : 常量的显示文本
     */
    public T getText();

}
