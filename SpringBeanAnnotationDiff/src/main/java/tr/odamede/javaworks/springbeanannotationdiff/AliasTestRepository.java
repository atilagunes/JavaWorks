package tr.odamede.javaworks.springbeanannotationdiff;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


/*
Repository annotation is put the classes interact with data sources.
 */
@Repository
public class AliasTestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AliasTestRepository() {
        System.out.println("AnnotationTestRepository is initialized");


    }
}
