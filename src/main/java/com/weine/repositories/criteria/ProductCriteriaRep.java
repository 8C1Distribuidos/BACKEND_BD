package com.weine.repositories.criteria;

import com.weine.entities.Product;
import com.weine.model.criteria.ProductCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductCriteriaRep extends CriteriaRep<Product, ProductCriteria>{

    public ProductCriteriaRep(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Predicate getPredicate(ProductCriteria searchCriteria, Root<Product> entityRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(searchCriteria)) {
            predicates.add(criteriaBuilder.equal(entityRoot.get("deleted"), false));
            if(Objects.nonNull(searchCriteria.getName())) {
                predicates.add(criteriaBuilder.like(entityRoot.get("name"), "%" + searchCriteria.getName() + "%"));
            }
            if(Objects.nonNull(searchCriteria.getStock())) {
                if(searchCriteria.isStockGreater()) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(entityRoot.get("stock"), searchCriteria.getStock()));
                }
                else {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(entityRoot.get("stock"), searchCriteria.getStock()));
                }
            }
            if(Objects.nonNull(searchCriteria.getPrice())) {
                if(searchCriteria.isPriceGreater()) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(entityRoot.get("price"), searchCriteria.getPrice()));
                }
                else {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(entityRoot.get("price"), searchCriteria.getPrice()));
                }
            }
        }
        return  criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
