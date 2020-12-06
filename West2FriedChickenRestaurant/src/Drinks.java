import java.time.LocalDate;

public abstract class Drinks {
	protected String name;//������
	protected double cost;//�ɱ�
	protected LocalDate productionDate;//��������
	protected long shelfLife;//������
	
	public Drinks() {


	}
	public Drinks(String name, double cost, LocalDate productionDate, long shelfLife) {
		this.name = name;
		this.cost = cost;
		this.productionDate=productionDate;
		this.shelfLife = shelfLife;

	}
	public Drinks(String name){//���ڽ����ײ������ϵĹ������
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
	public abstract String toString();//�����toString����
	
	public boolean isExpired() {//�ж��Ƿ����
		return LocalDate.now().isAfter(productionDate.plusDays(shelfLife));
	}

	

}
