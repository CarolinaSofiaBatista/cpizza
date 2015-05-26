package pt.carolina.superpizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Pizza Model
 * 
 * @author carolina
 *
 */
public class SuperPizzaModel {

	public final String SMALL = "Small";
	public final String MEDIUM = "Medium";
	public final String BIG = "Big";
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

	/**
	 * gets Pizza size
	 * @return {@link String}
	 */
	public String getPizzaSize() {
		return pizzaSize;
	}

	/**
	 * sets selected pizza size
	 * 
	 * @param pizzaSize
	 */
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	/**
	 * gets Sauce
	 * @return {@link String}
	 */
	public String getSauce() {
		return sauce;
	}

	/**
	 * sets selected Sauce 
	 * @param sauce
	 */
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	/**
	 * gets selected ingredients list
	 * @return {@link List}
	 */
	public List<String> getIngredients() {
		return ingredients;
	}

	/**
	 * sets selected ingredients {@link List}
	 * @param ingredients
	 */
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * gets pizza size name
	 * @return {@link String}
	 */
	public String getPizzaSizeName(){
		return "<html><b>Pizza Size:</b> " + pizzaSize + "</html>";
	}

	/**
	 * gets Ingredients display names
	 * @return {@link String}
	 */
	public String getIngredientsName() {
		StringBuffer ing = new StringBuffer("<html><b>Ingredients:</b> ");
		String finalText = "";
		if(ingredients.isEmpty()){
			finalText = ing.toString();
		}else{
			for (String ingredient : ingredients) {
				ing.append(ingredient).append(", ");
			}
			finalText = ing.substring(0, ing.lastIndexOf(",")) ;
		}
		return finalText + "</html>";
	}

	/**
	 * gets Sauce display name
	 * @return {@link String}
	 */
	public String getSauceName() {
		return "<html><b>Sauce:</b> " + sauce + "</html>";
	}

	/**
	 * computes pizza price based on selected options.
	 * 
	 * @return {@link String}
	 */
	public String getPrice(){
		Integer total = 0;
		total += pricePlan.get(getPizzaSize());
		total += pricePlan.get(INGREDIENT) * getIngredients().size();
		total += pricePlan.get(SAUCE);
		return "Price: " + total + "€";
	}
}
