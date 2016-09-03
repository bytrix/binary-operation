package com.system;
import com.system.Bin;

public class FloatNumber {

	private float trueValue;
	private String mSignAndMagnitude;
	private String mOnesComplement;
	private String mTwosComplement;

	public FloatNumber(float x) {
		// setSignAndMagnitude(Bin.parseBin(x));
		mSignAndMagnitude = new String();
		mOnesComplement = new String();
		mTwosComplement = new String();

		trueValue = x;

		mSignAndMagnitude = Bin.parseBin(x);

		setOnesComplement();

		setTwosComplement();
	}

	public float getTrueValue() {
		return trueValue;
	}

	public String getSignAndMagnitude() {
		return mSignAndMagnitude;
	}

	public String getOnesComplement() {
		return mOnesComplement;
	}

	public String getTwosComplement() {
		return mTwosComplement;
	}

	// public String setSignAndMagnitude(String x) {
	// 	mSignAndMagnitude = x;
	// }

	public void setOnesComplement() {
		// mOnesComplement = x;
		// int signBit;
		// System.out.println("aa");
		if (trueValue < 0) {
			int[] arrSignAndMagnitude = new int[8];
			for (int i=0; i<8; i++) {
				arrSignAndMagnitude[i] = mSignAndMagnitude.charAt(i) - 48;
				// System.out.println(mSignAndMagnitude.charAt(i) + " " + arrSignAndMagnitude[i]);
			}
			// signBit = arrSignAndMagnitude[0];
			for (int i=1; i<8; i++) {
				arrSignAndMagnitude[i] = arrSignAndMagnitude[i]==1 ? 0 : 1;
				// if (arrSignAndMagnitude[i] == 1) {
				// 	arrSignAndMagnitude[i] = 0;
				// } else {
				// 	arrSignAndMagnitude[i] = 1;
				// }
				// System.out.println(arrSignAndMagnitude[i]);
			}
			for (int i=0; i<8; i++) {
				mOnesComplement += arrSignAndMagnitude[i];
			}
			// System.out.println(arrSignAndMagnitude);

			// for(int i=0; i<8; i++) {
				// System.out.println(arrSignAndMagnitude[i]);
				// mOnesComplement += "a";
			// }
		} else {
			mOnesComplement = mSignAndMagnitude;
		}
		// return null;

	}

	public void setTwosComplement() {
		if (trueValue < 0) {
			int carryBit = 1;
			int signBit;
			int[] arrTwosComplement = new int[8];
			int[] tempBits = new int[8];
			// System.out.println("length: " + getOnesComplement().length());
			for(int i=0; i<8; i++) {
				arrTwosComplement[i] = mOnesComplement.charAt(i) - 48;
			}
			signBit = arrTwosComplement[0];
			for(int i=7; i>0; i--) {
				// System.out.println(i);
				// switch
				switch (arrTwosComplement[i]+carryBit) {
					case 0:
						tempBits[i] = 0;
						carryBit = 0;
						break;
					case 1:
						tempBits[i] = 1;
						carryBit = 0;
						break;
					case 2:
						tempBits[i] = 0;
						carryBit = 1;
						break;
				}

				// if (arrTwosComplement[i]+carryBit == 0) {
				// 	tempBits[i] = 0;
				// 	carryBit = 0;
				// } else if(arrTwosComplement[i]+carryBit == 1) {
				// 	tempBits[i] = 1;
				// 	carryBit = 0;
				// } else if(arrTwosComplement[i]+carryBit == 2) {
				// 	tempBits[i] = 0;
				// 	carryBit = 1;
				// }
			}

			mTwosComplement = signBit+"";
			for(int i=1; i<8; i++) {
				mTwosComplement += tempBits[i];
			}
		} else {
			mTwosComplement = mSignAndMagnitude;
		}

		// mTwoComplement = x;
	}
}
