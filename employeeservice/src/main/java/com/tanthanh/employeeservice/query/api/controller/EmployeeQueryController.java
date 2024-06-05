package com.tanthanh.employeeservice.query.api.controller;

import com.tanthanh.employeeservice.query.api.model.EmployeeResponseModel;
import com.tanthanh.employeeservice.query.api.queries.GetAllEmployeesQuery;
import com.tanthanh.employeeservice.query.api.queries.GetEmployeesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/{employeeId}")
    public EmployeeResponseModel getEmployeeDetail(@PathVariable String employeeId) {
        GetEmployeesQuery getEmployeeQuery = new GetEmployeesQuery();
        getEmployeeQuery.setEmployeeId(employeeId);
        EmployeeResponseModel employeeResponseModel = queryGateway.query(getEmployeeQuery, ResponseTypes.instanceOf(EmployeeResponseModel.class)).join();
        return employeeResponseModel;
    }

    @GetMapping
    public List<EmployeeResponseModel> getAllEmployees() {
        GetAllEmployeesQuery getAllEmployeesQuery = new GetAllEmployeesQuery();
        List<EmployeeResponseModel> list = queryGateway.query(getAllEmployeesQuery, ResponseTypes.multipleInstancesOf(EmployeeResponseModel.class)).join();
        return list;
    }
}
