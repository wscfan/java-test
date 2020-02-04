package cn.wscfan.io;

import java.io.File;

public class DirCount {
    private String path;
    private File src;
    private long len;

    public DirCount(String path) {
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }
    private void count(File src) {
        if (null != src && src.exists()) {
            if (src.isFile()) {
                len += src.length();
            } else {
                for(File s: src.listFiles()) {
                    count(s);
                }
            }
        }
    }

    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }

    public static void main(String[] args) {
        DirCount dir1 = new DirCount("src/cn/wscfan/io/data");
        System.out.println(dir1.getLen());
    }
}