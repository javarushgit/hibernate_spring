package org.example.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ToHexConverter implements Converter<Integer, String> {
    @Override
    public String convert(Integer number) {
        return Integer.toHexString(number);
    }
}
