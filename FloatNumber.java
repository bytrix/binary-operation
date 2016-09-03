package com.system;
import com.system.Bin;

public class FloatNumber {

	private double mTrueValue;
	private String mSignAndMagnitude;
	private String mOnesComplement;
	private String mTwosComplement;

	// public FloatNumber(double x) {
	// 	// setSignAndMagnitude(Bin.parseBin(x));
	// 	mSignAndMagnitude = new String();
	// 	mOnesComplement = new String();
	// 	mTwosComplement = new String();

	// 	mTrueValue = x;

	// 	// mSignAndMagnitude = Bin.parseBin(x);
	// 	mSignAndMagnitude = Bin.parseBin(x);

	// 	setOnesComplement();

	// 	setTwosComplement();
	// }

	public FloatNumber(String bin, double trueValue) {

		mSignAndMagnitude = new String();
		mOnesComplement = new String();
		mTwosComplement = new String();

		mTrueValue = trueValue;

		mSignAndMagnitude = bin;

		setOnesComplement();

		setTwosComplement();
	}

	public double getTrueValue() {
		return mTrueValue;
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

	public void setOnesComplement() {
		if (mTrueValue < 0) {

			int[] arrSignAndMagnitude = new int[9];
			for (int i=0; i<9; i++) {
				if (i == 1) {
					continue;
				}
				arrSignAndMagnitude[i] = mSignAndMagnitude.charAt(i) - 48;
			}

			for (int i=2; i<9; i++) {
				arrSignAndMagnitude[i] = arrSignAndMagnitude[i]==1 ? 0 : 1;
			}

			for (int i=0; i<9; i++) {
				mOnesComplement += arrSignAndMagnitude[i];
			}
			mOnesComplement = mOnesComplement.substring(0, 1) + "." + mOnesComplement.substring(2);

		} else {
			mOnesComplement = mSignAndMagnitude;
		}

	}

	public void setTwosComplement() {
		if (mTrueValue < 0) {
			int carryBit = 1;
			int signBit;
			int[] arrTwosComplement = new int[9];
			int[] tempBits = new int[9];

			for(int i=0; i<9; i++) {
				arrTwosComplement[i] = mOnesComplement.charAt(i) - 48;
				// System.out.println(" arrTwosComplement[" + i + "]: " + arrTwosComplement[i]);
			}


			signBit = arrTwosComplement[0];

			for(int i=8; i>1; i--) {

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

			}

			mTwosComplement = signBit+".";
			for(int i=2; i<9; i++) {
				mTwosComplement += tempBits[i];
			}
		} else {
			mTwosComplement = mSignAndMagnitude;
		}

	}
}
