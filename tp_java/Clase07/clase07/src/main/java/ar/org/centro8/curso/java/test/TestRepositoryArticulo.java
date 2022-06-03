package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.enums.Rubro;
import ar.org.centro8.curso.java.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.repositories.jdbc.ArticuloRepository;

public class TestRepositoryArticulo {

    public static void main(String[] args) {

        I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());

        ar.save(new Articulo(
                "VINO PATERO BIDON 5L",
                Rubro.BEBIDAS,
                152,
                250,
                15,
                1,
                20));
        ar.save(new Articulo(
                "FERNET BRANCA",
                Rubro.BEBIDAS,
                152,
                250,
                15,
                1,
                20));

        ar.delete(ar.getById(1));
          ar.getAll().forEach(System.out::println);
        System.out.println("************************************************");
        System.out.println(ar.getById(2));
        System.out.println("************************************************");
        System.out.println(ar.getByRubro(Rubro.BEBIDAS));
        System.out.println("************************************************");
        ar.getLikeDescripcion("so").forEach(System.out::println);
        
    }
    

}
