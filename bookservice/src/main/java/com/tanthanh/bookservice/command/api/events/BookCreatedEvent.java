package com.tanthanh.bookservice.command.api.events;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookCreatedEvent {

    private String bookId;

    private String name;

    private String author;

    private Boolean isReady;
}
