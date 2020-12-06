import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
	static {//使用静态代码块在创建类时生成菜单
		List<SetMeal> setMealList = new ArrayList<SetMeal>(6);
		setMealList.add(new SetMeal("SetMeal 1", 30, "Fried Chicken", new Juice("Apple juice")));
		setMealList.add(new SetMeal("SetMeal 2", 30, "Fried Chicken", new Juice("Orange juice")));
		setMealList.add(new SetMeal("SetMeal 3", 30, "Fried Chicken", new Juice("Watermelon juice")));
		setMealList.add(new SetMeal("SetMeal 4", 35, "Fried Chicken", new Beer("QingDao beer")));
		setMealList.add(new SetMeal("SetMeal 5", 35, "Fried Chicken", new Beer("BaiWei beer")));
		setMealList.add(new SetMeal("SetMeal 6", 35, "Fried Chicken", new Beer("XueJin beer")));
		System.out.println("----------------------------------------------------------------------------------");
		for(SetMeal setMeal:setMealList) {//打印菜单
			System.out.println(setMeal.toString());
		}
		System.out.println("----------------------------------------------------------------------------------");

	}
	private double balance;//余额
	private List<Drinks> juiceList;//果汁列表
	private List<Drinks> beerList;//啤酒列表

	public West2FriedChickenRestaurant(double balance) {

		this.balance = balance;
		juiceList = new ArrayList<Drinks>();//选择arrayList是因为它在查询方面效率更高
		beerList = new ArrayList<Drinks>();

	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Drinks> getJuiceList() {
		return juiceList;
	}

	public void setJuiceList(List<Drinks> juiceList) {
		this.juiceList = juiceList;
	}

	public List<Drinks> getBeerList() {
		return beerList;
	}

	public void setBeerList(List<Drinks> beerList) {
		this.beerList = beerList;
	}
	//出售套餐
	public void sell(SetMeal setMeal) {
		balance += setMeal.getPrice();

		if (setMeal.getDrinks() instanceof Juice) {
			use((Juice) (setMeal.getDrinks()));
		} else {
			use((Beer) (setMeal.getDrinks()));
		}

	}
	//进货
	public void purchase(Drinks drinks, int num) {//饮料类型和数量
		if(balance-drinks.getCost()*num<0)//如果余额不足
			//抛出OverdraftBalanceException
			throw new OverdraftBalanceException("Insufficient balance and you need extra "+(drinks.getCost()*num-balance)+" to complete purchase" );
		balance-=drinks.getCost()*num;//余额足够则扣款
		if (drinks instanceof Juice) {//判断时啤酒还是果汁
			for (int i = 0; i < num; i++) {
				juiceList.add(drinks);			
			}
		} else {
			for (int i = 0; i < num; i++) {
				beerList.add(drinks);
			}

		}
	}
	//移除对应果汁
	private void use(Juice juice) {
		for (int i = juiceList.size() - 1; i >= 0; i--) {//对果汁列表进行遍历
			if (juiceList.get(i).isExpired()) {//如果过期
				juiceList.remove(i);
			}else if(juiceList.get(i).getName() == juice.getName()) {//如果列表存在该果汁
				juiceList.remove(i);
				return;
			}

		}
		//如果列表中无该果汁则抛出IngredientSortOutException
		throw new IngredientSortOutException("The " + juice.getName() + " has sold out");

	}
	//移除对应啤酒
	private void use(Beer beer) {
		for (int i = beerList.size() - 1; i >= 0; i--) {
			if (beerList.get(i).isExpired()) {
				beerList.remove(i);
			}else if(beerList.get(i).getName() == beer.getName()) {
				beerList.remove(i);
				return;
			}

		}
		throw new IngredientSortOutException("The " + beer.getName() + " has sold out");

	}

}
