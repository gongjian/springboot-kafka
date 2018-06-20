package org.james.kafka.entity;

import java.io.Serializable;

public class Message implements Serializable {

    private int id;
    private String data;

    public Message() {
    }

    public Message(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
