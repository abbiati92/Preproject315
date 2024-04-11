package com.perevozchikov.Preproject314.repository;

import com.perevozchikov.Preproject314.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Set<Role> getRoles() {
        return entityManager.createQuery("from Role ", Role.class).getResultStream().collect(Collectors.toSet());
    }

    @Transactional
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findById(Integer id) {
        return entityManager.find(Role.class, id);
    }
}