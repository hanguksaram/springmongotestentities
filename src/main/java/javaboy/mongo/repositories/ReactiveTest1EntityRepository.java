package javaboy.mongo.repositories;

import javaboy.mongo.models.TestMongoEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ReactiveTest1EntityRepository extends ReactiveMongoRepository<TestMongoEntity, String> {

    Mono<TestMongoEntity> findByDescription (String description);
}
