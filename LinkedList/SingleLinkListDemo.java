package com.LinkedList;

public class SingleLinkListDemo {

	public static void main(String[] args) {
		// �������
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "����", "�Ƕ���");
		HeroNode hero3 = new HeroNode(3, "�ֳ�", "����ͷ");
		HeroNode hero4 = new HeroNode(4, "����", "������");

		// ����һ������
		SingleLinkList singleLinkedList = new SingleLinkList();

		// ����
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		singleLinkedList.add(hero4);

		// ��ʾ
		singleLinkedList.list();
	}
}

// ����SingleLinkedList ����Ӣ��
class SingleLinkList {
	// �ȳ�ʼ��һ��ͷ��㣬ͷ��㲻�ܶ�,����ž��������
	private HeroNode head = new HeroNode(0, "", "");

	// ��ӽ�㵽��������
	// ˼·���������Ǳ�ŵ�˳��ʱ
	// 1.�ҵ���ǰ����������
	// 2.������������ next ָ���µĽ��
	public void add(HeroNode heroNode) {
		// ��Ϊhead��㲻�ܶ�������������Ҫһ����������temp
		HeroNode temp = head;
		// ���������ҵ����
		while (true) {
			// ����������
			if (temp.next == null) {
				break;
			}
			// ���û���ҵ�����temp����һλ
			temp = temp.next;
		}
		// ���Ƴ�whileѭ��ʱ��temp��ֻ������������
		// ������������next ָ�� �µĽ��
		temp.next = heroNode;
	}

	// ��ʾ����������
	public void list() {
		// �ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��~");
			return;
		}
		// ��Ϊͷ��㲻�ܶ������������Ҫһ����������������
		HeroNode temp = head.next;
		while (true) {
			// �ж��Ƿ��������
			if (temp == null) {
				break;
			}
			// ���������Ϣ
			System.out.println(temp);
			// ��temp����һλ;
			temp = temp.next;
		}
	}
}

// �ȶ���һ��HeroNode��ÿ��HeroNode ������һ�����
class HeroNode {
	public int id;
	public String name;
	public String nickname;
	public HeroNode next;// ָ����һ�����

	// ������
	public HeroNode(int id, String name, String nickname) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
	}

	// Ϊ����ʾ���㣬��дһ��toString
	@Override
	public String toString() {
		return "HeroNode [id=" + id + ", name=" + name + ", nickname=" + nickname + "]";
	}
}