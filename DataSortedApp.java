import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataSortedApp{
	public static void main(String[] args){
		String inputFileName = "resources/input/in1.txt";
		String outputFileName = "resources/output/out_integer.txt";

		try(BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))){

			String line;
			while((line = reader.readLine()) != null){
				try {
					Integer.parseInt(line);
					writer.write(line);
					writer.newLine();
				} catch(NumberFormatException e) {
					// Ignoring...
				}
			}

			System.out.println("Filtering completed. Check the file: " + outputFileName);
		} catch(IOException e) {
			System.out.println("An error occurred: ");
			e.printStackTrace();
		}
	}
}