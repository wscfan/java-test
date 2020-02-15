package cn.wscfan.io;

import java.io.*;

/**
 * @Author 王松
 * @Date 2020/2/15 15:27
 */
public class ConvertTest {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
            String msg = "";
            while(!msg.equals("exit")) {
                msg = reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
