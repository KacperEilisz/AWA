package com.jsfcourse.dao;

import java.util.List;
import java.util.Map;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import com.jsfcourse.entities.Instruments;

@Stateless
public class InstrumentDAO {
    private final static String UNIT_NAME = "jsfcourse-simplePU";
    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public void create(Instruments instrument) {
        em.persist(instrument);
    }
    public Instruments merge(Instruments instrument) {
        return em.merge(instrument);
    }
    public void remove(Instruments instrument) {
        em.remove(em.merge(instrument));
    }
    public Instruments find(Object id) {
        return em.find(Instruments.class, id);
    }
    public List<Instruments> getFullList() {
        List<Instruments> list = null;
        Query query = em.createQuery("select i from Instruments i");
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Instruments> getList(Map<String, Object> searchParams) {
        List<Instruments> list = null;

        String select = "select i ";
        String from = "from Instruments i ";
        String where = "";
        String orderby = "order by i.name asc";
        String name = (String) searchParams.get("name");
        if (name != null) {
            if (where.isEmpty()) {
                where = "where ";
            } else {
                where += "and ";
            }
            where += "i.name like :name ";
        }
        Query query = em.createQuery(select + from + where + orderby);
        if (name != null) {
            query.setParameter("name", name+"%");
        }
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}