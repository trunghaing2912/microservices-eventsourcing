package com.tanthanh.employeeservice.command.api.events;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDeletedEvent {

    private String employeeId;

}
