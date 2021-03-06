/**************************************************
 * Android Web Server
 * Based on JavaLittleWebServer (2008)
 * <p/>
 * Copyright (c) Piotr Polak 2008-2016
 **************************************************/

package example;

import java.io.PrintWriter;

import ro.polak.http.exception.ServletException;
import ro.polak.http.servlet.HttpServlet;
import ro.polak.http.servlet.HttpServletRequest;
import ro.polak.http.servlet.HttpServletResponse;

import static ro.polak.http.Headers.HEADER_TRANSFER_ENCODING;

/**
 * Chunked transfer with delay example.
 */
public class ChunkedWithDelay extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.getHeaders().setHeader(HEADER_TRANSFER_ENCODING, "chunked");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<table style='height: 40px; width: 100%; border: 0; cellspacing: 0;'>");
        printWriter.println("<tr><td style='background-color: green'></td>");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
            }
            printWriter.println("<td style='background-color: black'></td>");
            printWriter.flush();
        }
        printWriter.println("<tr></table>");
    }
}
