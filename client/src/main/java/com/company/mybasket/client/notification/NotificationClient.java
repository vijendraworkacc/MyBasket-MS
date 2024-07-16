package com.company.mybasket.client.notification;

import com.company.mybasket.client.response.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "notification-application",
        path = "api/v1/notification"
)
public interface NotificationClient {
    @PostMapping(path = "send-email")
    public SuccessResponse sendEmail(
            @RequestParam(name = "sender_email") String senderEmail,
            @RequestParam(name = "receiver_email") String receiverEmail);
}
