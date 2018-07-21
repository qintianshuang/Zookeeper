package com.atguigu.dubbo.interfaces;

import com.atguigu.dubbo.entities.Employee;

public interface EmployeeInterface {

    Employee saveEmployeeRemote(Employee employee);
}
