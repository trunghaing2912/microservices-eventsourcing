package com.tanthanh.employeeservice.command.api.controller;

import com.tanthanh.employeeservice.command.api.command.CreateEmployeeCommand;
import com.tanthanh.employeeservice.command.api.command.DeleteEmployeeCommand;
import com.tanthanh.employeeservice.command.api.command.UpdateEmployeeCommand;
import com.tanthanh.employeeservice.command.api.model.EmployeeRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addEmployee(@RequestBody EmployeeRequestModel model) {
        CreateEmployeeCommand command = new CreateEmployeeCommand(UUID.randomUUID().toString(), model.getFirstName(), model.getLastName(), model.getKin(), false);
        commandGateway.sendAndWait(command);
        return "employee added";
    }

    @PutMapping
    public String updateEmployee(@RequestBody EmployeeRequestModel model) {
        UpdateEmployeeCommand command = new UpdateEmployeeCommand(model.getEmployeeId(), model.getFirstName(), model.getLastName(), model.getKin(), model.getIsDisciplined());
        commandGateway.sendAndWait(command);
        return "employee updated";
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        DeleteEmployeeCommand command = new DeleteEmployeeCommand(employeeId);
        commandGateway.sendAndWait(command);
        return "employee deleted";
    }
}
