import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException {
        File a = new File("D:/a.txt");
        System.out.println(a);

        a.renameTo(new File("D:/b.txt"));

        System.out.println(System.getProperty("user.dir"));
//        File f2 = new File("gg.txt");
//        f2.createNewFile();
    }
}
