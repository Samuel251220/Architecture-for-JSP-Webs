package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/template/header.jspf");
    _jspx_dependants.add("/WEB-INF/template/fo2.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>LP1</title>        \n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"img/logo.ico\">\n");
      out.write("        ");
      out.write("<link href=\"faw/web-fonts-with-css/css/fontawesome-all.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"css/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function deshabilitaRetroceso(){\n");
      out.write("                window.location.hash=\"no-back-button\";\n");
      out.write("                window.location.hash=\"Again-No-back-button\"; //chrome\n");
      out.write("                window.onhashchange=function(){window.location.hash=\"no-back-button\";}\n");
      out.write("             }\n");
      out.write("        </script>\n");
      out.write("        <script src=\"js/angular.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"deshabilitaRetroceso()\" ng-app=\"app\" ng-controller=\"appController\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <!-- Static navbar -->\n");
      out.write("            <nav class=\"navbar navbar-default\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                        </button>\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\"><img src=\"img/ep.png\" alt=\"\" width=\"24\" height=\"24\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("                            <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("                            <li><a href=\"#\">About</a></li>\n");
      out.write("                            <li><a href=\"#\">Contact</a></li>\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Dropdown <span class=\"caret\"></span></a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li><a href=\"#\">Action</a></li>\n");
      out.write("                                    <li><a href=\"#\">Another action</a></li>\n");
      out.write("                                    <li><a href=\"#\">Something else here</a></li>\n");
      out.write("                                    <li role=\"separator\" class=\"divider\"></li>\n");
      out.write("                                    <li class=\"dropdown-header\">Nav header</li>\n");
      out.write("                                    <li><a href=\"#\">Separated link</a></li>\n");
      out.write("                                    <li><a href=\"#\">One more separated link</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                          <!--  <li class=\"active\"><a href=\"./\">Default <span class=\"sr-only\">(current)</span></a></li> -->\n");
      out.write("                            <li><a href=\"#\">Static top</a></li>\n");
      out.write("                            <li><a href=\"#\" style=\"color: #33ccff;\" id=\"login\" ng-click=\"login()\"><i class=\"fas fa-users-cog fa-lg\"></i></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div><!--/.nav-collapse -->\n");
      out.write("                </div><!--/.container-fluid -->\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <!-- Main component for a primary marketing message or call to action -->\n");
      out.write("            <div class=\"jumbotron\">\n");
      out.write("                <div>\n");
      out.write("                    <img src=\"img/car.jpg\" class=\"img-responsive\" alt=\"#\">\n");
      out.write("                </div>                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-sm\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <img src=\"img/user2.png\" style=\"border-radius: 50%;border: 1px solid #cccccc; padding: 5px;\">\n");
      out.write("                    </div>\n");
      out.write("                    <form method=\"post\" action=\"main\">\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Ingresar Usuario\" name=\"user\">\n");
      out.write("                            <input type=\"hidden\" value=\"1\" name=\"op\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"password\" class=\"form-control\" placeholder=\"Ingresar Password\" name=\"pass\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-primary\" value=\"Enviar\" >\n");
      out.write("                    </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Login-->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
      out.write("<script src=\"js/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/home.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
