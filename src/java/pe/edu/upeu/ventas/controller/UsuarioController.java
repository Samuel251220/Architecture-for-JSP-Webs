/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ventas.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.ventas.dao.PersonaDao;
import pe.edu.upeu.ventas.dao.RolDao;
import pe.edu.upeu.ventas.dao.UsuarioDao;
import pe.edu.upeu.ventas.daoimp.PersonalDaoImp;
import pe.edu.upeu.ventas.daoimp.RolDaoImp;
import pe.edu.upeu.ventas.daoimp.UsuarioDaoImp;
import pe.edu.upeu.ventas.entity.Persona;
import pe.edu.upeu.ventas.entity.Rol;
import pe.edu.upeu.ventas.entity.Usuario;

/**
 *
 * @author asus
 */
public class UsuarioController extends HttpServlet {
    private Gson g = new Gson();
     private UsuarioDao u = new UsuarioDaoImp();                            
     private PersonaDao p = new PersonalDaoImp();
     private RolDao rd = new RolDaoImp();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         int op = Integer.parseInt(request.getParameter("opc"));
         System.out.println("envio controller"+op);
        switch(op){
            case 1://leer todo 
                out.println(g.toJson(u.readAll()));
                System.out.println(g.toJson(u.readAll()));
                    break;
            case 2://leer uno 
                    out.println(g.toJson(u.read(Integer.parseInt(request.getParameter("id")))));
                    break;
            case 3://crear usuario 
                    Rol role = rd.read(Integer.parseInt(request.getParameter("crol")));
                    Persona per =p.read(Integer.parseInt(request.getParameter("cper")));
                    Usuario ou= new Usuario(request.getParameter("cusuario"),request.getParameter("ccontrasena"),"1",role.getIdr(),per.getIdpersona());
                    u.create(ou);
                    break;
            case 4://modificar usuario 
                    Rol roles = rd.read(Integer.parseInt(request.getParameter("erol")));
                    Persona pers=new Persona(Integer.parseInt(request.getParameter("eidper")),request.getParameter("enom"),request.getParameter("eappe"),request.getParameter("edni"),request.getParameter("etel"));
                    p.update(pers);
                    Usuario ous= new Usuario(1,request.getParameter("eusu"),request.getParameter("econtra"),"1",roles.getIdr(),pers.getIdpersona());
                    u.update(ous);
                    break;
            case 5://borrar usuario
                    u.delete(Integer.parseInt(request.getParameter("idusu")));
                    break;
            case 6:
                    out.println(g.toJson(u.search(request.getParameter("cusuario"))));
                    break;
            case 7:
                    out.println(g.toJson(u.searchreadAll(request.getParameter("usuario"))));
                    break;
            case 8: //readAll rol
                    out.println(g.toJson(rd.readAll()));
                    break;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
