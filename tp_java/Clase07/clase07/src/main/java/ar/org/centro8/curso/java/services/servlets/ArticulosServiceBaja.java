
package ar.org.centro8.curso.java.services.servlets;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.repositories.jdbc.ArticuloRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="bajaArt", urlPatterns = "/servicios/articulos/v1/baja")
public class ArticulosServiceBaja extends HttpServlet{
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("false");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        try {
            I_ArticuloRepository ar= new ArticuloRepository(Connector.getConnection());
            ar.delete(ar.getById(Integer.parseInt(request.getParameter("id"))));
            out.println("true");
        } catch (Exception e) {
            out.println("false");
        }
    }
    
    
    
    
}
