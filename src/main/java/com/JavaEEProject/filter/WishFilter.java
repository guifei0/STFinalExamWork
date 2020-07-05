package com.JavaEEProject.filter;

import com.JavaEEProject.controller.UserController;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import java.io.IOException;
import java.io.OutputStream;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2020/6/28
//Time: 20:10
//To change this template use File | Settings | File Templates.
public class WishFilter implements Filter {
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /** 过滤筛选
     * @param arg0 参数0
     * @param arg1 参数1
     * @param arg2 参数2
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     */
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        String parameterName = null;
        String parameterValue = arg0.getParameter("str");;
        // 获取请求的参数
        parameterValue =new String(parameterValue.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(parameterValue+"传值");
        boolean ok=true;
        if(null != parameterValue){
            for(String str : invalidCharacter){
                if (StringUtils.containsIgnoreCase(parameterValue, str)){
                    arg1.setContentType("application/json; charset=utf-8");
                    arg1.setCharacterEncoding("UTF-8");
                    JSONObject obj = new JSONObject();
                    obj.put("json",0);
//                    arg1.getWriter().print(obj.toString());
                    ok=false;
                    OutputStream out = arg1.getOutputStream();
                    out.write(obj.getString("json").getBytes("UTF-8"));
                    out.flush();
                }
            }
            if(ok)arg2.doFilter(arg0, arg1); // 执行目标资源，放行
        }
        else{
            arg2.doFilter(arg0, arg1); // 执行目标资源，放行
        }
    }

    /** 初始化
     * @param arg0 FilterConfig参数0
     * @throws ServletException Servlet异常
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
    private String[] invalidCharacter = new String[]{
            "rnm","ctm","fuck","shit","cnm","rtm","nmsl","日妈","哈麻批","宝批龙","嘛卖批","我靠","我草","我艹","我日"
    };
}
