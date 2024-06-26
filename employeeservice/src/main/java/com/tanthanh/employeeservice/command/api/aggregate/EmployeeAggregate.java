package com.tanthanh.employeeservice.command.api.aggregate;

import com.tanthanh.employeeservice.command.api.command.CreateEmployeeCommand;
import com.tanthanh.employeeservice.command.api.command.DeleteEmployeeCommand;
import com.tanthanh.employeeservice.command.api.command.UpdateEmployeeCommand;
import com.tanthanh.employeeservice.command.api.events.EmployeeCreatedEvent;
import com.tanthanh.employeeservice.command.api.events.EmployeeDeletedEvent;
import com.tanthanh.employeeservice.command.api.events.EmployeeUpdatedEvent;
import lombok.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Aggregate
public class EmployeeAggregate {

    @AggregateIdentifier
    private String employeeId;

    private String firstName;

    private String lastName;

    private String kin;

    private Boolean isDisciplined;

    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand command) {
        EmployeeCreatedEvent event = new EmployeeCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateEmployeeCommand command) {
        EmployeeUpdatedEvent event = new EmployeeUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteEmployeeCommand command) {
        EmployeeDeletedEvent event = new EmployeeDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EmployeeCreatedEvent event) {
        this.employeeId = event.getEmployeeId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.isDisciplined = event.getIsDisciplined();
    }

    @EventSourcingHandler
    public void on(EmployeeUpdatedEvent event) {
        this.employeeId = event.getEmployeeId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.isDisciplined = event.getIsDisciplined();
    }

    @EventSourcingHandler
    public void on(EmployeeDeletedEvent event) {
        this.employeeId = event.getEmployeeId();
    }

}
