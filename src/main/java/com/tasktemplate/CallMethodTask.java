package com.tasktemplate;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年08月15日下午3:21
 * @Function : todo
 */
//import com.dianping.csc.pacific.api.common.exception.CscPacificException;
//import com.dianping.csc.pacific.monitor.exception.ResultCodeEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年08月14日下午3:38
 * @Function : todo
 */
public class CallMethodTask<T> implements Callable<T> {

    private static Logger LOGGER = LoggerFactory.getLogger(CallMethodTask.class);
    private static final String LOG_PREFIX = "[CallMethodTask 任务调用]-";


    private Object handle;


    private String methodName;


    private List<Class> paraType;


    private List<Object> paraValue;

    public CallMethodTask (Object handle, String methodName, List<Class> paraType,List<Object> paraValue) {

        this.handle = handle;
        this.methodName = methodName;
        this.paraType = paraType;
        this.paraValue = paraValue;
    }

    @Override
    public T call() throws Exception{

        Class c1 = handle.getClass();

        Method method = null;
        T result = null;
        Object objectresult = null;

        if (CollectionUtils.isEmpty(paraType) && CollectionUtils.isEmpty(paraValue)){

            try {
                method = c1.getMethod(this.methodName);
            } catch (NoSuchMethodException e) {
                LOGGER.error("{}  find class  method  handle={} method={} paraType={},paraValue={},e={}", LOG_PREFIX, handle, methodName,
                        paraType,paraValue, e);
                //throw new CscPacificException(ResultCodeEnum.RELIANCE_FIND_METHOD_ERROR,ResultCodeEnum.RELIANCE_FIND_METHOD_ERROR.getMsg());

            }

            try {
                objectresult = method.invoke(this.handle);
            } catch (Exception e) {
                LOGGER.error("{}  call invoke error handle={} method={} paraType={},paraValue={},e={}", LOG_PREFIX, handle, methodName,
                        paraType,paraValue, e);
              //  throw new CscPacificException(ResultCodeEnum.RELIANCE_CALL_METHOD_ERROR,ResultCodeEnum.RELIANCE_CALL_METHOD_ERROR.getMsg());
            }
            return (T)objectresult;
        }


        final int paramSize = paraType.size();
        if (paramSize != paraValue.size()){
           // throw new CscPacificException(ResultCodeEnum.PARAMETER_ERROR,ResultCodeEnum.PARAMETER_ERROR.getMsg());
        }

        //构造参数对象
        Class[] paramClasses = new Class[paramSize];
        Object[] args = new Object[paramSize];

        for (int i=0; i<paramSize; ++i){
            paramClasses[i] = paraType.get(i);
            args[i] = paraValue.get(i);
        }



        try {
            method = c1.getMethod(this.methodName,paramClasses);
        } catch (Exception e) {
            LOGGER.error("{}  find class  method  handle={} method={} paraType={},paraValue={},e={}", LOG_PREFIX, handle, methodName,
                    paraType,paraValue, e);
           // throw new CscPacificException(ResultCodeEnum.RELIANCE_FIND_METHOD_ERROR,ResultCodeEnum.RELIANCE_FIND_METHOD_ERROR.getMsg());
        }


        try {
            objectresult = method.invoke(this.handle,args);
        } catch (Exception e) {
            LOGGER.error("{}  call invoke error handle={} method={} paraType={},paraValue={},e={}", LOG_PREFIX, handle, methodName,
                    paraType,paraValue, e);
            //throw new CscPacificException(ResultCodeEnum.RELIANCE_CALL_METHOD_ERROR,ResultCodeEnum.RELIANCE_CALL_METHOD_ERROR.getMsg());
        }
        return (T)objectresult;
    }



}
