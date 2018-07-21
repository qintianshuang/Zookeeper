package com.atguigu.decode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ConsummerDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String source = "consumer%3A%2F%2F192.168.141.1%2Fcom.atguigu.dubbo.interfaces" +
                ".EmployeeInterface%3Fapplication%3Demp-consummer%26category%3Dconsumers" +
                "%26check%3Dfalse%26dubbo%3D2.5.5%26interface%3Dcom.atguigu.dubbo.interfaces" +
                ".EmployeeInterface%26methods%3DsaveEmployeeRemote%26pid%3D3068%26revision%3D1" +
                ".0%26side%3Dconsumer%26timestamp%3D1532086544016";

        String decode = URLDecoder.decode(source,"UTF-8");

        System.out.println(decode);
    }
}
