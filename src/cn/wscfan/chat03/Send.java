package cn.wscfan.chat03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送端
 * @Author 王松
 * @Date 2020/4/12 22:50
 */
public class Send implements Runnable {
    private Socket client;
    private BufferedReader console;
    private DataOutputStream dos;
    private boolean isRunning;
    public Send(Socket client) {
        this.client = client;
        isRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            System.out.println("========1========");
            this.release();
        }
    }
    @Override
    public void run() {
        while (isRunning) {
            String msg = getStrFromConsole();
            if (!msg.equals("")) {
                send(msg);
            }
        }
    }
    private void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("======3========");
            this.release();
        }
    }

    /**
     * 从控制台获取消息
     * @return
     */
    private String getStrFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    // 释放资源
    private void release() {
        this.isRunning = false;
        WsUtils.close(dos);
    }
}
