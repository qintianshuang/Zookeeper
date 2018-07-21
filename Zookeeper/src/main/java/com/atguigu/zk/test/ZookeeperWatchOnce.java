package com.atguigu.zk.test;


import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperWatchOnce {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        //创建一个Zookeeper对象
        ZooKeeper zooKeeper = new ZooKeeper("192.168.141.150", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) { }
        });
        //调用Zookeeper对象获取制定节点的数据

        //节点路径
        String path = "/fruit";

        //指定一个具体的观察者对象完成对制定对象的监控
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {

                //接收到Zookeeper的通知后，会执行proecess()方法
                System.err.println("*******我们收到Zookeeper的通知了********");
            }
        };

        //状态信息通过空的start对象提供
        Stat stat = new Stat();

        //获取节点当前值的同时，在节点上放置一个观察者对象，开始监控
        byte[] data = zooKeeper.getData(path, watcher, stat);

        //把获取到的字节数组转换成String
        String result = new String(data);
        System.out.println("result" + result);

        //为了一直接受通知，程序需要一直运行
        while (true){
            Thread.sleep(3000);
            System.out.println("*********我还活着！！！********");
        }
    }
}
