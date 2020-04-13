package cn.wscfan.chat03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收端
 * @Author 王松
 * @Date 2020/4/12 22:50
 */
public class Receive implements Runnable  {
    private Socket client;
    private DataInputStream dis;
    private boolean isRunning;

    public Receive(Socket client) {
        this.client = client;
        try {
            isRunning = true;
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("======2=======");
            release();
        }
        this.dis = dis;
    }

    private String receive() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("=====4=======");
            release();
        }
        return "";
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = receive();
            if (!msg.equals("")) {
                System.out.println(msg);
            }
        }
    }
    /**
     * 释放资源
     */
    private void release() {
        this.isRunning = false;
        WsUtils.close(dis,client);
    }
}
