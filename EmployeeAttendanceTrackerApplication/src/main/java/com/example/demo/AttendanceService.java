package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Attendance markAttendance(Long employeeId, String status) {
        Employee emp = employeeRepository.findById(employeeId).orElseThrow();
        Attendance attendance = new Attendance();
        attendance.setEmployee(emp);
        attendance.setDate(new Date());
        attendance.setStatus(status);
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getEmployeeReport(Long employeeId) {
        return attendanceRepository.findByEmployeeEmployeeId(employeeId);
    }

    public List<Attendance> getDepartmentReport(String department) {
        return attendanceRepository.findByEmployeeDepartment(department);
    }
}

