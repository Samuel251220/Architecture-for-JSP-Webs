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
import javax.swing.JOptionPane;
import pe.edu.upeu.ventas.dao.PersonaDao;
import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.dao.RolDao;
import pe.edu.upeu.ventas.daoimp.PersonalDaoImp;
import pe.edu.upeu.ventas.daoimp.ProductoDaoImp;
import pe.edu.upeu.ventas.daoimp.RolDaoImp;
import pe.edu.upeu.ventas.entity.Persona;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.entity.Rol;

/**
 *
 * @author alum.fial1
 */
public class HomeController extends HttpServlet {
    private final RolDao rd = new RolDaoImp();
    private final ProductoDao mip =  new ProductoDaoImp();
    private final PersonaDao pd = new PersonalDaoImp();
    private final Gson g = new Gson();
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
                        
          
        switch(op){
            case 1:out.println(g.toJson(rd.readAll()));
                    break;
            case 2: out.println(g.toJson(rd.read(Integer.parseInt(request.getParameter("id")))));
                    break;
            case 3: Rol rol = new Rol(request.getParameter("nombrerol")); 
                    rd.create(rol);
                    break;
            case 4: Rol ro = new Rol(Integer.parseInt(request.getParameter("id")), request.getParameter("nomrol"));
                    rd.update(ro);
                    break;
            case 5: rd.delete(Integer.parseInt(request.getParameter("id")));
                    break;
            //comienza las funciones para el producto
            case 6: out.println(g.toJson(mip.readAll()));
                    break;
            case 7: out.println(g.toJson(mip.read(Integer.parseInt(request.getParameter("idprod")))));
                    break;
            case 8: Producto mipr = new Producto(request.getParameter("nomprod"), Double.parseDouble(request.getParameter("precio")), Integer.parseInt(request.getParameter("stock")), Integer.parseInt(request.getParameter("cod")) );
                    mip.create(mipr);
                    break;
            case 9: Producto pr = new Producto(Integer.parseInt(request.getParameter("idprod")), request.getParameter("nomprod"), Double.parseDouble(request.getParameter("precio")), Integer.parseInt(request.getParameter("stock")), Integer.parseInt(request.getParameter("cod")));
                    mip.update(pr);
                    break;
            case 10: mip.delete(Integer.parseInt(request.getParameter("idprod")));
                     break;
            //comienza las funciones para persona
            case 11: out.println(g.toJson(pd.readAll()));
                    break;
            case 12: Persona pe = new Persona(Integer.parseInt(request.getParameter("idpersona")), request.getParameter("nombres"), request.getParameter("apellidos"), request.getParameter("dni"), request.getParameter("telefono"));
                    pd.update(pe);
                    break;
            case 13: pd.delete(Integer.parseInt(request.getParameter("idpersona")));
                    break;
            case 14: out.println(g.toJson(pd.read(Integer.parseInt(request.getParameter("idpersona")))));
                    break;
            case 15: Persona per = new Persona(request.getParameter("nombres"), request.getParameter("apellidos"), request.getParameter("dni"), request.getParameter("telefono")); 
                    pd.create(per);
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
