package com.whh.chat4.core.io;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 18:17
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
