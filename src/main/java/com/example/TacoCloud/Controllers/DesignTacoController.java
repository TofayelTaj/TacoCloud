package com.example.TacoCloud.Controllers;

import com.example.TacoCloud.DomanObject.Ingredient;
import com.example.TacoCloud.DomanObject.Taco;
import com.example.TacoCloud.IngredientStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.TacoCloud.DomanObject.Ingredient.Type;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(value = "/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {

        Type[] types = Ingredient.Type.values();
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient(1, "1st ingredient", Ingredient.Type.CHEESE),
                new Ingredient(2, "2nd ingredient", Ingredient.Type.PROTEIN),
                new Ingredient(3, "3rd ingredient", Ingredient.Type.CHEESE),
                new Ingredient(4, "4th ingredient", Ingredient.Type.VEGGIES),
                new Ingredient(5, "5th ingredient", Ingredient.Type.PROTEIN),
                new Ingredient(6, "6th ingredient", Ingredient.Type.CHEESE),
                new Ingredient(7, "7th ingredient", Ingredient.Type.SAUCE),
                new Ingredient(8, "8th ingredient", Ingredient.Type.SAUCE)
        );

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());

        return "design";
    }


    @GetMapping(value = "/ingredients", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Ingredient>> allIngredients(){
        List<Ingredient> allIngredients = IngredientStorage.getAllIngredients();
        for(Ingredient ingredient : allIngredients){
            ingredient.add(Link.of("www.google.com"));
        }
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }


    @PostMapping
    public String processDesign(@Valid  Taco taco) {
        log.info("My selected taco : " + taco.toString());
        return "redirect:/order/current";
    }


    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        List<Ingredient> list = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            {
                if (ingredient.getType().equals(type)) {
                    list.add(ingredient);
                }
            }
        }
        return list;
    }
}