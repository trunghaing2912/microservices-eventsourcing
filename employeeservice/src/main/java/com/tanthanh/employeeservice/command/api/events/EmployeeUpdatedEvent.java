package com.tanthanh.employeeservice.command.api.events;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeUpdatedEvent {

    private String employeeId;

    private String firstName;

    private String lastName;

    private String kin;

    private Boolean isDisciplined;
}
