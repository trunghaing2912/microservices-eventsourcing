package com.tanthanh.borrowingservice.command.api.data;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "borrowing")
public class Borrowing {

    @Id
    private String id;

    private String bookId;

    private String employeeId;

    private Date borrowingDate;

    private Date returnDate;

}
