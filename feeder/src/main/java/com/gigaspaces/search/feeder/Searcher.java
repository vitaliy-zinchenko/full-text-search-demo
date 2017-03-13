package com.gigaspaces.search.feeder;

import com.gigaspaces.search.model.Comment;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

/**
 * Created by vitaliizinchenko on 3/6/17.
 */
public class Searcher {

    public static void main(String[] args) {
        SpaceConfigurer configurer = new UrlSpaceConfigurer("jini://*/*/space")
                .lookupGroups("xap-12.1.0");

        GigaSpace space = new GigaSpaceConfigurer(configurer).gigaSpace();

        SQLQuery<Comment> query = new SQLQuery<Comment>(Comment.class, "body text:match ?");
        query.setParameter(1, "java");

        for (int i = 0; i < 5; i++) {
            Long start = System.currentTimeMillis();
            Comment[] comments = space.readMultiple(query);
            Long finish = System.currentTimeMillis();
            int total = space.count(new Comment());
            System.out.println("Time: " + (finish - start) + " count: " + comments.length + " total: " + total);
        }


//        for(FlatComment comment: comments) {
//            System.out.println(comment.);
//        }

    }
}
