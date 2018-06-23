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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import oracle.jdbc.OracleTypes;
import pe.edu.upeu.ventas.dao.UsuarioDao;
import pe.edu.upeu.ventas.entity.Persona;
import pe.edu.upeu.ventas.entity.Usuario;
import pe.edu.upeu.ventas.util.Conexion;

/**
 *
 * @author alum.fial1
 */
public class UsuarioDaoImp implements UsuarioDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public HashMap<String, Object> validar(String x, String y) {
        HashMap<String, Object> map = new HashMap<>();
        
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call validarUser(?,?)}");
            cst.setString(1, x);
            cst.setString(2, y);
            rs = cst.executeQuery();
            while(rs.next()){                
                map.put("idu", rs.getInt("idusuario"));
                map.put("user", rs.getString("nom_user"));
                map.put("nom", rs.getString("nombres"));
                map.put("apell", rs.getString("apellidos"));
                map.put("rol", rs.getString("nom_rol"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return map;
        /*
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call VALIDARUSUARIO.SP_VALIDARUSUARIO(?,?,?)}");
            cst.setString(1, x);
            cst.setString(2, y);
            cst.registerOutParameter(3,OracleTypes.CURSOR);
            cst.executeQuery();
            rs=(ResultSet)cst.getObject(3);
            while(rs.next()){                
                map.put("idu", rs.getInt(1));
                map.put("user", rs.getString(2));
                map.put("nom", rs.getString(3));
                map.put("apell", rs.getString(4));
                map.put("rol", rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return map;
        */
    }

    @Override
    public int create(Usuario u) {
        int x=0;
    try {
         cx = Conexion.getConexion();
            cst = cx.prepareCall("{call createUsuario(?,?,?,?,?)}");
            cst.setString(1,u.getNom_user());
            cst.setString(2,u.getClave());
            cst.setString(3,u.getEstado());
            cst.setInt(4,u.getIdrol());
            cst.setInt(5,u.getIdpersona());
            x = cst.executeUpdate();
    }catch(Exception e){
        System.out.println("Error:"+e);
    } 
    return x;
    }

    @Override
    public int update(Usuario u) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call editarUsuario(?,?,?,?,?,?)}");
            cst.setInt(1,u.getIdusuario());
            cst.setString(2,u.getNom_user());
            cst.setString(3,u.getClave());
            cst.setString(4,u.getEstado());
            cst.setInt(5,u.getIdrol());
            cst.setInt(6,u.getIdpersona());
            
            x = cst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x; 
    }

    @Override
    public int delete(int key) {
        boolean p = false;
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call eliminarUsuario(?)}");
            cst.setInt(1, key);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public Usuario read(int key) {
         Usuario u=new Usuario();
        try {
            
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call searchUsuarioId(?)}");
            cst.setInt(1, key);
            rs = cst.executeQuery();
            while(rs.next()){
                u.setIdusuario(rs.getInt("idusuario"));
                u.setNom_user( rs.getString("nom_user"));
                u.setClave(rs.getString("clave"));
                u.setEstado(rs.getString("estado"));
                u.setIdrol(rs.getInt("idrol"));
                u.setIdpersona(rs.getInt("idpersona"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+ e);
        }
        return u; 
    }

    @Override
    public boolean search(String user) { //por ahora sin uso
         Usuario u=new Usuario();
         boolean com=false;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call searchUsuarioUser(?)}");
            cst.setString(1, user);
            rs = cst.executeQuery();
            while(rs.next()){
                u.setIdusuario(rs.getInt("idusuario"));
                u.setNom_user( rs.getString("nom_user"));
                u.setClave(rs.getString("clave"));
                u.setEstado(rs.getString("estado"));
                u.setIdrol(rs.getInt("idrol"));
                u.setIdpersona(rs.getInt("idpersona"));
                com=true;
            }
        } catch (SQLException e) {
            System.out.println("Error:"+ e);
        }
        return com; 
    }
    
    @Override
    public List<Map<String, Object>> readAll() {
        List<Map<String,Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarUsuario()}");
            rs = cst.executeQuery();
            while(rs.next()){
                Map<String, Object> map=new HashMap<>();
                map.put("idu", rs.getInt("idusuario"));
                map.put("user", rs.getString("nom_user"));
                map.put("nom",rs.getString("nombres"));
                map.put("apell",rs.getString("apellidos"));
                map.put("rol", rs.getString("nom_rol"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }

    @Override
    public List<Map<String, Object>> searchreadAll(String Usuaria) {
         List<Map<String,Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call searchUsuario(?)}");
            cst.setString(1, Usuaria);
            rs = cst.executeQuery();
            while(rs.next()){   
                Map<String, Object> map=new HashMap<>();
                map.put("idu", rs.getInt("idusuario"));
                map.put("user", rs.getString("nom_user"));
                map.put("est", rs.getString("estado"));
                map.put("nom",rs.getString("nombres"));
                map.put("apell",rs.getString("apellidos"));
                map.put("rol", rs.getString("nom_rol"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }
    
}
