package com.atguigu.zk.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

//Zookeeper设置一个值
public class ZookeeperSetData {
    public static void main(String[] args) throws Exception{
        //创建Zookeeper对象，创建连接
        ZooKeeper zooKeeper = new ZooKeeper("192.168.141.150", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) { }
        });

        //Zookeeper要求在最新版的基础上修改节点值
        //如果不确定版本，可以用-1
        int vertion = 4;

        Stat stat = zooKeeper.setData("/fruit", "hello".getBytes(), vertion);

        System.out.println(stat);
    }
}
