package com.example.recruitmenttask.services;

import com.example.recruitmenttask.repositories.IUrlsRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class UrlsServiceTest {

    private IUrlsRepository urlsRepositoryMock;

    @BeforeEach
    public void prepare(){
        urlsRepositoryMock = mock(IUrlsRepository.class);
    }

}
