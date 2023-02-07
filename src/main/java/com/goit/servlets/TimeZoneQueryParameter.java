package com.goit.servlets;

import javax.servlet.http.HttpServletRequest;

public class TimeZoneQueryParameter {
    public String parseTimeZone(HttpServletRequest request) {
        if (request.getParameterMap().containsKey("timezone")) {
            return (request.getParameter("timezone").replace(" ", "+").length() < 1) ?
                    "UTC" : request.getParameter("timezone").replace(" ", "+").toUpperCase();
        }

        return "UTC";
    }
}