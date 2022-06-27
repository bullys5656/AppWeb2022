
package ar.org.centro8.curso.java.services.servlets;

import ar.org.centro8.curso.java.enums.Rubro;
import ar.org.centro8.curso.java.repositories.list.ArticuloRepositoryFactory;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="likeRubro", urlPatterns = "/servicios/rubro/v1/likeRubro")
public class ArticulosServiceByRubro extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response
            .getWriter()
            .println(
                new Gson()
                    .toJson(
                        ArticuloRepositoryFactory
                            .getArticuloRepository()
                            .getByRubro(Rubro.valueOf(request.getParameter("rubro"))
                                
                            )
            ));
    }
    
}
