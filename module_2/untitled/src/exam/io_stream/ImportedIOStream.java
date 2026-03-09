package exam.io_stream;

import exam.model.Imported;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportedIOStream {
    private static final String URL = "src/exam/data/imported.csv";

    public static void writeImportedInfoFile(Imported imported) {
        try (FileWriter fw = new FileWriter(URL, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(imported.toLineString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeListImportedInfoFile(List<Imported> importeds) {

        try (FileWriter fw = new FileWriter(URL);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Imported imported : importeds) {
                bw.write(imported.toLineString());
                bw.newLine();
            }
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Imported> readImportedFromFile() {
        List<Imported> importeds = new ArrayList<>();
        try (FileReader fr = new FileReader(URL);
             BufferedReader br = new BufferedReader(fr)) {
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] data = temp.split(",");
                importeds.add(new Imported(Integer.parseInt(data[0]), data[1],
                        Double.parseDouble(data[2]), data[3], data[4], data[5], data[6]));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return importeds;

    }
}
