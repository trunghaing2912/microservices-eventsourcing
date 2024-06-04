package com.tanthanh.bookservice.command.api.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "books")
public class Book {

    @Id
    private String bookId;

    private String name;

    private String author;

    private Boolean isReady;
}
