package com.tanthanh.borrowingservice.command.api.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Message {

    private String employeeId;
    private String message;
}
