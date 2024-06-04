package com.tanthanh.bookservice.command.api.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBookCommand {

    @TargetAggregateIdentifier
    private String bookId;

}
