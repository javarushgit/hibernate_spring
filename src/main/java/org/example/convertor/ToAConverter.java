package org.example.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToAConverter implements Converter<Integer, String> {
    @Override
    public String convert(Integer number) {
        return "hello";
    }
}

