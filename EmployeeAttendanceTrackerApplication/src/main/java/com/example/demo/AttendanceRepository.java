package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployeeEmployeeId(Long employeeId);
    List<Attendance> findByEmployeeDepartment(String department);
}
