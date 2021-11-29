package com.whh.chat4.beans;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 15:32
 */
@Slf4j
@Getter
public class PropertyValue {

    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

}
