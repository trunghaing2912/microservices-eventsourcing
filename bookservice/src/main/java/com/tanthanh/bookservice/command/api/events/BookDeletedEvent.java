package com.tanthanh.bookservice.command.api.events;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDeletedEvent {

    private String bookId;

}
