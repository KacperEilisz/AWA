package com.jsfcourse.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsfcourse.entities.Users;

@Stateless
public class UserDAO {
    private final static String UNIT_NAME = "jsfcourse-simplePU";

    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public Users getUserFromDatabase(String login, String pass) {
        Users user = null;
        
        Query query = em.createNamedQuery("Users.findByLogin");
        query.setParameter("name", login);
        
        try {
            user = (Users) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return user;
    }
    
    public List<String> getUserRolesFromDatabase(Users user) {
        List<String> roles = new ArrayList<>();
        roles.add("user");
        return roles;
    }
}