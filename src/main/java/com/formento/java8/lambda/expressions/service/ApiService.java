package com.formento.java8.lambda.expressions.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.util.Optional;

public class ApiService {

    public RequestEntity<Object> buildRequest(final Object body, final HttpMethod httpMethod, final URI uri) {
        return Optional.ofNullable(body)
                .map(b -> new RequestEntity<>(b, httpMethod, uri))
                .orElse(new RequestEntity<>(httpMethod, uri));
    }

}
