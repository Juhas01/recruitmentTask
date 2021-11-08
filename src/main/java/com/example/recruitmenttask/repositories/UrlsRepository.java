package com.example.recruitmenttask.repositories;

import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlsDataSimple;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class UrlsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UrlsDataSimple> getAllUrlsSimple(){
        return entityManager.createQuery("select new com.example.recruitmenttask.models.UrlsDataSimple(url.id, url.url) from UrlData url").getResultList();
    }

    @Transactional
    public UrlData addUrl(UrlData urlData) {
        entityManager.persist(urlData);
        entityManager.flush();
        return urlData;
    }
}
