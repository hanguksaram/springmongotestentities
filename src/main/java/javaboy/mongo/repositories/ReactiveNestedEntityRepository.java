package javaboy.mongo.repositories;

import javaboy.mongo.models.NestedMongoEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ReactiveNestedEntityRepository extends ReactiveMongoRepository<NestedMongoEntity, String> {

    Mono<NestedMongoEntity> findByNestedDescripton(String description);
}
