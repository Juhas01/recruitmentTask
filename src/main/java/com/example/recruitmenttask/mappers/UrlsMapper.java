package com.example.recruitmenttask.mappers;

import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlDataSimple;

public class UrlsMapper {

    public UrlData mapFromSimple(UrlDataSimple urlDataSimple){
        return new UrlData(urlDataSimple.getId(), urlDataSimple.getUrl(), urlDataSimple.getDownloaded());
    }

    public UrlDataSimple mapToSimple(UrlData urlData){
        return new UrlDataSimple(urlData.getId(), urlData.getUrl(), urlData.getDownloaded());
    }
}
