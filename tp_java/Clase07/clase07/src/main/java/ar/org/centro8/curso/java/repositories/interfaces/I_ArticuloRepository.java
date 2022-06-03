
package ar.org.centro8.curso.java.repositories.interfaces;

import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.enums.Rubro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ArticuloRepository {
    void save(Articulo articulo);
    void delete(Articulo articulo);
    
    List<Articulo>getAll();
    default Articulo getById(int id){
        return getAll()
                .stream()
                .filter(a->a.getId()==id)
                .findFirst()
                .orElse(new Articulo());
    }
    
   default List<Articulo>getLikeDescripcion(String producto){
        if(producto==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(a-> a.getDescripcion()!=null 
                            && a.getDescripcion()
                                .toLowerCase()
                                .contains(producto.toLowerCase()))
                .collect(Collectors.toList());
    }
   
    
     default List<Articulo> getByRubro(Rubro rubro){
        if (rubro == null) return new ArrayList<>();
        return getAll().stream().filter(a->a.getRubro() == rubro).collect(Collectors.toList());
    }
    
    
}
