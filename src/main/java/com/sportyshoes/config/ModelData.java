package com.sportyshoes.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ModelData {

    @ModelAttribute("genders")
    public List<String> genders() {
        return Arrays.asList("Male", "Female", "Kids");
    }

    @ModelAttribute("suitableFor")
    public List<String> suitableFor() {
        return Arrays.asList("Men", "Women", "Kids");
    }

    @ModelAttribute("colors")
    public List<String> colors() {
        return Arrays.asList("White", "Red", "Yellow");
    }

    @ModelAttribute("styles")
    public List<String> styles() {
        return Arrays.asList("cricket-126", "basketball-125");
    }

    @ModelAttribute("brands")
    public List<String> brands() {
        return Arrays.asList("Adidas", "Nike", "Puma", "Reebok");
    }

    @ModelAttribute("states")
    public List<String> states() {
        return Arrays.asList("AP", "Karnataka", "TamilNadu", "Kerala");
    }

    @ModelAttribute("statements")
    public List<Boolean> statements() {
        return Arrays.asList(true, false);
    }

    @ModelAttribute("roles")
    public List<String> roles() {
        return Arrays.asList("ROLE_USER", "ROLE_ADMIN");
    }

    @ModelAttribute("types")
    public List<String> types() {
        return Arrays.asList("Running", "Hiking", "Workout");
    }
}
