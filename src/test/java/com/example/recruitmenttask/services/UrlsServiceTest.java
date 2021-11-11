package com.example.recruitmenttask.services;

import com.example.recruitmenttask.exceptionMappers.URlDataNotFoundException;
import com.example.recruitmenttask.mappers.UrlsMapper;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlDataSimple;
import com.example.recruitmenttask.repositories.IUrlsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class UrlsServiceTest {

    private IUrlsRepository urlsRepositoryMock;
    private DownloadManager downloadManagerMock;

    @BeforeEach
    public void prepare(){
        urlsRepositoryMock = mock(IUrlsRepository.class);
        downloadManagerMock = mock(DownloadManager.class);
    }

    @Test
    public void shouldInvokeSaveOrUpdateAndAddToQueue_When_addUrlCalled(){
        //given
        UrlData urlData = new UrlData(1L, "test.url");
        when(urlsRepositoryMock.saveOrUpdateUrlData(any())).thenReturn(urlData);
        UrlsMapper urlsMapper = new UrlsMapper();
        UrlsService urlsService = new UrlsService(urlsRepositoryMock, urlsMapper, downloadManagerMock);
        //when
        urlsService.addUrl(new UrlDataSimple("test.url"));
        //then
        verify(urlsRepositoryMock).saveOrUpdateUrlData(any());
        verify(downloadManagerMock).addToDownloadQueue(urlData);
    }

    @Test
    public void shouldInvokeSaveOrUpdateListOfUrlsAndAddListToDownloadingQueue_When_addListOfUrlsCalled(){
        //given
        UrlsService urlsService = new UrlsService(urlsRepositoryMock, new UrlsMapper(), downloadManagerMock);
        List<UrlDataSimple> urlsToAdd = new LinkedList<>();
        urlsToAdd.add(new UrlDataSimple("test1.url"));
        urlsToAdd.add(new UrlDataSimple("test2.url"));

        List<UrlData> urlsFromRepo=new LinkedList<>();
        urlsFromRepo.add(new UrlData(1L, "test1.url", false));
        urlsFromRepo.add(new UrlData(2L, "test2.url", false));
        when(urlsRepositoryMock.saveOrUpdateListOfUrls(any())).thenReturn(urlsFromRepo);
        //when
        urlsService.addListOfUrls(urlsToAdd);
        //then
        verify(urlsRepositoryMock).saveOrUpdateListOfUrls(any());
        verify(downloadManagerMock).addListToDownloadingQueue(urlsFromRepo);
    }

    @Test
    public void shouldThrowURlDataNotFoundException_When_UrlsRepoGetUrlDataByIdReturnsNull(){
        //given
        when(urlsRepositoryMock.getUrlDataById(any())).thenReturn(null);
        UrlsService urlsService = new UrlsService(urlsRepositoryMock, new UrlsMapper(), downloadManagerMock);
        //when
        assertThrows(URlDataNotFoundException.class, () -> urlsService.getUrlById(1L));
    }

    @Test
    public void shouldReturnUrlDataSimpleMappedFromUrldDataFromRepo_When_RepoReturnsUrlDataById(){
        //given
        UrlData urlDataGiven = new UrlData(1L, "test.url", true);
        when(urlsRepositoryMock.getUrlDataById(any())).thenReturn(urlDataGiven);
        UrlsService urlsService = new UrlsService(urlsRepositoryMock, new UrlsMapper(), downloadManagerMock);
        //when
        UrlDataSimple urlById = urlsService.getUrlById(1L);
        //then
        assertEquals(urlById.getUrl(), urlDataGiven.getUrl());
        assertEquals(urlById.getId(), urlDataGiven.getId());
        assertEquals(urlById.getDownloaded(), urlDataGiven.getDownloaded());
    }

    @Test
    public void shouldReturnUrlsSimpleFromDownloadingQueue_When_getDownloadingQueueCalled(){
        //given
        UrlData urlData1 = new UrlData(1L, "test1.url");
        UrlData urlData2 = new UrlData(2L, "test2.url");
        Queue<UrlData> urlsQueue = new LinkedList<>();
        urlsQueue.add(urlData1);
        urlsQueue.add(urlData2);
        when(downloadManagerMock.getDownloadingQueue()).thenReturn(urlsQueue);
        UrlsService urlsService = new UrlsService(urlsRepositoryMock, new UrlsMapper(), downloadManagerMock);
        //when
        List<UrlDataSimple> downloadingQueue = urlsService.getDownloadingQueue();
        UrlDataSimple urlDataSimple1 = downloadingQueue.get(0);
        UrlDataSimple urlDataSimple2 = downloadingQueue.get(1);
        //then
        assertEquals(urlData1.getId(), urlDataSimple1.getId());
        assertEquals(urlData1.getUrl(), urlDataSimple1.getUrl());
        assertEquals(urlData2.getId(), urlDataSimple2.getId());
        assertEquals(urlData2.getUrl(), urlDataSimple2.getUrl());
    }

    @Test
    public void shouldReturnEmptyList_When_noUrlsAddedAndGetDownloadingQueueCalled(){
        //given
        when(downloadManagerMock.getDownloadingQueue()).thenReturn(null);
        UrlsService urlsService = new UrlsService(urlsRepositoryMock, new UrlsMapper(), downloadManagerMock);
        //when
        List<UrlDataSimple> downloadingQueue = urlsService.getDownloadingQueue();
        //then
        assertEquals(0, downloadingQueue.size());
    }

}
