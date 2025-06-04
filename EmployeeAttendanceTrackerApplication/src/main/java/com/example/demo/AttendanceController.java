package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService service;

    @PostMapping("/mark")
    public Attendance mark(@RequestParam Long employeeId, @RequestParam String status) {
        return service.markAttendance(employeeId, status);
    }

    @GetMapping("/report/employee/{id}")
    public List<Attendance> reportByEmployee(@PathVariable Long id) {
        return service.getEmployeeReport(id);
    }

    @GetMapping("/report/department/{dept}")
    public List<Attendance> reportByDepartment(@PathVariable String dept) {
        return service.getDepartmentReport(dept);
    }
}
