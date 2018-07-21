package com.atguigu.dubbo.handler;

import com.atguigu.dubbo.entities.Employee;
import com.atguigu.dubbo.interfaces.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeInterface employeeInterface;

    @RequestMapping("/saveEmp")
    public String saveEmp(Employee employee, Model model){
        Employee remote = employeeInterface.saveEmployeeRemote(employee);

        model.addAttribute("remote", remote);
        return "result";
    }
}
