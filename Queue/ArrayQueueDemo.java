package com.Queue;

import java.util.Scanner;

//Ŀǰ����ʹ��һ�ξͲ������ˣ�û�дﵽ���õ�Ч��
//�Ż�����ʹ���㷨���Ľ���һ�����εĶ���  ����ȡģ�ķ�ʽ---

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// ����
		// ����һ������
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' ';// �����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		// ���һ���˵�
		while (loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):�������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			System.out.println();
			key = scanner.next().charAt(0);// ����һ���ַ�
			switch (key) {
			case 's':
				queue.showQueue();
				System.out.println("------------------------");
				break;
			case 'a':
				System.out.println("����һ������");
				int value = scanner.nextInt();
				queue.addQueue(value);
				System.out.println("------------------------");
				break;
			case 'g':// ȡ������
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
					System.out.println("------------------------");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// �鿴����ͷ������
				try {
					int res = queue.headQueue();
					System.out.printf("����ͷ��������%d\n", res);
					System.out.println("------------------------");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':// �˳�
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}

		System.out.println("�����˳�����");
	}

}

// ʹ������ģ�����--��дArrayQueue��
class ArrayQueue {
	private int maxSize;// ��ʾ������������
	private int front;// ����ͷ
	private int rear;// ����β
	private int[] arr;// ���������ڴ�����ݣ�ģ�����

	// �������еĹ�����
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}

	// �ж϶����Ƿ���
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// �������ݵ�����
	public void addQueue(int n) {
		// �ж϶����Ƿ���
		if (isFull()) {
			System.out.println("�������������ܼ�������");
			return;
		}
		rear++;// rear����
		arr[rear] = n;
	}

	// ��ȡ���е����ݣ�������
	public int getQueue() {
		// �ж������Ƿ�Ϊ��
		if (isEmpty()) {
			// ͨ���׳��쳣������
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		front++;// front ����
		return arr[front];
	}

	// ��ʾ���е���������
	public void showQueue() {
		// ����
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�û�����ݣ�");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// ��ʾ���е������ݣ�ע�ⲻ��ȡ������
	public int headQueue() {
		// �ж�
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�û�ж���ͷ����");
		}
		return arr[front + 1];
	}

}