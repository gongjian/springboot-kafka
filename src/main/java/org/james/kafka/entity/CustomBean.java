package org.james.kafka.entity;

import java.io.Serializable;

public class CustomBean implements Serializable {
    private int id;
    private String name;

    public CustomBean() {
        System.out.println("CustomBean.CustomBean");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
