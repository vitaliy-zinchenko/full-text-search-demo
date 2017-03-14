package com.gigaspaces.search.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.openspaces.textsearch.SpaceTextAnalyzer;
import org.openspaces.textsearch.SpaceTextIndex;

/**
 * Created by Vitalii Zinchenko
 */
@SpaceClass
public class Comment {

    private String id;
    private String body;
    private Author author;
    private Boolean archived;
    private Integer score;

    public Comment() {
    }

    public Comment(String id, String body, Boolean archived, Integer score, Author author) {
        this.id = id;
        this.body = body;
        this.author = author;
        this.archived = archived;
        this.score = score;
    }

    @SpaceId
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SpaceTextIndex
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @SpaceTextIndex(path = "name")
    @SpaceTextAnalyzer(path = "name", analyzer = KeywordAnalyzer.class)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
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

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", author=" + author +
                ", archived=" + archived +
                ", score=" + score +
                '}';
    }
}
