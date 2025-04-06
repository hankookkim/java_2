package com.example.edgeservice.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration

public class WebEndpoints {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route()
                .GET(
                        "/service-fallback",
                        request -> ServerResponse.ok().body(Mono.just(""), String.class)
                )
                .POST(
                        "/service-fallback",
                        request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build()
                )
                .PUT(
                        "/service-fallback",
                        request -> ServerResponse.ok().body(Mono.just(""), String.class)
                )
                .DELETE(
                        "/service-fallback",
                        request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build()
                )
                .build();

    }
}
