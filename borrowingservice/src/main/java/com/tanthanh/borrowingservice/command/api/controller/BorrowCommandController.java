package com.tanthanh.borrowingservice.command.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanthanh.borrowingservice.command.api.command.CreateBorrowCommand;
import com.tanthanh.borrowingservice.command.api.command.UpdateBookReturnCommand;
import com.tanthanh.borrowingservice.command.api.model.BorrowRequestModel;
import com.tanthanh.borrowingservice.command.api.model.Message;
import com.tanthanh.borrowingservice.command.api.service.IBorrowService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/borrowing")
@EnableBinding(Source.class)
public class BorrowCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private MessageChannel output;

    @PostMapping
    public String addBookBorrowing(@RequestBody BorrowRequestModel model) {
        try {
            CreateBorrowCommand command = new CreateBorrowCommand(model.getBookId(), model.getEmployeeId(), UUID.randomUUID().toString(), new Date());
            commandGateway.sendAndWait(command);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Book borrowing added";
    }

    @PutMapping
    public String updateBookReturn(@RequestBody BorrowRequestModel model) {
        UpdateBookReturnCommand command = new UpdateBookReturnCommand(borrowService.findIdBorrowing(model.getEmployeeId(), model.getBookId()), model.getBookId(), model.getEmployeeId(), new Date());
        commandGateway.sendAndWait(command);
        return "Book borrowing returned";
    }

    @PostMapping("/sendMessage")
    public void SendMessage(@RequestBody Message message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);
            output.send(MessageBuilder.withPayload(json).build());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
