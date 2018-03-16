package cn.zPluto.common.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: dk05408
 * @date: 2017/12/25 9:48
 * Description:基础的Controller，里面包含success与fail的返回值及基础logger
 */
public class LCBaseController {

    private final Logger logger = LoggerFactory.getLogger(LCBaseController.class);

    /**
     * success返回对象
     * @param content 成功的要返回的数据
     * @return
     */
    protected LCResponse success(Object content) {
        return new LCResponse(LCResponse.STATUS_SUCCESS, LCResponse.MSG_SUCCESS,content);
    }


    /**
     * fail返回对象
     * @param msg fail msg
     * @return
     */
    protected LCResponse fail(String msg) {
        return fail(LCResponse.STATUS_FAIL,msg);
    }

    /**
     * fail返回对象
     * @param status fail code
     * @param msg fail msg
     * @return
     */
    protected LCResponse fail(String status,String msg) {
        LCResponse response = new LCResponse(status, msg);
        return response;
    }
}
