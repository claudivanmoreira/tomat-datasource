/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tomcat.datasource.persistencia;

import br.edu.ifpb.tomcat.datasource.entidades.JPAEntity;
import javax.persistence.EntityManager;

/**
 *
 * @author Desenvolvedor01
 */
public class HibernatePersistence {

    private JPAEntity entity;
    private Class persistenteClass;
    private EntityManager entityManager;

    public HibernatePersistence(EntityManager entityManager, JPAEntity entity) {
        this.entity = entity;
        this.entityManager = entityManager;
    }

    public HibernatePersistence(Class persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    public void persist() {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();;
    }

    public void update() {
    }

    public void remove() {
    }

    public void getById() {
    }

//    public Object getWithNamedQuery(Map<String, Object> parameters, String namedQuery) {
//        return null;
//    }
//
//    public List getWithNamedQuery(Map<String, Object> parameters, String namedQuery) {
//        return null;
//    }
//    
//    public Object getWithNativeQuery(String namedQuery) {
//        return null;
//    }
//
//    public List getWithNativeQuery(String namedQuery) {
//        return null;
//    }
//    
//    public Object getWithJpqlQuery(Map<String, Object> parameters, String namedQuery) {
//        return null;
//    }
//
//    public List getWithJpqlQuery(Map<String, Object> parameters, String namedQuery) {
//        return null;
//    }
}
