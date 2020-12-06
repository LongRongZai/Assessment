import java.time.LocalDate;

public class Test {
	public static void main(String args[]) {
		FriedChickenRestaurant test = new West2FriedChickenRestaurant(100);
		//≤‚ ‘Ω¯ªı
		test.purchase(new Juice("Apple juice", 10, LocalDate.parse("2020-11-20"), 30), 1);
		test.purchase(new Juice("Apple juice", 10, LocalDate.parse("2020-09-20"), 30), 2);
		//≤‚ ‘OverdraftBalanceException
		try {
			test.purchase(new Juice("Orange juice", 10, LocalDate.parse("2020-09-20"), 30), 10);
		} catch (OverdraftBalanceException e) {
			e.printStackTrace();
		}
		//≤‚ ‘≥ˆ €
		test.sell(new SetMeal("SetMeal 1", 30, "Fried Chicken", new Juice("Apple juice")));
		//≤‚ ‘IngredientSortOutException
		try {
			test.sell(new SetMeal("SetMeal 1", 30, "Fried Chicken", new Juice("Apple juice")));
		} catch (IngredientSortOutException e) {
			e.printStackTrace();
		}

	}

}
