package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class rol_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/view/../WEB-INF/template/headerMain.jspf");
    _jspx_dependants.add("/view/../WEB-INF/template/headerMainBody.jspf");
    _jspx_dependants.add("/view/../WEB-INF/template/footerMain.jspf");
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
      out.write("      \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");
      out.write("<link href=\"faw/web-fonts-with-css/css/fontawesome-all.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"css/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<script src=\"./js/angular.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("            .navbar-login\n");
      out.write("            {\n");
      out.write("                width: 305px;\n");
      out.write("                padding: 10px;\n");
      out.write("                padding-bottom: 0px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navbar-login-session\n");
      out.write("            {\n");
      out.write("                padding: 10px;\n");
      out.write("                padding-bottom: 0px;\n");
      out.write("                padding-top: 0px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .icon-size\n");
      out.write("            {\n");
      out.write("                font-size: 87px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("    function deshabilitaRetroceso(){\n");
      out.write("        window.location.hash=\"no-back-button\";\n");
      out.write("        window.location.hash=\"Again-No-back-button\"; //chrome\n");
      out.write("        window.onhashchange=function(){window.location.hash=\"no-back-button\";}\n");
      out.write("     }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body ng-app=\"app\" ng-controller=\"appController\">\n");
      out.write("        ");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n");
      out.write("        <div class=\"container\"> \n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span> \n");
      out.write("                </button>\n");
      out.write("                <a target=\"_blank\" href=\"#\" class=\"navbar-brand\"><img src=\"img/ep.png\" alt=\"\" width=\"27\" height=\"27\"></a>\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.rol}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"rolcito\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <ul class=\"nav navbar-nav\" id=\"abc\"> \n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                            <i class=\"fas fa-user-cog fa-lg\" style=\"color: blue;\"></i> \n");
      out.write("                            <i class=\"fas fa-angle-double-right fa-lg\" style=\"color: blue;\"></i>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"navbar-login\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-lg-4\">\n");
      out.write("                                            <p class=\"text-center\" >\n");
      out.write("                                                <i class=\"fas fa-user-tie fa-7x\"></i>\n");
      out.write("                                            </p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-lg-8\">\n");
      out.write("                                            <p class=\"text-left\"><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.nombres}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong></p>\n");
      out.write("                                            <p class=\"text-left small\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.rol}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                            <p class=\"text-left\">\n");
      out.write("                                                <a href=\"#\" class=\"btn btn-primary btn-block btn-sm\" id=\"perfil\">Actualizar Datos</a>\n");
      out.write("                                            </p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"divider\"></li>\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"navbar-login navbar-login-session\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-lg-12\">\n");
      out.write("                                            <p>\n");
      out.write("                                                <a href=\"salir\" class=\"btn btn-danger btn-block\">Cerrar Sesion</a>\n");
      out.write("                                            </p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"container\" style=\"margin-top: 80px;\" id=\"contenido\">\n");
      out.write("\n");
      out.write("        <h3>REGISTRO DE ROLES</h3>\n");
      out.write("        <hr>\n");
      out.write("        <button class=\"btn btn-success\" id=\"crearRol\"><i class=\"fas fa-plus\"></i></button>\n");
      out.write("        <hr>\n");
      out.write("        <table class=\"table\" id=\"tablita\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">#</th>\n");
      out.write("                    <th scope=\"col\">ID</th>\n");
      out.write("                    <th scope=\"col\">ROL</th>\n");
      out.write("                    <th scope=\"col\">ACCION</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody ng-repeat=\"x in rol\">  \n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>{{$index +1 }}</td>\n");
      out.write("                    <td>{{x.idr}}</td>\n");
      out.write("                    <td>{{x.nomrol}}</td>\n");
      out.write("                    <td ng-click=\"editar(x.idr)\"><i class=\"far fa-edit\"></i></td>\n");
      out.write("                    <td ng-click=\"eliminar(x.idr)\"><i class=\"far fa-trash-alt\"></i></td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    <!-- Modal PARA REGISTRAR-->\n");
      out.write("    <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog modal-sm\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">REGISTRAR ROL</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">×</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Rol:</label>\n");
      out.write("                        <input type=\"text\" id=\"nomrol\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary\" id=\"saverol\">Save Rol</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--MODAL PARA EDITAR-->\n");
      out.write("    <div class=\"modal fade\" id=\"myModal2\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog modal-sm\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modal title</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">×</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Rol:</label>\n");
      out.write("                        <input type=\"text\" id=\"edit_nomrol\" class=\"form-control\">\n");
      out.write("                        <input type=\"hidden\" id=\"edit_idrol\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary\" id=\"editrol\">Modificar Rol</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");
      out.write("   \n");
      out.write("     <script src=\"js/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("     <script src=\"js/jquery.numeric.js\" type=\"text/javascript\"></script>\n");
      out.write("     <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("      \n");
      out.write("     <script src=\"js/bootbox.min.js\" type=\"text/javascript\"></script>\n");
      out.write("     <script src=\"js/prueba.js\" type=\"text/javascript\"></script>");
      out.write("\n");
      out.write("        <script src=\"./js/rol.js\"></script>\n");
      out.write("        \n");
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
