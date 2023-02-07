package com.goit.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    private final TimeZoneQueryParameter queryParameter = new TimeZoneQueryParameter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZoneId zoneId = ZoneId.of(queryParameter.parseTimeZone(req));
        Clock clock = Clock.system(zoneId);

        String currentTime = LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " " + zoneId;

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(currentTime);
        resp.getWriter().close();
    }
}