package com.gigaspaces.search.web.service;

import com.gigaspaces.search.model.Comment;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private GigaSpace space;

    public Comment[] getComments(String queryString, List<String> params) {
        SQLQuery<Comment> query = new SQLQuery<Comment>(Comment.class, queryString);
        for (int i = 0; i < params.size(); i++) {
            String p = params.get(i);
            System.out.println("Setting i = " + (i + 1) + " q = " + queryString + " p = " + p);

            query.setParameter(i + 1, p);
        }
        System.out.println("Running query: " + query);
        Comment[] comments = space.readMultiple(query);
        System.out.println("Query running finished");
        return comments == null ? new Comment[0] : comments;
    }

    public int count() {
        Long start = System.currentTimeMillis();
        int count = 1;//space.count(new Comment());
        Long finish = System.currentTimeMillis();
        System.out.println("Time to count: " + (finish - start));
        return count;
    }

}
