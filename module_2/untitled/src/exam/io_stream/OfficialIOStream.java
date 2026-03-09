package exam.io_stream;

import exam.model.Official;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OfficialIOStream {
    private static final String URL = "src/exam/data/official.csv";

    public static void writeOfficicalInfoFile(Official official) {
        try (FileWriter fw = new FileWriter(URL, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(official.toLineString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeListOfficialInfoFile(List<Official> officials) {

        try (FileWriter fw = new FileWriter(URL);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Official official : officials) {
                bw.write(official.toLineString());
                bw.newLine();
            }
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Official> readOfficialFromFile() {
        List<Official> officials = new ArrayList<>();
        try (FileReader fr = new FileReader(URL);
             BufferedReader br = new BufferedReader(fr)) {
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] data = temp.split(",");
                officials.add(new Official(Integer.parseInt(data[0]), data[1],
                        Double.parseDouble(data[2]), data[3], data[4], Integer.parseInt(data[5]), data[6]));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return officials;

    }

}
