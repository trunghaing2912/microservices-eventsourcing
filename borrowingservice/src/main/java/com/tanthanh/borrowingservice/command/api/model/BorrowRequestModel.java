package com.tanthanh.borrowingservice.command.api.model;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BorrowRequestModel {

    private String id;

    private String bookId;

    private String employeeId;

    private Date borrowingDate;

    private Date returnDate;
}
