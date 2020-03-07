package cn.wscfan.thread;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @Author 王松
 * @Date 2020/3/8 0:14
 */
public class IDownloader implements Runnable {
    private String url;
    private String name;

    public IDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        String path = "src/cn/wscfan/thread/data/";
        IDownloader id1 = new IDownloader("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1054100330,457963471&fm=26&gp=0.jpg", path + "avatar1.jpg");
        IDownloader id2 = new IDownloader("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=940442957,914034847&fm=26&gp=0.jpg", path + "avatar2.jpg");
        IDownloader id3 = new IDownloader("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3794069655,4270774770&fm=26&gp=0.jpg", path + "avatar3.jpg");
        new Thread(id1).start();
        new Thread(id2).start();
        new Thread(id3).start();
    }
}
