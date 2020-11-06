package com.Queue;

import java.util.Scanner;

public class CircleArrayQueue {

	public static void main(String[] args) {
		System.out.println("请输入要创建数据的个数：");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt() + 1;
		CircleQueue circleQueue = new CircleQueue(num);// 创建一个环形数组队列
		char key = ' ';
		boolean loop = true;
		while (loop) {// 循环操作
			System.out.println("s(show):显示队列");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			System.out.println("e(exit):退出程序");
			System.out.println();
			System.out.println("请输入你的选择：");
			key = scanner.next().charAt(0);// 接收一个字符
			switch (key) {
			case 's':// 显示队列
				circleQueue.showQueue();
				System.out.println("~~~~~~~~~~~~~~~~~~~");
				break;
			case 'a':// 添加数据到队列
				System.out.println("请添加一个数：");
				int value = scanner.nextInt();
				circleQueue.addQueue(value);
				System.out.println("~~~~~~~~~~~~~~~~~~~");
				break;
			case 'g':// 从队列取出数据
				try {
					int res = circleQueue.getQueue();
					System.out.printf("%d:数据已取出\n", res);
					System.out.println("~~~~~~~~~~~~~~~~~~~");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// 查看队列头的数据
				try {
					int res = circleQueue.headQueue();
					System.out.printf("头部数据：%d\n", res);
					System.out.println("~~~~~~~~~~~~~~~~~~~");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':// 退出程序
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序已退出~");

	}

}

class CircleQueue {
	// front 含义发生改变：front指向队列的第一个元素，front初始值=0；
	// rear 含义发生改变：rear指向队列最后一个元素的后一个位置，
	// 例：maxSize=4,当rear=3时，(rear+1)%maxSize==front=0,所以填不进去了
	// rear初始值=0；
	private int maxSize;// 表示数组的最大容量
	private int front;// 队列头
	private int rear;// 队列尾
	private int[] arr;// 该数组用于存放数据，模拟队列

	// 构造器
	public CircleQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		// front,rear初始化默认为0，可以不写
	}

	// 判断是否满
	public boolean isFull() {
		return (rear + 1) % maxSize == front;// 例：maxSize=4,当rear=3时，(rear+1)%maxSize==front=0,所以填不进去了
	}

	// 判断是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 添加数据
	public void addQueue(int n) {
		// 判断队列是否满
		if (isFull()) {
			System.out.println("队列已满，不能加入数据");
			return;
		}
		// 因为rear本就是指向队列最后元素的后一位，所以就可以直接写
		arr[rear] = n;
		// 将rear后移一位，但这里必须考虑取模
		rear = (rear + 1) % maxSize;
		System.out.println("添加成功~");
	}

	// 取出数据
	public int getQueue() {
		if (isEmpty()) {// 判断是否为空
			throw new RuntimeException("队列空，取不出数据~");
		}
		// front++;
		// return arr[front];
		// 因为front是指向队列的第一个元素，如果直接返回arr[front],
		// 就使front没有后移一位的机会，所以操作如下：
		// 1.先将front对应的值保留到一个临时变量上
		// 2.再将front 后移一位，同时考虑取模
		// 3.将临时保存的变量返回
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// 显示队列的所有数据
	public void showQueue() {
		// 判断一下是否为空
		if (isEmpty()) {
			System.out.println("队列空，啥都没有~");
			return;
		}
		// 遍历输出
		for (int i = front; i < front + size(); i++) {//2+3=5
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	// 取模求便利的长度
	public int size() {
		return (rear + maxSize - front) % maxSize;//(5+8-2)%8=3
	}

	// 显示队列的头元素
	public int headQueue() {// 显示当前队列头的数据
		if (isEmpty()) {
			throw new RuntimeException("队列空，啥都没有~");
		}
		return arr[front];
	}
}
