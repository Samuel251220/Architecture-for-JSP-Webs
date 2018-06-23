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
import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.util.Conexion;

/**
 *
 * @author alum.fial1
 */
public class ProductoDaoImp implements ProductoDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public Producto buscarProductoCodigo(int cod) {
        Producto p = new Producto();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call buscarPorductoCodigo(?)}");
            cst.setInt(1, cod);
            rs = cst.executeQuery();
            while(rs.next()){
                p.setIdprod(rs.getInt("idproducto"));
                p.setNomprod(rs.getString("nom_prod"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCod(rs.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return p;
    }

    @Override
    public int create(Producto p) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call createProducto(?,?,?,?)}");
            cst.setString(1, p.getNomprod());
            cst.setDouble(2, p.getPrecio());
            cst.setInt(3, p.getStock());
            cst.setInt(4, p.getCod());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int update(Producto p) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call editarProducto(?,?,?,?,?)}");
            cst.setInt(1, p.getIdprod());
            cst.setString(2, p.getNomprod());
            cst.setDouble(3, p.getPrecio());
            cst.setInt(4, p.getStock());
            cst.setInt(5,p.getCod());
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
            cst = cx.prepareCall("{call eliminarProducto(?)}");
            cst.setInt(1, key);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public Producto read(int key) {
        Producto p = new Producto();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call searchProductoId(?)}");
            cst.setInt(1, key);
            rs = cst.executeQuery();
            while(rs.next()){
               p.setIdprod(rs.getInt("idproducto"));
               p.setNomprod(rs.getString("nom_prod"));
               p.setPrecio(rs.getDouble("precio"));
               p.setStock(rs.getInt("stock"));
               p.setCod(rs.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+ e);
        }
        return p;
    }

    @Override
    public List<Producto> readAll() {
        List<Producto> datos = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarProducto()}");
            rs = cst.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setIdprod(rs.getInt("idproducto"));
                p.setNomprod(rs.getString("nom_prod"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCod(rs.getInt("codigo"));
                datos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return datos;
    }

    @Override
    public boolean search(String nom_prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
