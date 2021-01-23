package com.javer.drink.app.project.file.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Service
@RequestScope
public class ParserService implements Serializable {

    public List<DrinkAPI> parseFile(File json) {
        List<DrinkAPI> outputObject = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            outputObject = objectMapper.readValue(jsonNode.get("drinks").toString(), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputObject;
    }
}
