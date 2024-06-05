package com.tanthanh.employeeservice.query.api.projection;

import com.tanthanh.employeeservice.command.api.data.Employee;
import com.tanthanh.employeeservice.command.api.data.EmployeeRepository;
import com.tanthanh.employeeservice.query.api.model.EmployeeResponseModel;
import com.tanthanh.employeeservice.query.api.queries.GetAllEmployeesQuery;
import com.tanthanh.employeeservice.query.api.queries.GetEmployeesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {

    @Autowired
    private EmployeeRepository employeeRepository;

    @QueryHandler
    public EmployeeResponseModel handle(GetEmployeesQuery query) {
        EmployeeResponseModel model = new EmployeeResponseModel();
        Employee employee = employeeRepository.getByEmployeeId(query.getEmployeeId());
        BeanUtils.copyProperties(employee, model);
        return model;
    }

    @QueryHandler
    public List<EmployeeResponseModel> handle(GetAllEmployeesQuery query) {
        List<Employee> listEntity = employeeRepository.findAll();
        List<EmployeeResponseModel> listEmployee = new ArrayList<>();
        listEntity.forEach(e -> {
            EmployeeResponseModel model = new EmployeeResponseModel();
            BeanUtils.copyProperties(e, model);
            listEmployee.add(model);
        });
        return listEmployee;
    }
}
