package cn.zPluto.api.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/17.
 */
public class AccessFilter  extends ZuulFilter{

    private static Logger log= LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否执行。 实际项目中可以利用该函数来指定过滤器的有效范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx= RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("Send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        Object accessToken=request.getParameter("accessToken");
        log.info("accessToken"+accessToken);
        /**
         * if(accessToken == null ){
         ctx.setSendZuulResponse(false);
         ctx.setResponseStatusCode(401);
         return null;
         }
         */
        log.info("access token ok");
        return null;
    }
}
