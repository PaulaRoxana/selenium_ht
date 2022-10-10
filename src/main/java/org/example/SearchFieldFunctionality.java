package org.example;

import org.openqa.selenium.By;

public class SearchFieldFunctionality {

    public static final By searchField = By.id("twotabsearchtextbox");
    public static final String impossibleToFindEvenOnAmazon = "ggdhtjydyfiuyoiupio[o;oi777777777777777.";

    public static final By noResultsElement = By.xpath("//span[text()='No results for '] ");

    public static final String noResultsVisibleText = "No results for";

    public static final String typeOfProductToBeFound = "laptop";

    public static final By resultForProductToBeFound = By.xpath("//span[text()='\"laptop\"']");

    public static final By foundResults = By.xpath("//a/span[contains(text(), 'Laptop') and contains(text(), 'Windows')]");

}
