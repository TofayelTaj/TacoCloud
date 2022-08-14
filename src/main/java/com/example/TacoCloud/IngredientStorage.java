package com.example.TacoCloud;

import com.example.TacoCloud.DomanObject.Ingredient;

import java.util.List;

public class IngredientStorage {


    private static List<Ingredient> allIngredients = List.of(

            new Ingredient(1, "1st ingredient", Ingredient.Type.CHEESE),
            new Ingredient(2, "2nd ingredient", Ingredient.Type.PROTEIN),
            new Ingredient(3, "3rd ingredient", Ingredient.Type.CHEESE),
            new Ingredient(4, "4th ingredient", Ingredient.Type.VEGGIES),
            new Ingredient(5, "5th ingredient", Ingredient.Type.PROTEIN),
            new Ingredient(6, "6th ingredient", Ingredient.Type.CHEESE),
            new Ingredient(7, "7th ingredient", Ingredient.Type.SAUCE),
            new Ingredient(8, "8th ingredient", Ingredient.Type.SAUCE)
    );

    public static List<Ingredient> getAllIngredients(){
        return allIngredients;
    }


}
