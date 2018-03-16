package cn.zPluto.common.web;


/**
 * @author: dk05408
 * @date: 2017/12/25 9:46
 * Description:理财返回状态和相关信息的实体类
 */
public class LCResponse {
    public static final  String MSG_SUCCESS = "success";
    public static final String STATUS_SUCCESS = "200";

    public final static String STATUS_FAIL = "fail";

    private String status;
    private String message;
    private Object content;

    public LCResponse() {
    }

    public LCResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public LCResponse success(Object content){
        return new LCResponse(STATUS_SUCCESS, MSG_SUCCESS,content);
    }

    public LCResponse(String status, String message, Object content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
