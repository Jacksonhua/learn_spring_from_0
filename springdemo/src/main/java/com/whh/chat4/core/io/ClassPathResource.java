package com.whh.chat4.core.io;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 18:05
 */
@Slf4j
public class ClassPathResource implements Resource {

    private final String path;

    private Class<?> Clazz;

    private ClassLoader classLoader;

    public ClassPathResource(String path ) {
        this(path,(ClassLoader) null);
    }
    public ClassPathResource(String path,ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader():classLoader;

    }
    public ClassPathResource(String path,Class clazz) {
        this(path,clazz.getClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return classLoader.getResourceAsStream(path);
    }
}
