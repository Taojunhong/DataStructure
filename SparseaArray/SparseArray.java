package com.SparseaArray;

public class SparseArray {

	public static void main(String[] args) {
		// ����һ��ԭʼ�Ķ�ά����11*11
		// 0 ��ʾû������ 1��ʾ���� 2��ʾ����
		int chessArr1[][] = new int[11][11];
		chessArr1[0][3] = 4;
		chessArr1[1][4] = 5;
		chessArr1[2][5] = 6;
		chessArr1[3][6] = 7;
		chessArr1[2][7] = 8;

		// ���ԭʼ�Ķ�ά����
		for (int[] row : chessArr1) {// ������ȡһά����
			for (int data : row) {// ������������ڵ�Ԫ��
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// ����ά���� ת�� ϡ������
		// 1.�ȱ�����ά���� �õ���0���ݵĸ���
		int num = 0;
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				if (chessArr1[i][j] != 0) {
					num++;
				}
			}
		}
		System.out.println("num=" + num);// �õ���0���ĸ���
		// 2.������Ӧ��ϡ������
		int sparseArr[][] = new int[num + 1][3];
		// ��ϡ�����鸳ֵ
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = num;

		// ������ά���飬����0��ֵ��ŵ�sparseArr��
		int count = 0;
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				if (chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}

		// ���ϡ���������ʽ��

		System.out.println();
		System.out.println("��ά����  ת  ϡ�����飺");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
		System.out.println();

		// ��ϡ������ -->�ָ��� ԭʼ�Ķ�ά����
		/*
		 * 1.�ȶ�ȡϡ������ĵ�һ�У� ������һ�е����ݣ���������ԭʼ��chessArr1��ά���飬
		 * 2.�ڶ�ȡϡ��������е����ݣ�������ԭʼ�Ķ�ά���� ���ɡ�
		 */

		// �ȶ�ȡϡ������ĵ�һ�У� ������һ�е����ݣ���������ԭʼ��chessArr1��ά����

		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

		// 2.�ڶ�ȡϡ������ڶ��е����ݣ�������ԭʼ�Ķ�ά���� ���ɡ�

		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		// ����ָ���Ķ�ά���飺

		System.out.println("ϡ������  ת  ��ά���飺");
		for (int[] row : chessArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}

}
