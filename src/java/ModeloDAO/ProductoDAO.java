/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloDTO.Producto;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto buscar(int idProducto) {
        Producto p = new Producto();
        String sql = "select * from producto where IdProducto=" + idProducto;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdProducto(rs.getInt(1));
                p.setNomProducto(rs.getString(2));
                p.setPreProducto(rs.getDouble(3));
                p.setStockProducto(rs.getInt(4));
                p.setEstadoProducto(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return p;
    }

    public int actualizarStock(int id, int stock) {
        String sql = "update producto set Stock=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return r;
    }

    //Operaciones Crud
    public List listarProducto() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdProducto(rs.getInt(1));
                pro.setNomProducto(rs.getString(2));
                pro.setPreProducto(rs.getDouble(3));
                pro.setStockProducto(rs.getInt(4));
                pro.setEstadoProducto(rs.getString(5));
                lista.add(pro);
            }
            ps.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return lista;
    }

    public int agregarProducto(Producto pro) {
        String sql = "insert into producto(Nombres,Precio,Stock,Estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNomProducto());
            ps.setDouble(2, pro.getPreProducto());
            ps.setInt(3, pro.getStockProducto());
            ps.setString(4, pro.getEstadoProducto());
            ps.executeUpdate();
            ps.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return r;

    }

    public Producto listarIdProducto(int id) {
        Producto pro = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setIdProducto(rs.getInt(1));
                pro.setNomProducto(rs.getString(2));
                pro.setPreProducto(rs.getDouble(3));
                pro.setStockProducto(rs.getInt(4));
                pro.setEstadoProducto(rs.getString(5));
            }
            ps.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return pro;
    }

    public int actualizarProducto(Producto pro) {
        String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNomProducto());
            ps.setDouble(2, pro.getPreProducto());
            ps.setInt(3, pro.getStockProducto());
            ps.setString(4, pro.getEstadoProducto());
            ps.setInt(5, pro.getIdProducto());
            ps.executeUpdate();
            ps.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return r;
    }

    public void deleteProducto(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
    }
}
