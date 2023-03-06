package com.bridgelabz.employee.payroll.service.test;

import com.bridgelabz.employee.payroll.service.EmployeePayrollData;
import com.bridgelabz.employee.payroll.service.EmployeePayrollService;
import com.bridgelabz.employee.payroll.service.FileUtils;
import com.bridgelabz.employee.payroll.service.WatchServiceExample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class EmployeePayrollServiceTest {
    @Test
    void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries()throws IOException {
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(101, "Prashant Deepake", 1000000.0),
                new EmployeePayrollData(102, "Akshay Kumar", 2000000.0),
                new EmployeePayrollData(103, "Sharukh Khan", 300000.0),
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3, entries);
    }
    @Test
    void givenFileOnReadingFromFileShouldMatchEmployeeCount() throws IOException{
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3, entries);
    }
}