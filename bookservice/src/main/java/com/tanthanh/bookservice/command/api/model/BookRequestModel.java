package com.tanthanh.bookservice.command.api.model;

import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestModel {

    private String bookId;

    private String name;

    private String author;

    private Boolean isReady;
}

