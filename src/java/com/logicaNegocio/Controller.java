/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicaNegocio;

import com.dao.ProductoDAO;
import com.model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author luis_
 */
public class Controller extends HttpServlet {

    ProductoDAO prodDao = new ProductoDAO();
    Producto prod = new Producto();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion)
        {
            case "Listar":
                List<Producto> lista = prodDao.getProduct();
                request.setAttribute("data", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("newProduct.jsp").forward(request, response);
                break;
            case "Guardar":
                System.out.println("Entro a guardar");
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String parNombre = request.getParameter("nombre");
                double parPrecio = Double.parseDouble(request.getParameter("precio"));
                String parCategoria = request.getParameter("categoria");
                String parFechaEx = request.getParameter("fechaExp");

                System.out.println("FECHA STRING => " + parFechaEx);
                Date fecha = null;
                try
                {
                    fecha = formato.parse(parFechaEx);
                } catch (ParseException e)
                {
                    System.out.println("Error en la convercion de Fecha => "+ e);
                }
                System.out.println("FECHA => " + formato.format(fecha));
                
                prod.setNombre(parNombre);
                prod.setPrecio(parPrecio);
                prod.setCategoria(parCategoria);
                prod.setFechaExp(fecha);
                prodDao.insertProd(prod);

                request.getRequestDispatcher("controller?accion=Listar").forward(request, response);

                break;
            case "Edit":
                String idEdit = request.getParameter("id");
                int id = Integer.parseInt(idEdit);
                System.out.println("ID " +id);
                prod = prodDao.edit(id);
                request.setAttribute("data", prod);
                request.getRequestDispatcher("editProd.jsp").forward(request, response);
                break;
            case "Update":
                formato = new SimpleDateFormat("yyyy-MM-dd");
                String UId = request.getParameter("id");
                int idU = Integer.parseInt(UId);
                String UNombre = request.getParameter("nombre");
                double UPrecio = Double.parseDouble(request.getParameter("precio"));
                String UCategoria = request.getParameter("categoria");
                String UFechaEx = request.getParameter("fechaExp");

                Date fechaU = null;
                try
                {
                    fechaU = formato.parse(UFechaEx);
                } catch (ParseException e)
                {
                    System.out.println("Error en la convercion de Fecha => "+ e);
                }      
                prod.setId(idU);
                prod.setNombre(UNombre);
                prod.setPrecio(UPrecio);
                prod.setCategoria(UCategoria);
                prod.setFechaExp(fechaU);
                
                prodDao.update(prod);
                
                request.getRequestDispatcher("controller?accion=Listar").forward(request, response);
                
                break;
            case "Delete":
                String idD = request.getParameter("id");
                int DId = Integer.parseInt(idD);
                prodDao.delete(DId);
                
                request.getRequestDispatcher("controller?accion=Listar").forward(request, response);
                break;
            case "Search":
                String name = request.getParameter("search");
                List<Producto> listUpd = prodDao.Search(name);
                request.setAttribute("data", listUpd);
                request.getRequestDispatcher("searchIndex.jsp").forward(request, response);
                break;
            default:
                System.out.println("F papu");
                break;

        }
    }

}




/*

case "Guardar":
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                System.out.println("Entrando a guardat test");
                String parNombre = request.getParameter("nombre");
                double parPrecio = Double.parseDouble(request.getParameter("precio"));
                String parCategoria = request.getParameter("categoria");
                Date parFechaEx = null;
                try
                {
                    parFechaEx = format.parse(request.getParameter("fechaExp"));
                } catch (Exception e)
                {
                    System.out.println("Error en la convercion => " + e);
                }
                
                //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                
                

                System.out.println("FECHA => " + parFechaEx);
                
                prod.setNombre(parNombre);
                prod.setPrecio(parPrecio);
                prod.setCategoria(parCategoria);
                prod.setFechaExp(parFechaEx);

                

                prodDao.insertProd(prod);

                request.getRequestDispatcher("controller?accion=Listar");

                break;
*/
