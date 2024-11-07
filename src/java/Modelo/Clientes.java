/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Fernando
 */
public class Clientes {
    int idCliente;
    String dniCliente;
    String nomCliente;
    String dirceccion;
    String estado;

    public Clientes() {
    }

    public Clientes(int idCliente, String dniCliente, String nomCliente, String dirceccion, String estado) {
        this.idCliente = idCliente;
        this.dniCliente = dniCliente;
        this.nomCliente = nomCliente;
        this.dirceccion = dirceccion;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getDirceccion() {
        return dirceccion;
    }

    public void setDirceccion(String dirceccion) {
        this.dirceccion = dirceccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
