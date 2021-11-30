package com.whh.chat4.core.io;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description:
 * @author: Artermus wang on 2021-11-30 17:38
 */
@Slf4j
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        try {
            URL url = new URL(location);
            return new UrlResource(url);
        } catch (MalformedURLException e) {
            return new FileSystemResource(location);
        }
    }

}
