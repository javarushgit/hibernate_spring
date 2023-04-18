package org.example.resourse;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.criteria.Order;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.dto.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;




@Service
public class ResourceReaderService implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Autowired
    public ResourceReaderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void readFile(String fileName) throws IOException {
        Resource resource = resourceLoader.getResource(fileName);
        File file = resource.getFile();
        Orders orders = objectMapper.readValue(file, Orders.class);
        System.out.println(orders);
    }
}
