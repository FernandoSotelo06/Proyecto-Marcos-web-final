/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import ModeloDTO.Clientes;
import ModeloDAO.ClientesDAO;
import ModeloDTO.Empleado;
import ModeloDAO.EmpleadoDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.VentaDAO;
import ModeloDTO.Producto;
import ModeloDTO.Venta;
import config.GenerarSerie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Clientes cli = new Clientes();
    ClientesDAO clidao = new ClientesDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    Venta v = new Venta();
    VentaDAO vdao = new VentaDAO();

    int ide;
    int ideCli;
    int idp;

    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    String numeroserie = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        Empleado usuario = (Empleado) session.getAttribute("usuario");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (menu.equals("Empleado")) {
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Clientes")) {
            switch (accion) {
                case "ListarCli":
                    List lista = clidao.listarCli();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDniCli");
                    String nom = request.getParameter("txtNombresCli");
                    String dirc = request.getParameter("txtDireccionCli");
                    String est = request.getParameter("txtEstadoCli");
                    cli.setDniCliente(dni);
                    cli.setNomCliente(nom);
                    cli.setDirceccion(dirc);
                    cli.setEstado(est);
                    clidao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=ListarCli").forward(request, response);
                    break;
                case "Editar":
                    ideCli = Integer.parseInt(request.getParameter("idCliente"));
                    Clientes c = clidao.listarClientesId(ideCli);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=ListarCli").forward(request, response);
                    break;
                case "Actualizar":
                    String dni2 = request.getParameter("txtDniCli");
                    String nom2 = request.getParameter("txtNombresCli");
                    String dirc2 = request.getParameter("txtDireccionCli");
                    String est2 = request.getParameter("txtEstadoCli");
                    cli.setDniCliente(dni2);
                    cli.setNomCliente(nom2);
                    cli.setDirceccion(dirc2);
                    cli.setEstado(est2);
                    cli.setIdCliente(ideCli);
                    clidao.actualizarCli(cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=ListarCli").forward(request, response);
                    break;
                case "Delete":
                    ideCli = Integer.parseInt(request.getParameter("idCliente"));
                    clidao.deleteCli(ideCli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=ListarCli").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (menu.equals("Clientes")) {
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            switch (accion) {
                case "ListarPro":
                    List productos = pdao.listarProducto();
                    request.setAttribute("productos", productos);
                    break;
                case "Agregar":
                    String nomPro = request.getParameter("txtNombreProducto");
                    double pre = Double.parseDouble(request.getParameter("txtPrecioProducto"));
                    int st = Integer.parseInt(request.getParameter("txtStockProducto"));
                    String est = request.getParameter("txtEstadoProducto");
                    p.setNomProducto(nomPro);
                    p.setPreProducto(pre);
                    p.setStockProducto(st);
                    p.setEstadoProducto(est);
                    pdao.agregarProducto(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=ListarPro").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("idProducto"));
                    Producto pr = pdao.listarIdProducto(idp);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=ListarPro").forward(request, response);
                    break;
                case "Actualizar":
                    String nomPro1 = request.getParameter("txtNombreProducto");
                    double pre1 = Double.parseDouble(request.getParameter("txtPrecioProducto"));
                    int st1 = Integer.parseInt(request.getParameter("txtStockProducto"));
                    String est1 = request.getParameter("txtEstadoProducto");
                    p.setNomProducto(nomPro1);
                    p.setPreProducto(pre1);
                    p.setStockProducto(st1);
                    p.setEstadoProducto(est1);
                    p.setIdProducto(idp);
                    pdao.actualizarProducto(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=ListarPro").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("idProducto"));
                    pdao.deleteProducto(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=ListarPro").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

        }
        if (menu.equals("Producto")) {
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String DniCliente = request.getParameter("codigocliente");
                    cli.setDniCliente(DniCliente);
                    cli = clidao.buscar(DniCliente);
                    request.setAttribute("cli", cli);
                    session.setAttribute("usuario", usuario);
                    request.setAttribute("nserie", numeroserie);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
                case "BuscarProducto":
                    int idProducto = Integer.parseInt(request.getParameter("codigoproducto"));
                    p = pdao.listarIdProducto(idProducto);
                    request.setAttribute("cli", cli);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    session.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
                case "Agregar":
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("cli", cli);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getIdProducto();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    boolean exist = false;
                    int count = 0;
                    int position = 0;
                    for (Venta venta : lista) {
                        if (venta.getIdproducto().equals(cod)) {
                            exist = true;
                            position = count;
                        }
                        count++;
                    }
                    if (exist) {
                        lista.get(position).setCantidad(lista.get(position).getCantidad() + 1);
                    } else {
                        lista.add(v);
                    }
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    session.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
                case "delete":
                    int idpd = Integer.parseInt(request.getParameter("id"));
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getIdproducto().equals(idpd)) {
                            lista.remove(i);
                        }
                    }
                    totalPagar = 0.0;
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("cli", cli);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    session.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
                case "updateCant":
                    try {
                    int idpc = Integer.parseInt(request.getParameter("id"));
                    int canti = Integer.parseInt(request.getParameter("cantidad"));
                    if (idpc != 0 && canti != 0) {
                        for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i).getIdproducto().equals(idpc)) {
                                lista.get(i).setCantidad(canti);
                            }
                        }
                    }
                    totalPagar = 0.0;
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error:" + e);
                }
                request.setAttribute("nserie", numeroserie);
                request.setAttribute("cli", cli);
                request.setAttribute("totalpagar", totalPagar);
                request.setAttribute("lista", lista);
                session.setAttribute("usuario", usuario);
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                break;
                case "GenerarVenta":
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();
                        ProductoDAO aO = new ProductoDAO();
                        pr = aO.buscar(idproducto);
                        int sac = pr.getStockProducto() - cantidad;
                        aO.actualizarStock(idproducto, sac);
                    }
                    v.setIdcliente(cli.getIdCliente());
                    v.setIdempleado(2);
                    v.setNumserie(numeroserie);
                    v.setFecha("2024-08-12");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);

                    int idv = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }

                    break;

                default:
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
                    numeroserie = vdao.GenerarSerie();
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    session.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    request.setAttribute("errorMensaje", "Acción no válida: " + accion);
                    break;
            }

            // Redirige a la página de "RegistrarVenta.jsp" independientemente del resultado
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
