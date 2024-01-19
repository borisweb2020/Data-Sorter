import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataSortedApp{
	public static void main(String[] args){
		String inputFileName = "resources/input/in1.txt";
		String intOutputFileName = "resources/output/out_integer.txt";
		String stringOutputFileName = "resources/output/out_string.txt";

		try(BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
				BufferedWriter intWriter = new BufferedWriter(new FileWriter(intOutputFileName));
				BufferedWriter stringWriter = new BufferedWriter(new FileWriter(stringOutputFileName))){

			String line;
			while((line = reader.readLine()) != null){
				try {
					Long.parseLong(line);
					intWriter.write(line);
					intWriter.newLine();
				} catch(NumberFormatException e) {
					stringWriter.write(line);
					stringWriter.newLine();
				}
			}

			System.out.println("Filtering completed. Check the files.");
		} catch(IOException e) {
			System.out.println("An error occurred: ");
			e.printStackTrace();
		}
	}
}