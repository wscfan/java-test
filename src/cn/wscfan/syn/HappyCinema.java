package cn.wscfan.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王松
 * @Date 2020/3/19 22:51
 */
public class HappyCinema {
    public static void main(String[] args) {
        List<Integer> avaliable = new ArrayList<Integer>();
        avaliable.add(1);
        avaliable.add(2);
        avaliable.add(4);
        avaliable.add(5);
        avaliable.add(7);
        avaliable.add(9);
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);
        SxtCinema cinema = new SxtCinema(avaliable, "happy sxt");
        new Thread(new Customer(cinema, seats1), "张三").start();
        new Thread(new Customer(cinema, seats2), "李四").start();
    }
}

// 顾客
class Customer implements Runnable {
    SxtCinema cinema;
    List<Integer> seats;

    public Customer(SxtCinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized(cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "-位置为：" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "-位置不够");
            }
        }
    }
}

// 影院
class SxtCinema {
    List<Integer> avaliable;
    String name;

    public SxtCinema(List<Integer> avaliable, String name) {
        this.avaliable = avaliable;
        this.name = name;
    }

    public boolean bookTickets(List<Integer> seats) {
        System.out.println("可用位置为：" + avaliable);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(avaliable);
        copy.removeAll(seats);
        if ((avaliable.size() - copy.size()) != seats.size()) {
            return false;
        }
        avaliable = copy;
        return true;
    }
}