package javaboy.mongo.repositories;

import javaboy.mongo.models.TestMongoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestMongoEntityRepository extends CrudRepository<TestMongoEntity, String> {
}
