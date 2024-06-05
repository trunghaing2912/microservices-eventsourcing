package com.tanthanh.employeeservice.command.api.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeleteEmployeeCommand {

    @TargetAggregateIdentifier
    private String employeeId;

}
