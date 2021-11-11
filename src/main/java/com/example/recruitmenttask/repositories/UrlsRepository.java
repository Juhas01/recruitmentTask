package com.example.recruitmenttask.repositories;

import com.example.recruitmenttask.models.DownloadingError;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlDataSimple;
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
    public List<UrlDataSimple> getAllUrlsSimple(){
        return entityManager.createQuery("select new com.example.recruitmenttask.models.UrlDataSimple(url.id, url.url, url.isDownloaded) from UrlData url").getResultList();
    }

    @Override
    @Transactional
    public UrlData saveOrUpdateUrlData(UrlData urlData) {
        if (urlData.getId()!=null){
            entityManager.merge(urlData);
        }else {
            entityManager.persist(urlData);
        }
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

    @Override
    public UrlData getUrlDataById(Long urlId) {
        return entityManager.find(UrlData.class, urlId);
    }

    @Override
    @Transactional
    public List<UrlData> saveOrUpdateListOfUrls(List<UrlData> urlData) {
        for (UrlData url : urlData) {
            if (url.getId()!=null){
                entityManager.merge(url);
            }else {
                entityManager.persist(url);
            }
        }
        entityManager.flush();
        return urlData;
    }

    @Override
    public List<UrlData> getNotDownloadedUrls() {
        return entityManager.createQuery("select url from UrlData url where url.isDownloaded=false order by url.id").getResultList();
    }
}
