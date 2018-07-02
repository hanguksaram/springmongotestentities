package javaboy.mongo.services;

import javaboy.mongo.models.TestMongoEntity;
import javaboy.mongo.repositories.ReactiveTest1EntityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import static org.junit.Assert.*;
import static reactor.core.publisher.Mono.when;

public class TestMongoEntityServiceImplTest {

    TestMongoEntityService testMongoEntityService;



    @Mock
    ReactiveTest1EntityRepository reactiveTest1EntityRepository;

    @Before
    public void setUp() throws Exception {


        MockitoAnnotations.initMocks(this);
        testMongoEntityService = new TestMongoEntityServiceImpl(reactiveTest1EntityRepository);

    }
    @Test
    public void testGetAllTestEntities() {
        TestMongoEntity test1 = new TestMongoEntity();
        test1.setDescription("1");
        test1.setName("1");

        TestMongoEntity test2 = new TestMongoEntity();
        test1.setDescription("2");
        test1.setName("2");

        when(reactiveTest1EntityRepository.findAll()).thenReturn(Flux.just(test1, test2));

    }
}