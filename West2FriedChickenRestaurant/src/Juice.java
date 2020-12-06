import java.time.LocalDate;

public class Juice extends Drinks {
	

	public Juice() {
		super();
	}
	public Juice(String name, double cost, LocalDate productionDate, long shelfLife) {
		super(name, cost, productionDate, shelfLife);
		
	}
	public Juice(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Juice [name=" + name + ", cost=" + cost + ", productionDate=" + productionDate + ", shelfLife="
				+ shelfLife + "]";
	}
	
	

}
