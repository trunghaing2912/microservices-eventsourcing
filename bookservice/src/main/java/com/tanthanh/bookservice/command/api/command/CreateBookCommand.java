package com.tanthanh.bookservice.command.api.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookCommand {

    @TargetAggregateIdentifier
    private String bookId;

    private String name;

    private String author;

    private Boolean isReady;

}
