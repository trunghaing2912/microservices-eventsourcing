package com.tanthanh.employeeservice.command.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequestModel {

    private String employeeId;

    private String firstName;

    private String lastName;

    private String kin;

    private Boolean isDisciplined;
}
