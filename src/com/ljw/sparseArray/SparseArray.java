package com.ljw.sparseArray;

import java.io.File;

/**
 * @program: data-structure
 * @description: 稀疏数组
 * @author: linjw
 * @create: 2020-07-15 15:32
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始二位数组 11 * 11
        // 0：表示没有棋子，1：表示黑子，2：表示蓝子
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 1;
        chessArray[3][3] = 2;
        System.out.println("原始数组");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.print(" " + data);
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 1;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                    count++;
                }
            }
        }
        //存储稀疏数组

        /**
         * 稀疏数组
         */
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%s %s %s\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("恢复数组");
        for (int i = 0; i < chessArray2.length; i++) {
            for (int j = 0; j < chessArray2[i].length; j++) {
                System.out.print(chessArray2[i][j]);
            }
            System.out.println();
        }
    }
}
