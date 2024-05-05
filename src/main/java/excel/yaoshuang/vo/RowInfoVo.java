package excel.yaoshuang.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2019/8/7 下午11:39
 * @Version 1.0
 **/

@Data
public class RowInfoVo implements Serializable {


    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 语言
     */
    private String cn;

    /**
     * 展现错误信息（个人网银）
     */
    private String showErrorInfo;

    /**
     * 内部错误信息
     */
    private String innerErrorInfo;

    /**
     * 生效系统，个人网银只取0-全部，1-个人网银
     */
    private String validSystem;

    /**
     * 状态0-有效
     */
    private String status;

    /**
     * 展示错误信息(BP)
     */
    private String errorInfoBP;


}
