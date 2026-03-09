package project_1.io_stream;

import project_1.model.Student;
import project_1.model.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherIOStream {
    private static final String URL = "src/project_1/data/teacher.csv";

    public static void writeTeacherInfoFile(Teacher teacher) {
        try (FileWriter fw = new FileWriter(URL, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(teacher.toLineString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeListTeacherInfoFile(List<Teacher> teachers) {

        try (FileWriter fw = new FileWriter(URL);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Teacher teacher : teachers) {
                bw.write(teacher.toLineString());
                bw.newLine();
            }
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Teacher> readTeacherFromFile() {
        List<Teacher> teachers = new ArrayList<>();
        try (FileReader fr = new FileReader(URL);
             BufferedReader br = new BufferedReader(fr)) {
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] data = temp.split(",");
                teachers.add(new Teacher(Integer.parseInt(data[0]), data[1],
                        data[2], LocalDate.parse(data[3]), Double.parseDouble(data[4])));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teachers;

    }
}
