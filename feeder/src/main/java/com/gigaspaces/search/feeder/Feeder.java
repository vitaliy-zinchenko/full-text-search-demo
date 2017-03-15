package com.gigaspaces.search.feeder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gigaspaces.metadata.SpaceTypeDescriptor;
import com.gigaspaces.metadata.SpaceTypeDescriptorBuilder;
import com.gigaspaces.search.model.Author;
import com.gigaspaces.search.model.Comment;
import com.j_spaces.core.client.SQLQuery;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.openspaces.textsearch.LuceneTextSearchQueryExtensionProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaliizinchenko on 3/6/17.
 */
public class Feeder {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String spaceUrl = args[0];
        String lookupGroups = args[1];
        Integer maxCount = Integer.parseInt(args[2]);
        String path = args[3];

        BufferedReader reader = new BufferedReader(new FileReader(path));

        SpaceConfigurer configurer = new UrlSpaceConfigurer(spaceUrl)
                .lookupGroups(lookupGroups);
        GigaSpace space = new GigaSpaceConfigurer(configurer).gigaSpace();

        String line;
        int size = 10000;
        int count = 0;
        List<Comment> list = new ArrayList<Comment>(size);
        while ((line = reader.readLine()) != null && count < maxCount) {
            list.add(convert(mapper.readValue(line, FlatComment.class)));
            if(list.size() % size == 0) {
                space.writeMultiple(list.toArray());
                count += list.size();
                list.clear();
                System.out.println("Wrote: " + count/1000 + "k");
            }
        }

        reader.close();

        System.out.println("Finished!");
    }

    private static Comment convert(FlatComment flatComment) {
        return new Comment(
                flatComment.getId(),
                flatComment.getBody(),
                flatComment.getArchived(),
                flatComment.getScore(),
                new Author(flatComment.getAuthor()));
    }

}
