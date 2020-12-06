import java.time.LocalDate;

public class Beer extends Drinks {
	private float alcohol;//¾Æ¾«¶ÈÊý
	 
	public Beer() {
		super();
	}


	public Beer(String name) {
		super(name);
	}


	public Beer(String name, double cost, LocalDate productionDate, long shelfLife,float alcohol) {
		super(name, cost, productionDate, shelfLife);
		this.alcohol=alcohol;

	}
	

	public float getAlcohol() {
		return alcohol;
	}


	public void setAlcohol(float alcohol) {
		this.alcohol = alcohol;
	}


	@Override
	public String toString() {
		return "Beer [alcohol=" + alcohol + ", name=" + name + ", cost=" + cost + ", productionDate=" + productionDate
				+ ", shelfLife=" + shelfLife + "]";
	}




}
