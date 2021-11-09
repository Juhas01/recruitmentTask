package com.example.recruitmenttask.repositories;

import com.example.recruitmenttask.models.DownloadingError;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlsDataSimple;
import org.hibernate.engine.jdbc.BlobProxy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class UrlsRepository implements IUrlsRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UrlsDataSimple> getAllUrlsSimple(){
        return entityManager.createQuery("select new com.example.recruitmenttask.models.UrlsDataSimple(url.id, url.url) from UrlData url").getResultList();
    }

    @Override
    @Transactional
    public UrlData addUrl(UrlData urlData) {
        entityManager.persist(urlData);
        entityManager.flush();
        return urlData;
    }

    @Override
    @Transactional
    public void downloadDataFromUrlAndSave(URL url, UrlData urlData) throws IOException {
         urlData = entityManager.find(UrlData.class, urlData.getId());
         urlData.setFile(BlobProxy.generateProxy(url.openStream(), -1L));
         entityManager.persist(urlData);
         entityManager.flush();
    }

    @Override
    @Transactional
    public void addDownloadingError(DownloadingError downloadingError) {
        entityManager.persist(downloadingError);
        entityManager.flush();
    }
}
