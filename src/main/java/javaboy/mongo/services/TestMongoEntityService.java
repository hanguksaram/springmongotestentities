package javaboy.mongo.services;

import javaboy.mongo.models.TestMongoEntity;
import reactor.core.publisher.Flux;

public interface TestMongoEntityService {

    Flux<TestMongoEntity> listAllEntities();


}
