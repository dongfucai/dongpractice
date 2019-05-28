package com.template;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年09月25日下午5:57
 * @Function : todo
 */
public class BeanListCopyUtil<T,S> {

    private Class<T> targetType;
    BeanListCopyUtil(Class<T> targetType) {
        this.targetType = targetType;
    }

    public List<T> copy(List<S> src) {
        List target = Lists.newArrayList();
        for ( S s : src ) {
            T t = BeanUtils.instantiateClass(targetType);
            BeanUtils.copyProperties(s, t);
            target.add(t);
        }
        return target;
    }

    public static void main(String[] args) {

        new BeanListCopyUtil<Object,Object>(Object.class);

    }

}
