package com.tanthanh.employeeservice.query.api.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseModel {

    private String employeeId;

    private String firstName;

    private String lastName;

    private String kin;

    private Boolean isDisciplined;

}
