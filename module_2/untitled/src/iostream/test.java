package iostream;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {

        try (FileWriter fw = new FileWriter("src/iostream/demo.csv", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("abc");
            bw.newLine();
            bw.write("def");
            bw.newLine();
            bw.write("ghi");
            bw.newLine();
        }   catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader fr = new FileReader("src/iostream/demo.csv");
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
