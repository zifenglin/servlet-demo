package com.huafa.group.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    String encode = "utf-8";

    public void destroy() {
        System.out.println("this is encodingFilter  destroy");

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String encodeVal = config.getInitParameter("encode");
        System.out.println(encodeVal);
        if (null != encodeVal && encodeVal.trim().length() > 0) {
            encode = encodeVal.trim();
        }
    }

}
