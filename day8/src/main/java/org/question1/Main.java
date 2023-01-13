package org.question1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Ajay"));
        employeeList.add(new Employee(2, "Aditya"));
        employeeList.add(new Employee(1, "Vivek"));
        employeeList.add(new Employee(2, "Ajay"));
        employeeList.add(new Employee(4, "Karan"));
        employeeList.add(new Employee(3, "Akash"));
        employeeList.add(new Employee(4, "Aayush"));
        employeeList.add(new Employee(5, "Karan"));
        employeeList.add(new Employee(3, "Aman"));
        employeeList.add(new Employee(5, "Aayush"));
        employeeList.add(new Employee(1, "Ravi"));
        employeeList.add(new Employee(3, "Ajay"));



        Map<Integer, List<String>> departmentMap = employeeList.stream().collect(Collectors.groupingBy(x->x.getDeptId(),Collectors.mapping(x->x.getEmpName(),Collectors.toList())));
        logger.info(departmentMap.toString());
    }
}