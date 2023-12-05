package com.example.fcmtest.fcm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FcmController {
    private final NotificationService notificationService;

    public FcmController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/send-push")
    public String sendNotification() {
        return notificationService.sendNotification();
    }
}
