/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ventas.daoimp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.ventas.dao.PersonaDao;
import pe.edu.upeu.ventas.entity.Persona;
import pe.edu.upeu.ventas.util.Conexion;

/**
 *
 * @author alum.fial1
 */
public class PersonalDaoImp implements PersonaDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Persona p) {
        int x =0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call createPersona(?,?,?,?)}");
            cst.setString(1, p.getNombres());
            cst.setString(2, p.getApellidos());
            cst.setString(3, p.getDni());
            cst.setString(4, p.getTelefono());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int update(Persona p) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call editarPersona(?,?,?,?,?)}");
            cst.setInt(1, p.getIdpersona());
            cst.setString(2, p.getNombres());
            cst.setString(3, p.getApellidos());
            cst.setString(4, p.getDni());
            cst.setString(5, p.getTelefono());
            x = cst.executeUpdate();
        } catch (SQLException e) {  
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int delete(int key) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call eliminarPersona(?)}");
            cst.setInt(1, key);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public Persona read(int key) {
        Persona p = new Persona();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call searchPersonaId(?)}");
            cst.setInt(1, key);
            rs = cst.executeQuery();
            while(rs.next()){
               p.setIdpersona(rs.getInt("idpersona"));
               p.setNombres(rs.getString("nombres"));
               p.setApellidos(rs.getString("apellidos"));
               p.setDni(rs.getString("dni"));
               p.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+ e);
        }
        return p;  
    }

    @Override
    public List<Persona> readAll(String dni) {
        List<Persona> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarPersona2(?)}");
            cst.setString(1, dni);
            rs = cst.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setIdpersona(rs.getInt("idpersona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setDni(rs.getString("dni"));
                p.setTelefono(rs.getString("telefono"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }

    @Override
    public List<Persona> readAll() {
        List<Persona> datos = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarPersona()}");
            rs = cst.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setIdpersona(rs.getInt("idpersona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setDni(rs.getString("dni"));
                p.setTelefono(rs.getString("telefono"));
                datos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return datos;
    }
    
}
