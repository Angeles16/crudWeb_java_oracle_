package com.dao;

import com.model.Producto;
import db.dbConnection;
import jakarta.security.auth.message.callback.PrivateKeyCallback;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class ProductoDAO {
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    
    public List<Producto> getProduct(){
        dbConnection conn = new dbConnection();
        String sql = "SELECT * FROM product";
        List<Producto> listar = new LinkedList<>();
        try
        {
            PreparedStatement psList = conn.getConnectio().prepareStatement(sql);
            ResultSet rs = psList.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setCategoria(rs.getString(4));
                p.setFechaExp(rs.getDate(5));
                listar.add(p);
            }
            conn.closeConnection();
            return listar;
        } catch (Exception e)
        {
            System.out.println("Erro en la obtencion de datos => " + e);
            conn.closeConnection();
            return null;
        }
    }
    
    public boolean insertProd(Producto prod){
        System.out.println("DATA => " + prod.toString());
        dbConnection conn = new dbConnection();
        String sql = "INSERT INTO product(nombre, precio, categoria, fecha_exp) VALUES(?,?,?,?)";
        try
        {
            PreparedStatement psInsert = conn.getConnectio().prepareStatement(sql);
            psInsert.setString(1, prod.getNombre());
            psInsert.setDouble(2, prod.getPrecio());
            psInsert.setString(3, prod.getCategoria());
            psInsert.setString(4, format.format(prod.getFechaExp()));
            psInsert.executeUpdate();
            conn.closeConnection();
            return true;
        } catch (Exception e)
        {
            System.out.println("Error en la insercion => " + e);
            conn.closeConnection();
            return false;
        }
    }
    
    public Producto edit(int idEdit){
        dbConnection conn = new dbConnection();
        String sql = "SELECT * FROM product WHERE id ="+idEdit;
        Producto prod = new Producto();
        try
        {
            PreparedStatement psEdit = conn.getConnectio().prepareStatement(sql);
            ResultSet rs = psEdit.executeQuery();
            while(rs.next()){
                prod.setId(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setCategoria(rs.getString(4));
                prod.setFechaExp(rs.getDate(5));
                System.out.println("DATOS CONSULTA = " + prod.toString());       
            }
        } catch (Exception e)
        {
            System.out.println("Error en la consulta de datos => "+ e);
            conn.closeConnection();
            return null;
        }     
        conn.closeConnection();
        return prod;
    } 
    
    public boolean update(Producto prod){
        dbConnection conn = new dbConnection();
        String sql = "UPDATE product SET nombre = ?, precio = ?, categoria = ?, fecha_exp = ? WHERE id = ?";
        try
        {
            PreparedStatement psUpdate = conn.getConnectio().prepareStatement(sql);
            psUpdate.setString(1, prod.getNombre());
            psUpdate.setDouble(2, prod.getPrecio());
            psUpdate.setString(3, prod.getCategoria());
            psUpdate.setString(4, format.format(prod.getFechaExp()));
            psUpdate.setInt(5, prod.getId());
            psUpdate.executeUpdate();
            conn.closeConnection();
            return true;
        } catch (SQLException e)
        {
            System.out.println("Erro al actualizar datos => " + e);
            conn.closeConnection();
            return false;
        }
    }
    
    public void delete(int id){
        System.out.println("Ingreso al delete");
        dbConnection conn = new dbConnection();
        String sql = "DELETE FROM product WHERE id ="+id;
        try
        {
            PreparedStatement psDelete = conn.getConnectio().prepareStatement(sql); 
            psDelete.executeUpdate();
        } catch (Exception e)
        {
            System.out.println("Error al eliminar datos ");
            conn.closeConnection();
        }
    }
    
    public List<Producto> Search(String nombre){
        dbConnection conn = new dbConnection();
        String sql = "SELECT * FROM product WHERE nombre = ?";
        List<Producto> listSearch = new LinkedList<>();
        System.out.println("Nombre +===+> " +nombre);
        try
        {
            PreparedStatement psSearch = conn.getConnectio().prepareStatement(sql);
            psSearch.setString(1, nombre);
        //psUpdate.setString(1, prod.getNombre());   
            ResultSet rs = psSearch.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setCategoria(rs.getString(4));
                p.setFechaExp(rs.getDate(5));
                listSearch.add(p);
            }
            conn.closeConnection();
            return listSearch;
        } catch (Exception e)
        {
            System.out.println("Error en la consulta => " + e);
            conn.closeConnection();
            return null;
        }
    }
}


