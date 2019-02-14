package com.spring.inaction.controller;

import com.spring.inaction.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mberhe on 2/14/19.
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    final private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("persons", this.employeeService.findAllEmployees());
        return "index";
    }
}
