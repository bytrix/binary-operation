import com.system.Bin;
import com.system.Number;
import com.system.Decimal;
import java.io.*;
import java.text.DecimalFormat;

class Test {
	public static void main(String[] args) {
		// System.out.println(Decimal.parseDecimal("10000011"));
		// System.out.println(Decimal.parseDecimalF("1.0000001"));
		// FileOutputStream fos = new FileOutputStream(file);


		try {

			File file = new File("/home/ynl0zq/Desktop/data");

			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);

			String line = "";

			while(null != (line=reader.readLine())) {

				double trueValue = Decimal.parseDecimalF(line);
				// DecimalFormat format = new DecimalFormat("0.0000000");
				System.out.println(String.format("% 10f", trueValue) + "  " + line);
				// System.out.println(String.format("% 9d", format.format(trueValue)));
				// System.out.println(String.format("%09d", 5));
				// System.out.println(String.format("%020f", trueValue) + " " + line);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		// double a = 3.14159265359361234657984651657498498465498754654295487165487946;
		// System.out.println(a);
		// System.out.println((float)a);


		// System.out.println(file);
	}
}
