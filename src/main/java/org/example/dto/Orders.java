package org.example.dto;

import lombok.Data;

import java.util.Map;

@Data
public class Orders {
    private Map<String, String> orders;
}
