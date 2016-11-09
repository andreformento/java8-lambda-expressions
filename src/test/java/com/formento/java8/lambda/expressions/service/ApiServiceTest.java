package com.formento.java8.lambda.expressions.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ApiServiceTest {
    private static final String url = "http://www.mocky.io/v2/58210c6c120000ca006f4649";

    @InjectMocks
    private ApiService apiService;

    @Test
    public void shouldDoGet() throws URISyntaxException {
        // given
        final Object body = null;
        final HttpMethod httpMethod = HttpMethod.GET;
        final URI uri = new URI(url);

        // when
        final RequestEntity<Object> requestEntity = apiService.buildRequest(body, httpMethod, uri);

        // then
        assertNotNull(requestEntity);
        assertFalse(requestEntity.hasBody());
    }

    @Test
    public void shouldDoPost() throws URISyntaxException {
        // given
        final Object body = "{ \"name\": \"Paul\"}";
        final HttpMethod httpMethod = HttpMethod.POST;
        final URI uri = new URI(url);

        // when
        final RequestEntity<Object> requestEntity = apiService.buildRequest(body, httpMethod, uri);

        // then
        assertNotNull(requestEntity);
        assertTrue(requestEntity.hasBody());
    }

}
