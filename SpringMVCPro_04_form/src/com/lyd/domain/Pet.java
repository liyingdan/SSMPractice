package com.lyd.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Pet {
    private String name;
    private Integer id;

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
