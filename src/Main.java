import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder in = new StringBuilder();
        List<File> dirList = Arrays.asList(
                new File("F://Games"),
                new File("F://Games//src"),
                new File("F://Games//res"),
                new File("F://Games//savegames"),
                new File("F://Games//temp"),
                new File("F://Games//src//main"),
                new File("F://Games//src//test"),
                new File("F://Games//res//drawables"),
                new File("F://Games//res//vectors"),
                new File("F://Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("F://Games//src//main//Main.java"),
                new File("F://Games//src//main//Utils.java"),
                new File("F://Games//temp//temp.txt")
        );
        dirList.stream().forEach(dir -> {
            if (dir.mkdir()) in.append("Каталог " + dir + "создан\n");
            else in.append("Каталог " + dir + "не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) in.append("Файл " + file + "создан\n");
                else in.append("Файл " + file + "не создан\n");
            } catch (IOException ex) {
                in.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("F://Games//temp//temp.txt", false)) {
            log.write(in.toString());
            log.flush();
        } catch (IOException ex) {
            in.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("F://Games//temp//temp.txt"))){
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}