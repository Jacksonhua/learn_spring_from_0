package com.whh.chat4.context.support;

import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @description:
 * @author: Artermus wang on 2021-12-01 18:21
 */
@Slf4j
public class DefaultXmlApplicationContext extends AbstractXmlApplicationContext {
    private String[] configLocations;

    public DefaultXmlApplicationContext() {
    }
    public DefaultXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    public DefaultXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;

    }

}
