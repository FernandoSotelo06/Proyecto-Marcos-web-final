<%-- 
    Document   : Producto
    Created on : 27 oct. 2024, 00:26:18
    Author     : Fernando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="card col-sm-11">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Producto</label>
                            <input type="text" value="${producto.getNomProducto()}" name="txtNombreProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPreProducto()}" name="txtPrecioProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${producto.getStockProducto()}" name="txtStockProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${producto.getEstadoProducto()}" name="txtEstadoProducto" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
                <div class="col-sm-15">
                    <table class="table table-hover" style="background-image: url(img/fondo-marcos-web.jpg); background-repeat: no-repeat;  background-attachment: fixed; background-size: 100% auto; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombres</th>
                                <th>Precio</th>
                                <th>Stock</th>                                    
                                <th>ESTADO</th>                                    
                                <th>ACCION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${productos}">
                                <tr>
                                    <td>${p.getIdProducto()}</td>
                                    <td>${p.getNomProducto()}</td>
                                    <td>${p.getPreProducto()}</td>
                                    <td>${p.getStockProducto()}</td>
                                    <td>${p.getEstadoProducto()}</td>
                                    
                                    <td>
                                        <a class="btn-info" style="border-radius: 5px; margin: 10px;  text-decoration: none" href="Controlador?menu=Producto&accion=Editar&idProducto=${p.getIdProducto()}">Editar</a>
                                        <a class="btn-secondary" style="border-radius: 5px; margin: 10px; text-decoration: none" href="Controlador?menu=Producto&accion=Delete&idProducto=${p.getIdProducto()}">Delete</a>
                                    </td>
                                </tr>                       
                            </c:forEach>

                        </tbody>
                    </table>

                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
