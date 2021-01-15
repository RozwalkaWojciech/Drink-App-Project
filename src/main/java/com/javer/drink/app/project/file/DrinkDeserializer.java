package com.javer.drink.app.project.file;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.javer.drink.app.project.parser.DrinkAPI;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

@Component
@RequestScope
public class DrinkDeserializer extends JsonDeserializer<DrinkAPI> {

    @Override
    public DrinkAPI deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Map<String, String> ingredients = new HashMap<>();

        DrinkAPI drinkApi = new DrinkAPI();
        JsonNode tree = jsonParser.readValueAsTree();

        String[] errors = {"null"};

        for (int index = 1; index < 16; index++) {

            index = (char) index;

            JsonNode ingredientNode = tree.get("strIngredient" + index);

            if (ingredientNode == null) {
                break;
            }

            String trim = ingredientNode.asText().trim();

            for (String error : errors) {

                if (!trim.equals(error) && !trim.isEmpty()) {

                    ingredients.put(tree.get("strIngredient" + index).asText().trim(),
                            tree.get("strMeasure" + index).asText().trim());
                }
            }
        }

        drinkApi.setId(tree.get("idDrink").asLong());
        drinkApi.setName(tree.get("strDrink").asText());
        drinkApi.setRecipe(tree.get("strInstructions").asText());
        drinkApi.setCategory(tree.get("strCategory").asText());
        drinkApi.setDrinkType(tree.get("strAlcoholic").asText());
        drinkApi.setGlassType(tree.get("strGlass").asText());
        if ((tree.get("dateModified")).isNull()) {
            String datePattern = getNewDatePattern();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            drinkApi.setModificationDate(LocalDateTime.now().format(formatter));
        } else {
            drinkApi.setModificationDate(tree.get("dateModified").asText());
        }
        drinkApi.setImageUrl(tree.get("strDrinkThumb").asText());
        drinkApi.setIngredients(ingredients);
        return drinkApi;
    }

    private String getNewDatePattern() throws IOException {
        Properties settings = new Properties();
        settings.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("settings.properties")).openStream());
        String dateFormat = settings.getProperty("date.format");
        return dateFormat;
    }
}
