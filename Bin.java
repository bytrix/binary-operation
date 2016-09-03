package com.system;
import java.io.*;

public class Bin {
	// public static void main(String[] args) {
		
		/*
		File out = new File("out");
		try {
			out.createNewFile();
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=-129; i<128; i++) {
				bw.write(String.format("%04d", i) + ": " + toBin(i) + "\n");
			}
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		*/
	// }

	public static String parseBin(int x) {
		int[] num = new int[]{0,0,0,0,0,0,0,0};
		StringBuilder sb = new StringBuilder();
		int index = 7;
		if(x < 0) {
			num[0] = 1;
			x = -x;
		}
		while(true) {
			num[index] = x%2;
			if(x/2 !=0 ) {
				x = x/2;
			} else {
				break;	
			}
			if(index > 0) {
				index--;
			}
		}

		for(int n : num) {
			sb.append(n);
		}
		return sb.toString();
	}

	public static String parseFloatBin(float x) {
		int[] num = new int[]{0,0,0,0,0,0,0,0};
		StringBuilder sb = new StringBuilder();
		int index = 7;
		if(x < 0) {
			num[0] = 1;
			x = -x;
		}
		while(true) {
			num[index] = x%2;
			if(x/2 !=0 ) {
				x = x/2;
			} else {
				break;	
			}
			if(index > 0) {
				index--;
			}
		}

		for(int n : num) {
			sb.append(n);
		}
		return sb.toString();
	}
}
