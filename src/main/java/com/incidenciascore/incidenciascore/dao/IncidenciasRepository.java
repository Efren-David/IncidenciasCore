package com.incidenciascore.incidenciascore.dao;

import org.springframework.stereotype.Repository;

import com.incidenciascore.incidenciascore.response.ParamDataResponse;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Repository @Transactional
public class IncidenciasRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ParamDataResponse getInfo() {

        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("parametria");

        storedProcedureQuery.execute();

        return (ParamDataResponse) storedProcedureQuery.getResultList().get(0);
    }
    
    
    
    
    
    
    
    
    
    
    
}
