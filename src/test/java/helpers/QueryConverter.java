package helpers;

import io.qameta.allure.Step;

import static java.lang.System.getProperty;

public class QueryConverter {

    @Step("Convert queryName from file in API request form.")
    public String getQuery(String queryName) {
        String[] parts = getProperty(queryName).split(" ");
        String finalQuery = "";
        for (String part : parts)
            finalQuery = finalQuery + "+" + part;
        return finalQuery.substring(1);
    }
}