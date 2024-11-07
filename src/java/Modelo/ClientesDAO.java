/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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
public class ClientesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
   //Operaciones CRUD
   
    public List listarCli() {
        String sql = "select * from cliente";
        List<Clientes> listaCli = new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setIdCliente(rs.getInt(1));
                cli.setDniCliente(rs.getString(2));
                cli.setNomCliente(rs.getString(3));
                cli.setDirceccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
                listaCli.add(cli);
            }
        } catch (SQLException e) {
        }
        return listaCli;  
}
    
    public int agregar(Clientes cli){
     String sql="insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cli.getDniCliente());
            ps.setString(2, cli.getNomCliente());
            ps.setString(3, cli.getDirceccion());
            ps.setString(4, cli.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    
    public Clientes listarClientes(int id){
    Clientes cli = new Clientes();
    String sql="select * from cliente where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                cli.setDniCliente(rs.getString(2));
                cli.setNomCliente(rs.getString(3));
                cli.setDirceccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
        }
        return cli;
    }
}