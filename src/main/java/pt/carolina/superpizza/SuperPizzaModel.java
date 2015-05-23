package pt.carolina.superpizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SuperPizzaModel {
	
	public final static String SMALL = "Small";
	public final static String MEDIUM = "Medium";
	public final static String BIG = "Big";
	public final static String SAUCE = "Sauce";
	public final static String INGREDIENT = "Ingredient";

	private String pizzaSize = "none";
	private String sauce = null;
	private List<String> ingredients = new ArrayList<String>();
	private HashMap<String, Integer> pricePlan = new HashMap<String, Integer>();
	
	public SuperPizzaModel() {
		pricePlan.put(SMALL, 5);
		pricePlan.put(MEDIUM, 10);
		pricePlan.put(BIG, 15);
		pricePlan.put(INGREDIENT, 1);
		pricePlan.put(SAUCE, 2);
	}
	
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public String getSauce() {
		return sauce;
	}
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	public String getPizzaSizeName(){
		return "Pizza Size: " + pizzaSize;
	}
	
	public String getIngredientsName() {
		StringBuffer ing = new StringBuffer("Ingredients: ");
		for (String ingredient : ingredients) {
			ing.append(ingredient).append(", ");
		}
		if(ingredients.isEmpty()){
			return ing.toString();
		}else{
			return ing.substring(0, ing.lastIndexOf(",") - 1) ;
		}
	}
	
	public String getSauceName() {
		return "Sauce: " + sauce;
	}
	
	public String getPrice(){
		Integer total = 0;
		total += pricePlan.get(getPizzaSize());
		total += pricePlan.get(INGREDIENT) * getIngredients().size();
		total += pricePlan.get(SAUCE);
		return total + " €";
	}
}
