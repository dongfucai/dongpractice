package util;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年09月07日下午2:37
 * @Function : todo
 */
public class UnifiedResponse {

    /** 响应码（必选字段）*/
    private int status;

    /** 响应码提示信息*/
    private String message;

    /** 附件信息，其他拓展信息，可选字段，一般可以是MAP*/
    private Object data;

    private int totalCount = 0;

//    public boolean successful() {
//        return this.status == ResultCodeEnum.SUCCESS.getCode();
//    }

//    public UnifiedResponse() {
//        this.status = ResultCodeEnum.SUCCESS.getCode();
//        this.message = ResultCodeEnum.SUCCESS.getMsg();
//    }

    public UnifiedResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public UnifiedResponse(Object data) {
//        this.status = ResultCodeEnum.SUCCESS.getCode();
//        this.message = ResultCodeEnum.SUCCESS.getMsg();

        //校验id返回
        if (data instanceof Long) {
            Map<String, Object> attachment = new HashMap<>();
            attachment.put("id", data);
            this.data = attachment;
        }else {
            this.data = data;
        }


        if(data instanceof Collection && CollectionUtils.isNotEmpty((Collection<?>) data)){
            totalCount = ((Collection) data).size();
        }else if(data instanceof Map && MapUtils.isNotEmpty((Map) data)){
            totalCount = ((Map) data).size();
        }
    }

//    public UnifiedResponse(PageInfo pageInfo) {
//        this.status = ResultCodeEnum.SUCCESS.getCode();
//        this.message = ResultCodeEnum.SUCCESS.getMsg();
//        Map<String, Object> attachment = new HashMap<>();
//        attachment.put("items", pageInfo.getList());
//        attachment.put("totalCount", pageInfo.getTotal());
//        this.data = attachment;
//    }

    public UnifiedResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

//    public UnifiedResponse(ResultCodeEnum resultCodeEnum) {
//        this.status = resultCodeEnum.getCode();
//        this.message = resultCodeEnum.getMsg();
//    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;

        if(data instanceof Collection && CollectionUtils.isNotEmpty((Collection<?>) data)){
            totalCount = ((Collection) data).size();
        }else if(data instanceof Map && MapUtils.isNotEmpty((Map) data)){
            totalCount = ((Map) data).size();
        }
    }

    public void setItems(List items){
        Map<String, Object> data = Maps.newHashMap();
        data.put("items", items);
        this.data = data;
    }


}
