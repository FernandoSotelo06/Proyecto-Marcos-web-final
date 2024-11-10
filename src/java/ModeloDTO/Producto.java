/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDTO;

/**
 *
 * @author Fernando
 */
public class Producto {
    int idProducto;
    String nomProducto;
    double preProducto;
    int stockProducto;
    String estadoProducto;

    public Producto() {
    }

    public Producto(int idProducto, String nomProducto, double preProducto, int stockProducto, String estadoProducto) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.preProducto = preProducto;
        this.stockProducto = stockProducto;
        this.estadoProducto = estadoProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public double getPreProducto() {
        return preProducto;
    }

    public void setPreProducto(double preProducto) {
        this.preProducto = preProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
    
    
    
    
}
