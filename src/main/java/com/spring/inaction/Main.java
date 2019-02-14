package com.spring.inaction;

import com.spring.inaction.eventhandling.custom.CustomEventPublisher;
import com.spring.inaction.model.Employee;
import com.spring.inaction.pojo.HelloWorld;
import com.spring.inaction.service.EmployeeService;
import com.spring.inaction.service.FileService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by mberhe on 2/13/19.
 */
//@ComponentScan(basePackages = {"com.spring.inaction"})
public class Main {
    public static void main(String[] args) {
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("Development");
        context.register(AppConfig.class);
        context.refresh();*/

        //AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("Development");
        context.scan("com.spring.inaction");
        context.refresh();

        context.start();

        /*Arrays.stream(context.getBeanDefinitionNames()).forEach((n)->{
            System.out.println(n);
        });*/

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorldBean");
        helloWorld.sayHello("Mhret Berhe");

        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        Employee employee1 = new Employee("Mhretaab", "Berhe", "mhret@email.com", 30000.036, "ssn00000001");
        employee1.setJoiningDate(new Date());
        Employee employee2 = new Employee("Berhanu", "Tarekegn", "berhanu@email.com", 30000.036, "ssn00000002");

        /*employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);*/


        List<Employee> employees = employeeService.findAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }


        /*employeeService.deleteEmployeeBySsn("ssn00000002");


        Employee employee = employeeService.findBySsn("ssn00000001");
        employee.setSalary(50000.0);
        employeeService.updateEmployee(employee);


        List<Employee> employeeList = employeeService.findAllEmployees();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }*/

        FileService fileService = (FileService) context.getBean("fileService");
        fileService.readValues();

        CustomEventPublisher cep = (CustomEventPublisher) context.getBean(CustomEventPublisher.class);
        cep.publish();
        cep.publish();

        context.stop();

        context.close();
    }
}
