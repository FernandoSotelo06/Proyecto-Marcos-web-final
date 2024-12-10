<%-- 
    Document   : RegistrarVenta
    Created on : 27 oct. 2024, 00:26:18
    Author     : Fernando
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-5 d-flex"> 
                                    <input type="text" name="codigocliente" value="${cli.getDniCliente()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn-info" style="border-radius: 5px; margin: 5px;  text-decoration: none">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${cli.getNomCliente()}" placeholder="Datos Cliente" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex"> 
                                    <input type="text" name="codigoproducto" value="${producto.getIdProducto()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn-info" style="border-radius: 5px; margin: 5px;  text-decoration: none">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${producto.getNomProducto()}" placeholder="Producto" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPreProducto()}" class="form-control" placeholder="S/.0.00">                                
                                </div>                           
                                <div class="col-sm-3">
                                    <input type="number" name="cant" value="1" placeholder="" class="form-control">
                                </div>  
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStockProducto()}" placeholder="Stock" class="form-control">
                                </div> 
                            </div>
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn-info" style="border-radius: 5px; margin: 5px;  text-decoration: none">Agregar Producto</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-4 ml-auto">
                            <label>N°Serie:</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control" readonly>
                        </div>
                        <br>
                        <table class="table table-hover" style="background-image: url(img/fondo-marcos-web.jpg); background-repeat: no-repeat;  background-attachment: fixed; background-size: 100% auto; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);">
                            <thead class="thead-light">
                                <tr>
                                    <th>N°</th>
                                    <th>CODIGO</th>
                                    <th>DESCRIPCION</th>
                                    <th>PRECIO</th>
                                    <th>CANTIDAD</th>
                                    <th>SUBTOTAL</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                    </tr>
                                </c:forEach> 
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex"> 
                        <div class="col-sm-3"> 
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" class="btn-info" style="border-radius: 5px; margin: 10px;  text-decoration: none" onclick="print()">Generar Venta</a>
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value="s/. ${totalpagar}0" class="form-control" readonly>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
