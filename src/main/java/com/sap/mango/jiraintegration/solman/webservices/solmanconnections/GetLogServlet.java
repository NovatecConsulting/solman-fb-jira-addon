package com.sap.mango.jiraintegration.solman.webservices.solmanconnections;

import com.sap.mango.jiraintegration.core.JsonServlet;
import org.apache.log4j.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Enumeration;

/**
 * Web service, that returns all authentication types.
 */
public class GetLogServlet extends JsonServlet {

    private static final org.apache.log4j.Logger log = LogManager.getLogger(GetLogServlet.class);
    private static final StringWriter writer = new StringWriter();


    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendOK(resp, writer.toString());
    }

    public GetLogServlet() {
        Logger root = Logger.getRootLogger();
        Enumeration<Appender> appenders = root.getAllAppenders();
        while(appenders.hasMoreElements()){
            Appender currentAppender = appenders.nextElement();
            if(currentAppender instanceof WriterAppender) {
                ((WriterAppender) currentAppender).setWriter(writer);
                break;
            }
        }
    }

    @Override
    public String requiredRoles() {
        return "jira-administrators";
    }
}
