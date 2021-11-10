package com.example.recruitmenttask.mappers;

import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlDataSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrlsMapperTest {

    @Test
    public void ShouldReturnUrlDataSimpleWithFilledGivenData_When_mapToSimpleCalled(){
        //given
        UrlData urlData0 = new UrlData(null, "test.url");
        UrlData urlData1 = new UrlData(1L, "test.url1");
        UrlData urlData2 = new UrlData(2L, "test.url2", true);
        UrlData urlData3 = new UrlData(3L, null);
        UrlData urlData4 = new UrlData(4L, null, true);
        UrlData urlData5 = new UrlData(null, null, true);
        UrlsMapper urlsMapper = new UrlsMapper();
        //when
        UrlDataSimple urlDataSimple0 = urlsMapper.mapToSimple(urlData0);
        UrlDataSimple urlDataSimple1 = urlsMapper.mapToSimple(urlData1);
        UrlDataSimple urlDataSimple2 = urlsMapper.mapToSimple(urlData2);
        UrlDataSimple urlDataSimple3 = urlsMapper.mapToSimple(urlData3);
        UrlDataSimple urlDataSimple4 = urlsMapper.mapToSimple(urlData4);
        UrlDataSimple urlDataSimple5 = urlsMapper.mapToSimple(urlData5);
        //then
        assertEquals(urlData0.getUrl(), urlDataSimple0.getUrl());
        assertEquals(urlData0.getId(), urlDataSimple0.getId());
        assertEquals(urlData0.getDownloaded(), urlDataSimple0.getDownloaded());

        assertEquals(urlData1.getUrl(), urlDataSimple1.getUrl());
        assertEquals(urlData1.getId(), urlDataSimple1.getId());
        assertEquals(urlData1.getDownloaded(), urlDataSimple1.getDownloaded());

        assertEquals(urlData2.getUrl(), urlDataSimple2.getUrl());
        assertEquals(urlData2.getId(), urlDataSimple2.getId());
        assertEquals(urlData2.getDownloaded(), urlDataSimple2.getDownloaded());

        assertEquals(urlData3.getUrl(), urlDataSimple3.getUrl());
        assertEquals(urlData3.getId(), urlDataSimple3.getId());
        assertEquals(urlData3.getDownloaded(), urlDataSimple3.getDownloaded());

        assertEquals(urlData4.getUrl(), urlDataSimple4.getUrl());
        assertEquals(urlData4.getId(), urlDataSimple4.getId());
        assertEquals(urlData4.getDownloaded(), urlDataSimple4.getDownloaded());

        assertEquals(urlData5.getUrl(), urlDataSimple5.getUrl());
        assertEquals(urlData5.getId(), urlDataSimple5.getId());
        assertEquals(urlData5.getDownloaded(), urlDataSimple5.getDownloaded());
    }

    @Test
    public void shouldReturnUrlDataWithFilledFieldsFromUrlDataSimple_When_mapFromSimpleCalled(){
        //given
        UrlDataSimple urlDataSimple0 = new UrlDataSimple(null, "test.url");
        UrlDataSimple urlDataSimple1 = new UrlDataSimple(1L, "test.url1");
        UrlDataSimple urlDataSimple2 = new UrlDataSimple(2L, "test.url2", true);
        UrlDataSimple urlDataSimple3 = new UrlDataSimple(3L, null);
        UrlDataSimple urlDataSimple4 = new UrlDataSimple(4L, null, true);
        UrlDataSimple urlDataSimple5 = new UrlDataSimple(null, null, true);
        UrlsMapper urlsMapper = new UrlsMapper();
        //when
        UrlData urlData0 = urlsMapper.mapFromSimple(urlDataSimple0);
        UrlData urlData1 = urlsMapper.mapFromSimple(urlDataSimple1);
        UrlData urlData2 = urlsMapper.mapFromSimple(urlDataSimple2);
        UrlData urlData3 = urlsMapper.mapFromSimple(urlDataSimple3);
        UrlData urlData4 = urlsMapper.mapFromSimple(urlDataSimple4);
        UrlData urlData5 = urlsMapper.mapFromSimple(urlDataSimple5);
        //then
        assertEquals(urlData0.getUrl(), urlDataSimple0.getUrl());
        assertEquals(urlData0.getId(), urlDataSimple0.getId());
        assertEquals(urlData0.getDownloaded(), urlDataSimple0.getDownloaded());

        assertEquals(urlData1.getUrl(), urlDataSimple1.getUrl());
        assertEquals(urlData1.getId(), urlDataSimple1.getId());
        assertEquals(urlData1.getDownloaded(), urlDataSimple1.getDownloaded());

        assertEquals(urlData2.getUrl(), urlDataSimple2.getUrl());
        assertEquals(urlData2.getId(), urlDataSimple2.getId());
        assertEquals(urlData2.getDownloaded(), urlDataSimple2.getDownloaded());

        assertEquals(urlData3.getUrl(), urlDataSimple3.getUrl());
        assertEquals(urlData3.getId(), urlDataSimple3.getId());
        assertEquals(urlData3.getDownloaded(), urlDataSimple3.getDownloaded());

        assertEquals(urlData4.getUrl(), urlDataSimple4.getUrl());
        assertEquals(urlData4.getId(), urlDataSimple4.getId());
        assertEquals(urlData4.getDownloaded(), urlDataSimple4.getDownloaded());

        assertEquals(urlData5.getUrl(), urlDataSimple5.getUrl());
        assertEquals(urlData5.getId(), urlDataSimple5.getId());
        assertEquals(urlData5.getDownloaded(), urlDataSimple5.getDownloaded());

    }
}
