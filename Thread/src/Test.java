
import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����ʽΪ: Ŀ������ ѭ�������߽� �߳��� ����9 1000000000 10");
		int x = sc.nextInt();// Ŀ������
		long n = sc.nextLong();// ѭ�������߽�
		int threads = sc.nextInt();// �߳���
		long left = 1;// ��߽磨Ĭ��Ϊ1��
		long sum = 0;// ���
		ForThread[] forThreads = new ForThread[threads];// �����߳�����
		// ��ѭ��ƽ���ֿ��ÿһ���߳�
		for (int i = 0; i < threads; i++) {
			forThreads[i] = new ForThread(left, n * (i + 1) / threads - 1, x);
			left = n * (i + 1) / threads;
			forThreads[i].start();

		}
		// ȷ��ÿһ���߳������Ͳ���ÿ���̵߳ļ�������ӵõ����Ĵ�
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
