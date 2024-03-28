package com.model;

import javax.persistence.Id;

public class BaseEntity {

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
