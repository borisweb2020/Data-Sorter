import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exmp {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java DataTypeFilter <inputFile1> <inputFile2> ...");
            return;
        }

        for (String inputFileName : args) {
            String intOutputFileName = "out_int.txt";
            String floatOutputFileName = "out_float.txt";
            String stringOutputFileName = "out_string.txt";

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                 BufferedWriter intWriter = new BufferedWriter(new FileWriter(intOutputFileName));
                 BufferedWriter floatWriter = new BufferedWriter(new FileWriter(floatOutputFileName));
                 BufferedWriter stringWriter = new BufferedWriter(new FileWriter(stringOutputFileName))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    // Пытаемся преобразовать строку в целое число
                    try {
                        Integer.parseInt(line);
                        // Если успешно, записываем строку в файл out_int.txt
                        intWriter.write(line);
                        intWriter.newLine();
                    } catch (NumberFormatException e1) {
                        // Если строка не является целым числом, проверяем на тип Double
                        try {
                            Double.parseDouble(line);
                            // Если успешно, записываем строку в файл out_float.txt
                            floatWriter.write(line);
                            floatWriter.newLine();
                        } catch (NumberFormatException e2) {
                            // Если строка не является целым числом или вещественным числом, записываем в файл out_string.txt
                            stringWriter.write(line);
                            stringWriter.newLine();
                        }
                    }
                }

                System.out.println("Filtering completed for " + inputFileName + ". Check the files: " + intOutputFileName + ", " + floatOutputFileName + ", and " + stringOutputFileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
