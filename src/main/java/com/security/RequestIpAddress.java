package com.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestIpAddress {

    private final static Logger logger = LoggerFactory.getLogger(RequestIpAddress.class);

    public @ResponseBody void logIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        if (ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0];
        }

        logger.info("User IP Address: " + ipAddress);
    }
}
