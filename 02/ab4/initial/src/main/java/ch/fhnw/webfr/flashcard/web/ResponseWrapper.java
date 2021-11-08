package ch.fhnw.webfr.flashcard.web;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.*;

public class ResponseWrapper extends HttpServletResponseWrapper {

    private CharArrayWriter wr = new CharArrayWriter();

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public PrintWriter getWriter() {
        return new PrintWriter(wr);
    }

    public Reader getReader() {
        wr.flush();
        wr.close();
        return new CharArrayReader(wr.toCharArray());
    }

}
