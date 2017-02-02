package my.task.domain;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Loner on 27.01.2017.
 */

@Component
public class JPAReports {

    @PersistenceContext
    EntityManager em;


    /**
     * This method create selection from database with criterias.
     * @param one - data from start input for where.
     * @param two - data from end input for where.
     * @param three - data from performer select for where.
     * @return List of Reports.
     */

    public List<Reports> getPerformers(Date one, Date two, String three) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Reports> cq = cb.createQuery(Reports.class);
        Root<Reports> root = cq.from(Reports.class);

        Predicate whereClous = null;
        if (Objects.nonNull(one) && !one.equals("01/01/1900")){
            whereClous = cb.and(cb.greaterThanOrEqualTo(root.get("startDate").as(java.sql.Date.class), one));
        }
        if (Objects.nonNull(two) && !two.equals("01/01/1900")){
            whereClous = cb.and(cb.lessThanOrEqualTo(root.get("endDate").as(java.sql.Date.class), two));
        }
        if (Objects.nonNull(three) && !three.equals("0")){
            whereClous = cb.and(cb.like(root.get("perfomer"),three));
        }
        if (Objects.nonNull(whereClous))cq.where(whereClous);

        TypedQuery<Reports> q = em.createQuery(cq);

        List<Reports> res = q.getResultList();

        return res;
    }




}
