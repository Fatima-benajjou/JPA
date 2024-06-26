package org.example.JPAZoo;


import org.example.JPAZoo.Animaux;
//import org.example.Util.DataBaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;


public class AnimauxDAO {


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
    EntityManager em = emf.createEntityManager(); //permet de venir créer une nouvelle entité manager


    public void ajoutAnimaux(Animaux animaux) {

        try {

            em.getTransaction().begin(); //pour demarrer la transaction reviens à faire un try catch avec un rollback dans le catch
            em.persist(animaux); //cela va venir inserer le nouvelle objet saisie dans la BDD
            em.getTransaction().commit(); //la transaction est bien effectué et on valide la modif
            em.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}