package com.example.recruitmenttask.services;

import com.example.recruitmenttask.exceptionMappers.URlDataNotFoundException;
import com.example.recruitmenttask.mappers.UrlsMapper;
import com.example.recruitmenttask.models.UrlData;
import com.example.recruitmenttask.models.UrlDataSimple;
import com.example.recruitmenttask.repositories.IUrlsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;

import java.util.LinkedList;
import java.util.List;

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
    public void shouldThrowURlDataNotFoundException_When_UrlsRepoReturnsgetUrlDataByIdReturnsNull(){
        //given
        when(urlsRepositoryMock.getUrlDataById(any())).thenReturn(null);
        UrlsService urlsService = new UrlsService(urlsRepositoryMock, new UrlsMapper(), downloadManagerMock);
        //when
        Assertions.assertThrows(URlDataNotFoundException.class, () -> urlsService.getUrlById(1L));

    }

}
