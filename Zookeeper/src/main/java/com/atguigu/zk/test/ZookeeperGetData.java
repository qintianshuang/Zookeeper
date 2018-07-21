package com.atguigu.zk.test;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperGetData {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        //创建一个Zookeeper对象
        ZooKeeper zooKeeper = new ZooKeeper("192.168.141.150", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) { }
        });
        //调用Zookeeper对象获取制定节点的数据

        //节点路径
        String path = "/fruit";
        //watch设置为false表示不启用通知机制
        boolean watch = false;
        //状态信息通过空的start对象提供
        Stat stat = new Stat();
        //获取到的数据是字节数组的形式，需要加工成String
        byte[] data = zooKeeper.getData(path, watch, stat);
        //把获取到的字节数组转换成String
        String result = new String(data);
        //打印结果
        System.out.println(result);
    }
}
