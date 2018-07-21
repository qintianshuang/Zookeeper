package com.atguigu.zk.test;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperWatchPersist {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        //创建一个Zookeeper对象
        ZooKeeper zooKeeper = new ZooKeeper("192.168.141.150", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) { }
        });
        //调用Zookeeper对象获取制定节点的数据

        //核心逻辑：前面的Watcher失效后，通过后面的方法递归调用新的Watcer
        String dataOwn = new ZookeeperWatchPersist().getDataOwn(zooKeeper);

        //为了一直接受通知，程序需要一直运行
        while (true){
            Thread.sleep(3000);
            System.out.println("*********我还活着！！！********");
        }
    }

    public String getDataOwn(ZooKeeper zooKeeper){

        String result = null;
        try {
            byte[] data = zooKeeper.getData("/fruit", new Watcher() {
                @Override
                public void process(WatchedEvent event) {

                    //方法递归调用自己
                    getDataOwn(zooKeeper);
                }
            }, new Stat());
            result = new String(data);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //打印
        System.out.println("当前节点值=" + result);
        return  result;
    }
}
