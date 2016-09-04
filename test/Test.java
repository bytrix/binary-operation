import com.system.Bin;
import com.system.IntegerNumber;
import com.system.FloatNumber;
import com.system.Decimal;
import java.io.*;
import java.text.DecimalFormat;

class Test {
	public static void main(String[] args) {

		try {

			File file = new File("float");

			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);

			String line = "";

			while(null != (line=reader.readLine())) {

				double trueValue = Decimal.parseDecimalF(line);
				FloatNumber n = new FloatNumber(line, trueValue);

				System.out.println(String.format("% 10f", trueValue) + "  " + line + " " + n.getOnesComplement() + " " + n.getTwosComplement());

			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		// for(int i=-128; i<=127; i++) {
		// 	IntegerNumber n = new IntegerNumber(i);
		// 	System.out.println(String.format("% 5d", i) + " " + n.getSignAndMagnitude() + " " + n.getOnesComplement() + " " + n.getTwosComplement());
		// }

	}
}
