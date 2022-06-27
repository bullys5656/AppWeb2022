
package ar.org.centro8.curso.java.services.servlets;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.repositories.jdbc.ClienteRepository;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="allArt", urlPatterns = "/servicios/articulos/v1/all")
public class ArticulosServiceAll extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        //I_ClienteRepository cr= ClienteRepositoryFactory.getClienteRepository();
        //PrintWriter out=response.getWriter();
        //Gson gson=new Gson();
        //String textoGson=gson.toJson(cr.getAll());
        //out.println(textoGson);

        response
            .getWriter()
            .println(
                new Gson()
                    .toJson(
                        new ClienteRepository(Connector.getConnection())
                            .getAll()
            ));

    }
    
    
    
    
}
