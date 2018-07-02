package javaboy.mongo.services;

import javaboy.mongo.models.TestMongoEntity;
import javaboy.mongo.repositories.ReactiveTest1EntityRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TestMongoEntityServiceImpl implements TestMongoEntityService {

    private final ReactiveTest1EntityRepository reactiveTest1EntityRepository;

    public TestMongoEntityServiceImpl(ReactiveTest1EntityRepository reactiveTest1EntityRepository) {
        this.reactiveTest1EntityRepository = reactiveTest1EntityRepository;
    }


    @Override
    public Flux<TestMongoEntity> listAllEntities() {
        return reactiveTest1EntityRepository
                    .findAll();


    }
}
