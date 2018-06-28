package javaboy.mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Document
public class TestMongoEntity {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    @DBRef
    private Set<NestedMongoEntity> nestedMongoEntities = new HashSet<>();



    public TestMongoEntity(String name, String description, Set<NestedMongoEntity> nestedMongoEntities) {
        this.name = name;
        this.description = description;
        this.nestedMongoEntities = nestedMongoEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Set<NestedMongoEntity> getNestedMongoEntities() {
        return nestedMongoEntities;
    }

    public void setNestedMongoEntities(Set<NestedMongoEntity> nestedMongoEntities) {
        this.nestedMongoEntities = nestedMongoEntities;
    }
}
