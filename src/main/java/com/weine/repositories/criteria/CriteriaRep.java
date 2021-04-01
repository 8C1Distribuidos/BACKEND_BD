package com.weine.repositories.criteria;

import com.weine.model.criteria.PageProp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

/**
 * Abstract class to make personalized queries with pagination, sort and filters.
 * @param <T> The entity class
 * @param <X> The search criteria
 */
public abstract class CriteriaRep<T,X> {
    Logger logger = LoggerFactory.getLogger(CriteriaRep.class);
    protected final EntityManager entityManager;
    protected final CriteriaBuilder criteriaBuilder;

    public CriteriaRep(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    /**
     * Function to make the query and get the data, applying the corresponding parameters
     * @param pageProp The properties of the page
     * @param searchCriteria The filters of the query
     * @param entity The entity class path
     * @return The result in a form of Page
     */
    public Page<T> findAllWithFilters(PageProp pageProp, X searchCriteria, Class<T> entity)
    {
        //Initializing the query
        CriteriaQuery<T> criteriaQuery = this.criteriaBuilder.createQuery(entity);
        Root<T> entityRoot = criteriaQuery.from(entity);

        //Adding the filters
        Predicate predicate = getPredicate(searchCriteria, entityRoot);
        criteriaQuery.where(predicate);

        //Applying the sort method
        setOrder(pageProp, criteriaQuery, entityRoot);

        //Adding the limits of the query
        TypedQuery<T> typedQuery = this.entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(pageProp.getPage() * pageProp.getSize());
        typedQuery.setMaxResults(pageProp.getSize());

        //Generating the pageable
        Pageable pageable = getPageable(pageProp);

        //Getting the total count
        long totalCount = getCount(predicate, entity);
        return new PageImpl<>(typedQuery.getResultList(), pageable, totalCount);
    }

    /**
     * Function to get the total amount of results of the search
     * @param predicate The predicate where is the filters
     * @param entity The entity path
     * @return The amount of rows
     */
    protected long getCount(Predicate predicate, Class<T> entity){
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> countRoot = countQuery.from(entity);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    /**
     * Function to apply the filters in a predicate
     * @param searchCriteria The filters of the query
     * @param entityRoot The entity root
     * @return The predicate of the filters
     */
    protected abstract Predicate getPredicate(X searchCriteria, Root<T> entityRoot);

    /**
     * Function to set the order of the result
     * @param pageProp The page properties
     * @param criteriaQuery The criteria query or in other words the query
     * @param entityRoot The entity root
     */
    protected void setOrder(PageProp pageProp, CriteriaQuery<T> criteriaQuery, Root<T> entityRoot) {
        try {
            if (Objects.nonNull(pageProp)) {
                if (pageProp.getSortDirection().equals(Sort.Direction.ASC)) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(entityRoot.get(pageProp.getSortBy())));
                } else {
                    criteriaQuery.orderBy(criteriaBuilder.desc(entityRoot.get(pageProp.getSortBy())));
                }
            }
        } catch(Exception e){
            logger.error(e.getMessage());
        }
    }

    /**
     * Function to get Pageable properties
     * @param pageProp The page properties
     * @return The pageable object
     */
    protected Pageable getPageable(PageProp pageProp) {
        Sort sort = Sort.by(pageProp.getSortDirection(), pageProp.getSortBy());
        return PageRequest.of(pageProp.getPage(), pageProp.getSize(), sort);
    }
}
