package com.gigaspaces.search.feeder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gigaspaces.search.model.Comment;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by vitaliizinchenko on 3/6/17.
 */
public class SpaceCleaner {

    public static void main(String[] args) throws IOException {
        SpaceConfigurer configurer = new UrlSpaceConfigurer("jini://*/*/space")
                .lookupGroups("xap-12.1.0");

        GigaSpace space = new GigaSpaceConfigurer(configurer).gigaSpace();

        space.clear(new Comment());
    }
}
