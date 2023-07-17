package launch;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.Writer;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;

public class DefaultServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
    try {
      res.setContentType("text/html; charset=utf-8");
      Writer writer = res.getWriter();
      writer.write("<!DOCTYPE html>\n");
      writer.write("<html>\n");
      writer.write("<head>\n");
      writer.write("  <meta charset=\"utf-8\">\n");
      writer.write("  <title>Página de inicio de sesión</title>\n");
      writer.write("  <style>\n");
      writer.write("    body {\n");
      writer.write("      font-family: Arial, sans-serif;\n");
      writer.write("      background-color: #f2f2f2;\n");
      writer.write("      margin: 0;\n");
      writer.write("      padding: 0;\n");
      writer.write("    }\n");
      writer.write("    .container {\n");
      writer.write("      width: 400px;\n");
      writer.write("      margin: 100px auto;\n");
      writer.write("      padding: 40px;\n");
      writer.write("      border-radius: 5px;\n");
      writer.write("      background-color: #fff;\n");
      writer.write("      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\n");
      writer.write("    }\n");
      writer.write("    h2 {\n");
      writer.write("      text-align: center;\n");
      writer.write("      color: #333;\n");
      writer.write("      margin-bottom: 30px;\n");
      writer.write("    }\n");
      writer.write("    .form-group {\n");
      writer.write("      margin-bottom: 20px;\n");
      writer.write("    }\n");
      writer.write("    .form-group label {\n");
      writer.write("      display: block;\n");
      writer.write("      font-size: 14px;\n");
      writer.write("      color: #666;\n");
      writer.write("      margin-bottom: 5px;\n");
      writer.write("    }\n");
      writer.write("    .form-group input {\n");
      writer.write("      width: 100%;\n");
      writer.write("      padding: 10px;\n");
      writer.write("      border: 1px solid #ccc;\n");
      writer.write("      border-radius: 3px;\n");
      writer.write("      font-size: 14px;\n");
      writer.write("    }\n");
      writer.write("    .form-group input[type=\"submit\"] {\n");
      writer.write("      width: auto;\n");
      writer.write("      cursor: pointer;\n");
      writer.write("      background-color: #4CAF50;\n");
      writer.write("      color: #fff;\n");
      writer.write("      font-weight: bold;\n");
      writer.write("      border: none;\n");
      writer.write("      padding: 12px 20px;\n");
      writer.write("      transition: background-color 0.3s ease;\n");
      writer.write("    }\n");
      writer.write("    .form-group input[type=\"submit\"]:hover {\n");
      writer.write("      background-color: #45a049;\n");
      writer.write("    }\n");
      writer.write("    .form-group .forgot-password {\n");
      writer.write("      font-size: 12px;\n");
      writer.write("      text-align: right;\n");
      writer.write("      color: #888;\n");
      writer.write("      text-decoration: none;\n");
      writer.write("    }\n");
      writer.write("    .form-group .forgot-password:hover {\n");
      writer.write("      color: #555;\n");
      writer.write("    }\n");
      writer.write("  </style>\n");
      writer.write("</head>\n");
      writer.write("<body>\n");
      writer.write("  <div class=\"container\">\n");
      writer.write("    <h2>Iniciar sesión</h2>\n");
      writer.write("    <form>\n");
      writer.write("      <div class=\"form-group\">\n");
      writer.write("        <label for=\"username\">Nombre de usuario:</label>\n");
      writer.write("        <input type=\"text\" id=\"username\" name=\"username\" required>\n");
      writer.write("      </div>\n");
      writer.write("      <div class=\"form-group\">\n");
      writer.write("        <label for=\"password\">Contraseña:</label>\n");
      writer.write("        <input type=\"password\" id=\"password\" name=\"password\" required>\n");
      writer.write("      </div>\n");
      writer.write("      <div class=\"form-group\">\n");
      writer.write("        <input type=\"submit\" value=\"Iniciar sesión\">\n");
      writer.write("      </div>\n");
      writer.write("      <div class=\"form-group\">\n");
      writer.write("        <a href=\"forgot_password\" class=\"forgot-password\">¿Olvidaste tu contraseña?</a>\n");
      writer.write("      </div>\n");
      writer.write("    </form>\n");
      writer.write("  </div>\n");
      writer.write("</body>\n");
      writer.write("</html>");

    } catch(Exception e) {
      throw new ServletException(e.getMessage(), e);
    }
  }
}

