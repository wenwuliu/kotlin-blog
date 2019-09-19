package com.belphegor.lifeprograminstitute.config;

import com.alibaba.fastjson.JSONObject;
import com.belphegor.common.entity.ResponseEntity;
import com.belphegor.common.enums.RespCodeEnum;
import com.belphegor.lifeprograminstitute.entity.User;
import com.belphegor.lifeprograminstitute.service.UserService;
import com.belphegor.lifeprograminstitute.utils.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
@WebFilter(filterName = "belphegorFilter",urlPatterns = {"/*"})
public class BelphegorFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(BelphegorFilter.class);

    @Autowired
    UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init BelphegorFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("解析servlet,{}",servletRequest);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = request.getHeader("token");

        if("/login".equals(request.getRequestURI()) || "/register".equals(request.getRequestURI())){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        ResponseEntity responseEntity = new ResponseEntity();

        String method = request.getMethod();
        if(method.equalsIgnoreCase("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            if(null == token || token.isEmpty()){
                responseEntity = ResponseEntity.failed(RespCodeEnum.UNAUTHORIZED);
            }else {
                String username = TokenUtils.getUsercodeFromToken(token);
                User user = userService.getUserByUsername(username);
                if(user != null){
                    servletRequest.setAttribute("user",user);
                    responseEntity = ResponseEntity.success(user);
                }else {
                    responseEntity = ResponseEntity.failed(RespCodeEnum.UNAUTHORIZED);
                }
            }
        }
        if(responseEntity.getCode() == RespCodeEnum.UNAUTHORIZED.getCode()){
            PrintWriter writer = null;
            OutputStreamWriter osw = null;
            try {
                osw = new OutputStreamWriter(response.getOutputStream(),"UTF-8");
                writer = new PrintWriter(osw,true);
                writer.write(JSONObject.toJSONString(responseEntity));
                writer.flush();
                writer.close();
                osw.close();
            }catch (Exception e){
                log.error("过滤器返回信息失败" + e.getMessage(),e);
            }finally {
                if(null != writer){
                    writer.close();
                }
                if(null != osw){
                    osw.close();
                }
            }
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("destory BelphegorFilter");
    }
}
