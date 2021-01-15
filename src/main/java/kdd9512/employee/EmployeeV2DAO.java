package kdd9512.employee;

import java.util.ArrayList;

public interface EmployeeV2DAO {

    String insertEmp(EmployeeVO2 emp2);

    ArrayList<EmployeeVO2> selectEmp();

    EmployeeVO2 selectOneEmp(String empno);

    String updateEmp(EmployeeVO2 evo2);

    String removeEmp(int empno);

}
