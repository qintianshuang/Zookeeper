package com.atguigu.zk.test;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;

import java.util.ArrayList;

public class ZookeeperCreateNode {
    public static void main(String[] args) throws  Exception{

        //创建Zookeeper对象，创建连接
        ZooKeeper zooKeeper = new ZooKeeper("192.168.141.150", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) { }
        });

        //把给节点设置初始化值转换为字节数组
        String value = "mike";
        byte[] data = value.getBytes();

        //通过常量值获取一个访问控制元素
        ArrayList<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;

        //通过CreateMode枚举类型来获取节点类型
        CreateMode createMode = CreateMode.PERSISTENT;

        //执行创建节点的操作
        String result = zooKeeper.create("/fruit/grage", data, acl, createMode);

        //打印输出
        System.out.println(result);
    }
}
