import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
	static {//ʹ�þ�̬������ڴ�����ʱ���ɲ˵�
		List<SetMeal> setMealList = new ArrayList<SetMeal>(6);
		setMealList.add(new SetMeal("SetMeal 1", 30, "Fried Chicken", new Juice("Apple juice")));
		setMealList.add(new SetMeal("SetMeal 2", 30, "Fried Chicken", new Juice("Orange juice")));
		setMealList.add(new SetMeal("SetMeal 3", 30, "Fried Chicken", new Juice("Watermelon juice")));
		setMealList.add(new SetMeal("SetMeal 4", 35, "Fried Chicken", new Beer("QingDao beer")));
		setMealList.add(new SetMeal("SetMeal 5", 35, "Fried Chicken", new Beer("BaiWei beer")));
		setMealList.add(new SetMeal("SetMeal 6", 35, "Fried Chicken", new Beer("XueJin beer")));
		System.out.println("----------------------------------------------------------------------------------");
		for(SetMeal setMeal:setMealList) {//��ӡ�˵�
			System.out.println(setMeal.toString());
		}
		System.out.println("----------------------------------------------------------------------------------");

	}
	private double balance;//���
	private List<Drinks> juiceList;//��֭�б�
	private List<Drinks> beerList;//ơ���б�

	public West2FriedChickenRestaurant(double balance) {

		this.balance = balance;
		juiceList = new ArrayList<Drinks>();//ѡ��arrayList����Ϊ���ڲ�ѯ����Ч�ʸ���
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
	//�����ײ�
	public void sell(SetMeal setMeal) {
		balance += setMeal.getPrice();

		if (setMeal.getDrinks() instanceof Juice) {
			use((Juice) (setMeal.getDrinks()));
		} else {
			use((Beer) (setMeal.getDrinks()));
		}

	}
	//����
	public void purchase(Drinks drinks, int num) {//�������ͺ�����
		if(balance-drinks.getCost()*num<0)//�������
			//�׳�OverdraftBalanceException
			throw new OverdraftBalanceException("Insufficient balance and you need extra "+(drinks.getCost()*num-balance)+" to complete purchase" );
		balance-=drinks.getCost()*num;//����㹻��ۿ�
		if (drinks instanceof Juice) {//�ж�ʱơ�ƻ��ǹ�֭
			for (int i = 0; i < num; i++) {
				juiceList.add(drinks);			
			}
		} else {
			for (int i = 0; i < num; i++) {
				beerList.add(drinks);
			}

		}
	}
	//�Ƴ���Ӧ��֭
	private void use(Juice juice) {
		for (int i = juiceList.size() - 1; i >= 0; i--) {//�Թ�֭�б���б���
			if (juiceList.get(i).isExpired()) {//�������
				juiceList.remove(i);
			}else if(juiceList.get(i).getName() == juice.getName()) {//����б���ڸù�֭
				juiceList.remove(i);
				return;
			}

		}
		//����б����޸ù�֭���׳�IngredientSortOutException
		throw new IngredientSortOutException("The " + juice.getName() + " has sold out");

	}
	//�Ƴ���Ӧơ��
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
