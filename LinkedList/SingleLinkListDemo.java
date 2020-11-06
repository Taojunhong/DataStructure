package com.LinkedList;

public class SingleLinkListDemo {

	public static void main(String[] args) {
		// 创建结点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "吴用", "智多星");
		HeroNode hero3 = new HeroNode(3, "林冲", "豹子头");
		HeroNode hero4 = new HeroNode(4, "李逵", "黑旋风");

		// 创建一个链表
		SingleLinkList singleLinkedList = new SingleLinkList();

		// 加入
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		singleLinkedList.add(hero4);

		// 显示
		singleLinkedList.list();
	}
}

// 定义SingleLinkedList 管理英雄
class SingleLinkList {
	// 先初始化一个头结点，头结点不能动,不存放具体的数据
	private HeroNode head = new HeroNode(0, "", "");

	// 添加结点到单向链表
	// 思路：当不考虑编号的顺序时
	// 1.找到当前链表的最后结点
	// 2.将最后这个结点的 next 指向新的结点
	public void add(HeroNode heroNode) {
		// 因为head结点不能动，所以我们需要一个辅助遍历temp
		HeroNode temp = head;
		// 遍历链表，找到最后
		while (true) {
			// 找链表的最后
			if (temp.next == null) {
				break;
			}
			// 如果没有找到，将temp后移一位
			temp = temp.next;
		}
		// 当推出while循环时，temp就只想了链表的最后
		// 将最后这个结点的next 指向 新的结点
		temp.next = heroNode;
	}

	// 显示链表（遍历）
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空~");
			return;
		}
		// 因为头结点不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			}
			// 输出结点的信息
			System.out.println(temp);
			// 将temp后移一位;
			temp = temp.next;
		}
	}
}

// 先定义一个HeroNode，每个HeroNode 对象是一个结点
class HeroNode {
	public int id;
	public String name;
	public String nickname;
	public HeroNode next;// 指向下一个结点

	// 构造器
	public HeroNode(int id, String name, String nickname) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
	}

	// 为了显示方便，重写一下toString
	@Override
	public String toString() {
		return "HeroNode [id=" + id + ", name=" + name + ", nickname=" + nickname + "]";
	}
}