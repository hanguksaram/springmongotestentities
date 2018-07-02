package javaboy.mongo.config;

import javaboy.mongo.models.TestMongoEntity;
import javaboy.mongo.services.TestMongoEntityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class WebConfig {

    @Bean
    RouterFunction<?> routes(TestMongoEntityService testMongoEntityService) {
        return RouterFunctions.route(GET("/api/tests"),
                                    serverRequest -> ServerResponse
                                                    .ok()
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .body(testMongoEntityService.listAllEntities(), TestMongoEntity.class));
    }
}
