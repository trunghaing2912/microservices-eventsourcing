package com.tanthanh.bookservice.query.api.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookResponseModel {

    private String bookId;

    private String name;

    private String author;

    private Boolean isReady;
}
