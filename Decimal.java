package com.system;

public class Decimal {

	public static int parseDecimal(String bin) {

		int[] arrBin = new int[8];
		int signBit;
		int sum = 0;

		for(int i=0; i<8; i++) {
			arrBin[i] = bin.charAt(i) - 48;
		}

		signBit = arrBin[0];

		for(int i=1; i<8; i++) {
			int index = 7-i;
			if (arrBin[i] == 1) {
				// System.out.println(arrBin[i] + " " + i + " " + index + " " + (int)Math.pow(2, index));
				sum += (int)Math.pow(2, index);
			} else {
				// System.out.println(arrBin[i] + " " + i + " " + index);
			}
		}

		if (signBit == 0) {
			return sum;
		} else {
			return -sum;
		}
	}

	public static double parseDecimalF(String bin) {

		int[] arrBin = new int[9];
		int signBit;
		double sum = 0;

		for(int i=0; i<9; i++) {
			if (i == 1) {
				// i--;
				continue;
			}
			arrBin[i] = bin.charAt(i) - 48;
		}

		signBit = arrBin[0];

		for(int i=1; i<9; i++) {
			int index = i;
			if (arrBin[i] == 1) {
				// System.out.println(arrBin[i] + " " + (i-1) + " " + (index-1) + " " + Math.pow(2, -index+1));
				sum += Math.pow(2, -index+1);
			} else {
				// System.out.println(arrBin[i] + " " + (i-1) + " " + (index-1));
			}
		}

		if (signBit == 0) {
			return sum;
		} else {
			return -sum;
		}
		// return 1.23456489419619681567468768;
	}

}
