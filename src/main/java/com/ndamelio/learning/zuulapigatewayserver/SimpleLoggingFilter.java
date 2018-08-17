package com.ndamelio.learning.zuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SimpleLoggingFilter extends ZuulFilter {

    private static Logger LOG = LoggerFactory.getLogger(SimpleLoggingFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest httpRequest = context.getRequest();
        LOG.info("Request Method: {} \n URL: {}", httpRequest.getMethod(), httpRequest.getRequestURL().toString());
        return null;
    }
}
