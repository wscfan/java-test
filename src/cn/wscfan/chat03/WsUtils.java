package cn.wscfan.chat03;

import java.io.Closeable;

/**
 * 工具类
 * @Author 王松
 * @Date 2020/4/12 17:09
 */
public class WsUtils {
    /**
     * 释放资源
     */
    public static void close(Closeable... targets) {
        for (Closeable target: targets) {
            try {
                if (target != null) {
                    target.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
