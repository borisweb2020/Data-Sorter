import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
// import java.util.List;

public class DataSortedApp{
	private static Set<String> processedFiles = new HashSet<>();
	private static boolean appendMode = false;

	public static void main(String[] args){

		parseCommandLine(args);

		String intOutputFileName = "out_integer.txt";
		String floatOutputFileName = "out_float.txt";
		String stringOutputFileName = "out_string.txt";

		try{
			if(!appendMode){
				createFileIfNotExists(intOutputFileName);
				createFileIfNotExists(floatOutputFileName);
				createFileIfNotExists(stringOutputFileName);
			}

			BufferedWriter intWriter = new BufferedWriter(new FileWriter(intOutputFileName, appendMode));
			BufferedWriter floatWriter = new BufferedWriter(new FileWriter(floatOutputFileName, appendMode));
			BufferedWriter stringWriter = new BufferedWriter(new FileWriter(stringOutputFileName, appendMode));

			String[] remainingArgs = getRemainingArgs(args);
			if(remainingArgs.length == 0){
				System.out.println("CLI correct input: java DataSortedApp in1.txt in2.txt ...");
				intWriter.close();
				floatWriter.close();
				stringWriter.close();
				return;
			}

			for(String fileName : remainingArgs) {
				if(!processedFiles.contains(fileName)){
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
						System.out.println("Filtering completed.");
						processedFiles.add(fileName);
					} catch(IOException e) {
						System.out.println("An error occurred: ");
						e.printStackTrace();
					}
				} else {
					System.out.println("File " + fileName + " has already been processed. Skipping it...");
				}
			} // for(...)

			intWriter.close();
			floatWriter.close();
			stringWriter.close();

			System.out.println("Check the files");

		} catch(IOException e) {
			System.out.println("An error occurred: ");
			e.printStackTrace();
		}


	} // public static void main()

	private static void createFileIfNotExists(String fileName) throws IOException{
		File file = new File(fileName);
		if(!file.exists()){
			file.createNewFile();
		}
	}

	private static void parseCommandLine(String[] args){
		for(int i = 0; i < args.length; i++){
			String arg = args[i];
			if("-a".equals(arg)){
				appendMode = true;
			}
		}
	}

	private static String[] getRemainingArgs(String[] args){
		List<String> remainingArgsList = new ArrayList<>();
		for(int i = 0; i < args.length; i++){
			String arg = args[i];
			if(!"-a".equals(arg)){
				remainingArgsList.add(arg);
			}
		}
		return remainingArgsList.toArray(new String[0]);
	}
}