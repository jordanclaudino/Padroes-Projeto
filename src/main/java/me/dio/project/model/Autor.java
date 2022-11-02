package me.dio.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor {
    @Id
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
