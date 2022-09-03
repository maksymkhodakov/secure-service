package com.example.security.repo.impl;

import com.example.security.domain.Report;
import com.example.security.repo.ReportRepoCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@AllArgsConstructor
public class ReportRepoCriteriaImpl implements ReportRepoCriteria {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Report> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Report> criteriaQuery = criteriaBuilder.createQuery(Report.class);
        Root<Report> root = criteriaQuery.from(Report.class);

        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Report getById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Report> criteriaQuery = criteriaBuilder.createQuery(Report.class);
        Root<Report> root = criteriaQuery.from(Report.class);

        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("id"), id));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
