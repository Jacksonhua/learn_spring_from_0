package com.whh.chat4.beans;

import com.whh.chat3.factory.PropertyValue;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**
 * @description:
 * @author: Artermus wang on 2021-11-26 14:05
 */
@Slf4j
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
    public void addPropertyValue(PropertyValue value) {
        propertyValueList.add(value);
    }

    public PropertyValue getProertyValue(String name){
        return propertyValueList.stream().filter(value -> value.getName().equals(name)).findFirst().orElse(null);
    }
}
