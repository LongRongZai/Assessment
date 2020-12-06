
import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入格式为: 目标数字 循环的最大边界 线程数 例：9 1000000000 10");
		int x = sc.nextInt();// 目标数字
		long n = sc.nextLong();// 循环的最大边界
		int threads = sc.nextInt();// 线程数
		long left = 1;// 左边界（默认为1）
		long sum = 0;// 求和
		ForThread[] forThreads = new ForThread[threads];// 创建线程数组
		// 将循环平均分块给每一个线程
		for (int i = 0; i < threads; i++) {
			forThreads[i] = new ForThread(left, n * (i + 1) / threads - 1, x);
			left = n * (i + 1) / threads;
			forThreads[i].start();

		}
		// 确保每一个线程完成求和并将每个线程的计算结果相加得到最后的答案
		for (int i = 0; i < threads; i++) {
			try {
				forThreads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sum += forThreads[i].getSum();
		}
		System.out.println(sum);
	}

}
