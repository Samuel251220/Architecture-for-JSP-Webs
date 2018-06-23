/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ventas.dao;

import java.util.List;
import pe.edu.upeu.ventas.entity.Producto;

/**
 *
 * @author alum.fial1
 */
public interface ProductoDao {
    Producto buscarProductoCodigo(int cod);
    int create(Producto p);
    int update(Producto p);
    int delete(int key);
    Producto read(int key);
    List<Producto> readAll();
    boolean search(String nom_prod);
}
