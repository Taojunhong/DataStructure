package com.Queue;

import java.util.Scanner;

//目前数组使用一次就不能用了，没有达到服用的效果
//优化：将使用算法，改进成一个环形的队列  采用取模的方式---

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// 测试
		// 创建一个队列
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' ';// 接受用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		// 输出一个菜单
		while (loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			System.out.println();
			key = scanner.next().charAt(0);// 接受一个字符
			switch (key) {
			case 's':
				queue.showQueue();
				System.out.println("------------------------");
				break;
			case 'a':
				System.out.println("添加一个数：");
				int value = scanner.nextInt();
				queue.addQueue(value);
				System.out.println("------------------------");
				break;
			case 'g':// 取出数据
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
					System.out.println("------------------------");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// 查看队列头的数据
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是%d\n", res);
					System.out.println("------------------------");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':// 退出
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}

		System.out.println("程序退出。。");
	}

}

// 使用数组模拟队列--编写ArrayQueue类
class ArrayQueue {
	private int maxSize;// 表示数组的最大容量
	private int front;// 队列头
	private int rear;// 队列尾
	private int[] arr;// 该数组用于存放数据，模拟队列

	// 创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}

	// 判断队列是否满
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 添加数据到队列
	public void addQueue(int n) {
		// 判断队列是否满
		if (isFull()) {
			System.out.println("队列已满，不能加入数据");
			return;
		}
		rear++;// rear后移
		arr[rear] = n;
	}

	// 获取队列的数据，出队列
	public int getQueue() {
		// 判断数据是否为空
		if (isEmpty()) {
			// 通过抛出异常来处理
			throw new RuntimeException("队列为空，不能取数据");
		}
		front++;// front 后移
		return arr[front];
	}

	// 显示队列的所有数据
	public void showQueue() {
		// 遍历
		if (isEmpty()) {
			System.out.println("队列为空，没有数据！");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// 显示队列的有数据，注意不是取出数据
	public int headQueue() {
		// 判断
		if (isEmpty()) {
			throw new RuntimeException("队列为空，没有队列头数据");
		}
		return arr[front + 1];
	}

}
