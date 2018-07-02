package javaboy.mongo.repositories;

import javaboy.mongo.models.NestedMongoEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataMongoTest
public class ReactiveNestedEntityRepositoryTest {

    @Autowired
    ReactiveNestedEntityRepository nestedEntityRepository;
    @Before
    public void setUp() throws Exception {
        nestedEntityRepository.deleteAll().block();
    }

    @Test
    public void testNestedEntitySave() {

        NestedMongoEntity nestedMongoEntity = new NestedMongoEntity();
        nestedMongoEntity.setNestedDescripton("Sap dude");

        nestedEntityRepository.save(nestedMongoEntity).block();
        Long count = nestedEntityRepository.count().block();

        assertEquals(Long.valueOf(1L), count);

    }
    @Test
    public void testFindByDescription() {

        NestedMongoEntity nestedMongoEntity = new NestedMongoEntity();
        nestedMongoEntity.setNestedDescripton("Boo");

        nestedEntityRepository.save(nestedMongoEntity).block();

        NestedMongoEntity nestedMongoEntity1 = nestedEntityRepository.findByNestedDescripton("Boo").block();
        assertNotNull(nestedMongoEntity1.getNestedDescripton());
    }
}