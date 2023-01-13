package org.question1;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    private Integer deptId;
    private String empName;

    public Employee(Integer deptId,String empName){
        this.deptId=deptId;
        this.empName=empName;
    }

}
