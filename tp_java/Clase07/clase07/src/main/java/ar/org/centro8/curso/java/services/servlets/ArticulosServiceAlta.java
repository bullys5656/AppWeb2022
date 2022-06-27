package ar.org.centro8.curso.java.services.servlets;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.enums.Rubro;
import ar.org.centro8.curso.java.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.repositories.jdbc.ArticuloRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "altaArt", urlPatterns = "/servicios/articulos/v1/alta")
public class ArticulosServiceAlta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("0");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Permisos cors
        response.addHeader("Access-Control-Allow-Origin", "*"); //se puede conectar todo el mundo!
        //response.addHeader("Access-Control-Allow-Origin", "192.168.0.1");
        response.addHeader("Access-Control-Max-Age", "1728000");
        PrintWriter out = response.getWriter();
        try {
            String descripcion = request.getParameter("descripcion");
            Rubro rubro = Rubro.valueOf(request.getParameter("rubro"));
            double costo = Double.parseDouble(request.getParameter("costo"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            int stock_minimo = Integer.parseInt(request.getParameter("stock_minimo"));
            int stock_maximo = Integer.parseInt(request.getParameter("stock_maximo"));

            I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());

            Articulo articulo = new Articulo(
                    descripcion,
                    rubro,
                    costo,
                    precio,
                    stock,
                    stock_minimo,
                    stock_maximo);
            ar.save(articulo);
            out.println(articulo.getId());
        } catch (Exception e) {
            out.println("0");
            System.out.println("**************************************");
            System.out.println(e);
            System.out.println("**************************************");
        }
    }

}
