package launch;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;

import java.io.File;
import java.io.IOException;

import vulnerableservlet.Log4jvulnservlet;
import launch.DefaultServlet;

public class Main {
    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
	String contextPath = "/";
	String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        tomcat.getHost().setAppBase(appBase);
	File docBase = new File(System.getProperty("java.io.tmpdir"));
	Context ctx = tomcat.addContext(contextPath, docBase.getAbsolutePath());

	Class servletClass = Log4jvulnservlet.class;
	Class servletClassDefault = DefaultServlet.class;
	tomcat.addServlet(ctx, servletClass.getSimpleName(), servletClass.getName());
	tomcat.addServlet(ctx, servletClassDefault.getSimpleName(), servletClassDefault.getName());
	ctx.addServletMappingDecoded("/forgot_password/*", servletClass.getSimpleName());
	ctx.addServletMappingDecoded("/", servletClassDefault.getSimpleName());

        tomcat.start();
        tomcat.getServer().await();
    }
}
