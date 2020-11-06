package com.Queue;

import java.util.Scanner;

public class CircleArrayQueue {

	public static void main(String[] args) {
		System.out.println("������Ҫ�������ݵĸ�����");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt() + 1;
		CircleQueue circleQueue = new CircleQueue(num);// ����һ�������������
		char key = ' ';
		boolean loop = true;
		while (loop) {// ѭ������
			System.out.println("s(show):��ʾ����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			System.out.println("e(exit):�˳�����");
			System.out.println();
			System.out.println("���������ѡ��");
			key = scanner.next().charAt(0);// ����һ���ַ�
			switch (key) {
			case 's':// ��ʾ����
				circleQueue.showQueue();
				System.out.println("~~~~~~~~~~~~~~~~~~~");
				break;
			case 'a':// ������ݵ�����
				System.out.println("�����һ������");
				int value = scanner.nextInt();
				circleQueue.addQueue(value);
				System.out.println("~~~~~~~~~~~~~~~~~~~");
				break;
			case 'g':// �Ӷ���ȡ������
				try {
					int res = circleQueue.getQueue();
					System.out.printf("%d:������ȡ��\n", res);
					System.out.println("~~~~~~~~~~~~~~~~~~~");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// �鿴����ͷ������
				try {
					int res = circleQueue.headQueue();
					System.out.printf("ͷ�����ݣ�%d\n", res);
					System.out.println("~~~~~~~~~~~~~~~~~~~");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':// �˳�����
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�������˳�~");

	}

}

class CircleQueue {
	// front ���巢���ı䣺frontָ����еĵ�һ��Ԫ�أ�front��ʼֵ=0��
	// rear ���巢���ı䣺rearָ��������һ��Ԫ�صĺ�һ��λ�ã�
	// ����maxSize=4,��rear=3ʱ��(rear+1)%maxSize==front=0,�������ȥ��
	// rear��ʼֵ=0��
	private int maxSize;// ��ʾ������������
	private int front;// ����ͷ
	private int rear;// ����β
	private int[] arr;// ���������ڴ�����ݣ�ģ�����

	// ������
	public CircleQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		// front,rear��ʼ��Ĭ��Ϊ0�����Բ�д
	}

	// �ж��Ƿ���
	public boolean isFull() {
		return (rear + 1) % maxSize == front;// ����maxSize=4,��rear=3ʱ��(rear+1)%maxSize==front=0,�������ȥ��
	}

	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// �������
	public void addQueue(int n) {
		// �ж϶����Ƿ���
		if (isFull()) {
			System.out.println("�������������ܼ�������");
			return;
		}
		// ��Ϊrear������ָ��������Ԫ�صĺ�һλ�����ԾͿ���ֱ��д
		arr[rear] = n;
		// ��rear����һλ����������뿼��ȡģ
		rear = (rear + 1) % maxSize;
		System.out.println("��ӳɹ�~");
	}

	// ȡ������
	public int getQueue() {
		if (isEmpty()) {// �ж��Ƿ�Ϊ��
			throw new RuntimeException("���пգ�ȡ��������~");
		}
		// front++;
		// return arr[front];
		// ��Ϊfront��ָ����еĵ�һ��Ԫ�أ����ֱ�ӷ���arr[front],
		// ��ʹfrontû�к���һλ�Ļ��ᣬ���Բ������£�
		// 1.�Ƚ�front��Ӧ��ֵ������һ����ʱ������
		// 2.�ٽ�front ����һλ��ͬʱ����ȡģ
		// 3.����ʱ����ı�������
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// ��ʾ���е���������
	public void showQueue() {
		// �ж�һ���Ƿ�Ϊ��
		if (isEmpty()) {
			System.out.println("���пգ�ɶ��û��~");
			return;
		}
		// �������
		for (int i = front; i < front + size(); i++) {//2+3=5
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	// ȡģ������ĳ���
	public int size() {
		return (rear + maxSize - front) % maxSize;//(5+8-2)%8=3
	}

	// ��ʾ���е�ͷԪ��
	public int headQueue() {// ��ʾ��ǰ����ͷ������
		if (isEmpty()) {
			throw new RuntimeException("���пգ�ɶ��û��~");
		}
		return arr[front];
	}
}
