package com.company.mybasket.notification.controller;

import com.company.mybasket.client.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping(path = "api/v1/notification")
@RestController
public class NotificationController {

    @PostMapping(path = "send-email")
    public SuccessResponse sendEmail(
            @RequestParam(name = "sender_email") String senderEmail,
            @RequestParam(name = "receiver_email") String receiverEmail) {
        // Logic to send the email
        return SuccessResponse.builder()
                .message("Email sent")
                .status(HttpStatus.OK)
                .data("Email sent to " + receiverEmail)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
