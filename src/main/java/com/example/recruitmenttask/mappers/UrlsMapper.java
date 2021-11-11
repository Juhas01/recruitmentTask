package com.example.recruitmenttask.mappers;

import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlDataSimple;

public class UrlsMapper {

    public UrlData mapFromSimple(UrlDataSimple urlDataSimple){
        if(urlDataSimple.getDownloaded()==null){
            urlDataSimple.setDownloaded(false);
        }
        return new UrlData(urlDataSimple.getId(), urlDataSimple.getUrl(), urlDataSimple.getDownloaded());
    }

    public UrlDataSimple mapToSimple(UrlData urlData){
        if(urlData.getDownloaded()==null){
            urlData.setDownloaded(false);
        }
        return new UrlDataSimple(urlData.getId(), urlData.getUrl(), urlData.getDownloaded());
    }
}
