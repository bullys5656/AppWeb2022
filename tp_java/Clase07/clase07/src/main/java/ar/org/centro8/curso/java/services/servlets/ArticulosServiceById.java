
package ar.org.centro8.curso.java.services.servlets;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.repositories.jdbc.ArticuloRepository;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="byIdArt", urlPatterns = "/servicios/articulos/v1/byId")
public class ArticulosServiceById extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response
            .getWriter()
            .println(
                new Gson()
                    .toJson(
                        new ArticuloRepository(Connector.getConnection())
                            .getById(
                                Integer.parseInt(request.getParameter("id"))
                            )
            ));
    }
    
    
    
    
}
