package javaboy.mongo.repositories;

import javaboy.mongo.models.NestedMongoEntity;
import org.springframework.data.repository.CrudRepository;

public interface NestedMongoEntityRepository extends CrudRepository<NestedMongoEntity, String> {
}
