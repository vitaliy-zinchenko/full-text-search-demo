package com.gigaspaces.search.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import org.openspaces.textsearch.SpaceTextIndex;

import java.io.Serializable;

/**
 * Created by Vitalii Zinchenko
 */
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
