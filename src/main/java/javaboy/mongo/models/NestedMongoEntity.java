package javaboy.mongo.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class NestedMongoEntity {

    private String id = UUID.randomUUID().toString();
    private String nestedDescripton;
    private String nestedName;

    public NestedMongoEntity() {
    }

    public NestedMongoEntity(String nestedDescripton, String nestedName) {
        this.nestedDescripton = nestedDescripton;
        this.nestedName = nestedName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNestedDescripton() {
        return nestedDescripton;
    }

    public void setNestedDescripton(String nestedDescripton) {
        this.nestedDescripton = nestedDescripton;
    }

    public String getNestedName() {
        return nestedName;
    }

    public void setNestedName(String nestedName) {
        this.nestedName = nestedName;
    }
}
