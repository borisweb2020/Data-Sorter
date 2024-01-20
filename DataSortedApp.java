import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataSortedApp{
	public static void main(String[] args){
		String intOutputFileName = "out_integer.txt";
		String floatOutputFileName = "out_float.txt";
		String stringOutputFileName = "out_string.txt";

		try(BufferedWriter intWriter = new BufferedWriter(new FileWriter(intOutputFileName, true));
				BufferedWriter floatWriter = new BufferedWriter(new FileWriter(floatOutputFileName, true));
				BufferedWriter stringWriter = new BufferedWriter(new FileWriter(stringOutputFileName, true))){

			if(args.length == 0){
				System.out.println("CLI correct input: java DataSortedApp in1.txt in2.txt ...");
				return;
			}

			for(String fileName : args) {
				try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
					String line;
					while((line = reader.readLine()) != null){
						try {
							Long.parseLong(line);
							intWriter.write(line);
							intWriter.newLine();
						} catch(NumberFormatException e1) {
							try {
								Double.parseDouble(line);
								floatWriter.write(line);
								floatWriter.newLine();
							} catch(NumberFormatException e2) {
								stringWriter.write(line);
								stringWriter.newLine();
							}
						}
					}
					System.out.println("Filtering completed. Check the output files");
				} catch(IOException e) {
					System.out.println("An error occurred: ");
					e.printStackTrace();
				}
			}
		} catch(IOException e) {
			System.out.println("An error occurred: ");
			e.printStackTrace();
		}

	}
}