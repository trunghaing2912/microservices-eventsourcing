package com.tanthanh.borrowingservice.command.api.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBookReturnCommand {

    @TargetAggregateIdentifier
    private String id;
    private String bookId;
    private String employee;
    private Date returnDate;
}
