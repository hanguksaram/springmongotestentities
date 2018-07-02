package javaboy.mongo.bootstrap;

import javaboy.mongo.models.NestedMongoEntity;
import javaboy.mongo.models.TestMongoEntity;
import javaboy.mongo.repositories.NestedMongoEntityRepository;
import javaboy.mongo.repositories.ReactiveTest1EntityRepository;
import javaboy.mongo.repositories.TestMongoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProjectBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final TestMongoEntityRepository testMongoEntityRepository;
    private final NestedMongoEntityRepository nestedMongoEntityRepository;



    public ProjectBootstrap(TestMongoEntityRepository testMongoEntityRepository, NestedMongoEntityRepository nestedMongoEntityRepository) {
        this.testMongoEntityRepository = testMongoEntityRepository;
        this.nestedMongoEntityRepository = nestedMongoEntityRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {



        Set<NestedMongoEntity> nestedMongoEntities = new HashSet<>();
        nestedMongoEntities.add(new NestedMongoEntity("nestedDesc", "nestedName"));
        nestedMongoEntities.add(new NestedMongoEntity("nestedDesc1", "nestedName2"));

        for (NestedMongoEntity elem: nestedMongoEntities
             ) { nestedMongoEntityRepository.save(elem);

        }

        for (int i = 0; i < 5; i++){
            testMongoEntityRepository.save(new TestMongoEntity("test" + i, "testdescription" + i, nestedMongoEntities));
        }


    }
}
