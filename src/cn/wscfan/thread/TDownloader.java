package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/7 22:40
 */
public class TDownloader extends Thread{
    private String url;
    private String name;

    public TDownloader(String url, String name) {
        this.url = url;
        this.name = name;
        System.out.println(name);
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
    }

    public static void main(String[] args) {
        String path = "src/cn/wscfan/thread/data/";
        TDownloader td1 = new TDownloader("https://tpc.googlesyndication.com/simgad/16758003512884775995?sqp=4sqPyQQ7QjkqNxABHQAAtEIgASgBMAk4A0DwkwlYAWBfcAKAAQGIAQGdAQAAgD-oAQGwAYCt4gS4AV_FAS2ynT4&rs=AOga4qmqaGjtGJq68ZuOOIZEvwAeuv4TEQ", path + "pic1.png");
        TDownloader td2 = new TDownloader("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4090061760,3566002114&fm=26&gp=0.jpg", path + "pic2.png");
        TDownloader td3 = new TDownloader("https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1305353222,2352820043&fm=26&gp=0.jpg", path + "pic3.png");
        td2.start();
        td1.start();
        td3.start();
    }
}
