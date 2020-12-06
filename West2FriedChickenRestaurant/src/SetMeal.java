
public class SetMeal {
	private String name;//套餐名
	private double price;//价格
	private String friedChicken;//炸鸡名
	private Drinks drinks;//饮料

	public SetMeal(String name, double price, String friedChicken, Drinks drinks) {
		this.name = name;
		this.price = price;
		this.friedChicken = friedChicken;
		this.drinks = drinks;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getFriedChicken() {
		return friedChicken;
	}


	public void setFriedChicken(String friedChicken) {
		this.friedChicken = friedChicken;
	}


	public Drinks getDrinks() {
		return drinks;
	}


	public void setDrinks(Drinks drinks) {
		this.drinks = drinks;
	}


	public String toString() {//覆写toString
		return "SetMealName: " + name + 
				" Price: " + price + 
				" FriedChicken: " + friedChicken + 
				" Drinks: "+ drinks.getName();
	}

}
