package com.SparseaArray;

public class SparseArray {

	public static void main(String[] args) {
		// 创建一个原始的二维数组11*11
		// 0 表示没有棋子 1表示黑子 2表示蓝子
		int chessArr1[][] = new int[11][11];
		chessArr1[0][3] = 4;
		chessArr1[1][4] = 5;
		chessArr1[2][5] = 6;
		chessArr1[3][6] = 7;
		chessArr1[2][7] = 8;

		// 输出原始的二维数组
		for (int[] row : chessArr1) {// 遍历获取一维数组
			for (int data : row) {// 遍历输出数组内的元素
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// 将二维数组 转成 稀疏数组
		// 1.先遍历二维数组 得到非0数据的个数
		int num = 0;
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				if (chessArr1[i][j] != 0) {
					num++;
				}
			}
		}
		System.out.println("num=" + num);// 得到非0数的个数
		// 2.创建对应的稀疏数组
		int sparseArr[][] = new int[num + 1][3];
		// 给稀疏数组赋值
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = num;

		// 遍历二维数组，将非0的值存放到sparseArr中
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

		// 输出稀疏数组的形式：

		System.out.println();
		System.out.println("二维数组  转  稀疏数组：");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
		System.out.println();

		// 将稀疏数组 -->恢复成 原始的二维数组
		/*
		 * 1.先读取稀疏数组的第一行， 根基第一行的数据，创建以上原始的chessArr1二维数组，
		 * 2.在读取稀疏数组后几行的数据，并赋给原始的二维数组 即可。
		 */

		// 先读取稀疏数组的第一行， 根基第一行的数据，创建以上原始的chessArr1二维数组

		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

		// 2.在读取稀疏数组第二行的数据，并赋给原始的二维数组 即可。

		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		// 输出恢复后的二维数组：

		System.out.println("稀疏数组  转  二维数组：");
		for (int[] row : chessArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}

}
