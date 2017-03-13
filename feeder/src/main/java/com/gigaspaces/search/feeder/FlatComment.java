package com.gigaspaces.search.feeder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openspaces.textsearch.SpaceTextIndex;

/**
 * Created by Vitalii Zinchenko
 */
@SpaceClass
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlatComment {

    private String id;
    private String body;
    private String author;
    private Boolean archived;
    private Integer score;

    public FlatComment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
