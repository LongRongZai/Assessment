
public class ForThread extends Thread {
	private long left;//左边界
	private long right;//右边界
	private int x;//目标数字
	private long sum = 0;// 和

	public ForThread(long left, long right, int x) {
		super();
		this.left = left;
		this.right = right;
		this.x = x;
	}

	public long getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public long getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void run() {
		for (long i = left; i <= right; i++) {
			if (contain(i))
				this.sum += i;
		}
	}

	private boolean contain(long num) {
		return String.valueOf(num).contains(String.valueOf(x));
	}
}
