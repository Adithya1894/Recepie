package com.recepie.recepie.bootstrap;

import com.recepie.recepie.domain.Category;
import com.recepie.recepie.domain.Recepie;
import com.recepie.recepie.domain.UnitOfMeasure;
import com.recepie.recepie.domain.Difficulty;
import com.recepie.recepie.domain.Notes;
import com.recepie.recepie.domain.Ingredient;
import com.recepie.recepie.repositories.CategoryRepository;
import com.recepie.recepie.repositories.RecepieRepository;
import com.recepie.recepie.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@Component
public class RecepieBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    //@Autowired
    private final CategoryRepository categoryRepository;
    private final RecepieRepository recepieRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecepieBootstrap(CategoryRepository categoryRepository, RecepieRepository recepieRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recepieRepository = recepieRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recepieRepository.saveAll(getRecipes());
    }


    private List<Recepie> getRecipes(){


        List<Recepie> recepies = new ArrayList<>(3);


        Optional<UnitOfMeasure> eachUom = unitOfMeasureRepository.findByDescription("Each");

        //UOM is Unit of Measure
        if(!eachUom.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");


        if(!teaspoon.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }


        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");


        if(!tablespoon.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");

        if(!tablespoon.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }


        Optional<UnitOfMeasure> pinch = unitOfMeasureRepository.findByDescription("Pinch");

        if(!pinch.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> ounce = unitOfMeasureRepository.findByDescription("Ounce");


        if(!ounce.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }


        //getting the optianl values.
        //if a value is present in this optional, returns that value, otherwise throws noSuchElementException
        UnitOfMeasure eachUom1 = eachUom.get();

        UnitOfMeasure teaspoon1 = teaspoon.get();

        UnitOfMeasure tableSpoon1 = tablespoon.get();

        UnitOfMeasure cup1 = cup.get();

        UnitOfMeasure pinch1 = pinch.get();

        UnitOfMeasure ounce1 = ounce.get();

        //getting the categories of food from the database

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }



        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }

        //getting the optional categories if present
        Category american = americanCategoryOptional.get();
        Category mexican  = mexicanCategoryOptional.get();

        Recepie guacRecipe = new Recepie();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        Notes guacNotes = new Notes();
        guacNotes.setRecepieNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        guacNotes.setRecepie(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom1, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoon1, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoon1, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoon1, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom1, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), tableSpoon1, guacRecipe));
        //guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom1, guacRecipe));

        guacRecipe.getCategories().add(american);
        guacRecipe.getCategories().add(mexican);

        //add to return list
        recepies.add(guacRecipe);

        //Yummy Tacos
        Recepie tacosRecipe = new Recepie();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecepieNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacoNotes.setRecepie(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);

        //Adding the ingredients for the recepie
        tacosRecipe.getIngredients().add(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tableSpoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Sugar", new BigDecimal(1), teaspoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Salt", new BigDecimal(".5"), teaspoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), eachUom1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Olive Oil", new BigDecimal(2), tableSpoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("boneless chicken thighs", new BigDecimal(4), tableSpoon1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("small corn tortillasr", new BigDecimal(8), eachUom1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("packed baby arugula", new BigDecimal(3), cup1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), eachUom1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom1, tacosRecipe));
        //tacosRecipe.getIngredients().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pintUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), eachUom1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), eachUom1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cup1, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachUom1, tacosRecipe));

        tacosRecipe.getCategories().add(american);
        tacosRecipe.getCategories().add(mexican);

        recepies.add(tacosRecipe);


        return recepies;
    }
}
