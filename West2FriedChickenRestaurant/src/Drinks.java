import java.time.LocalDate;

public abstract class Drinks {
	protected String name;//饮料名
	protected double cost;//成本
	protected LocalDate productionDate;//生产日期
	protected long shelfLife;//保质期
	
	public Drinks() {


	}
	public Drinks(String name, double cost, LocalDate productionDate, long shelfLife) {
		this.name = name;
		this.cost = cost;
		this.productionDate=productionDate;
		this.shelfLife = shelfLife;

	}
	public Drinks(String name){//用于接收套餐中饮料的构造参数
		this.name = name;
		cost = '0';
		productionDate=LocalDate.parse("2000-01-01");
		shelfLife = '0';
	}

	public LocalDate getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public long getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}
	public abstract String toString();//抽象的toString方法
	
	public boolean isExpired() {//判断是否过期
		return LocalDate.now().isAfter(productionDate.plusDays(shelfLife));
	}

	

}
