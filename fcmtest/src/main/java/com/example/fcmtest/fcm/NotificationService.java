package com.example.fcmtest.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public String sendNotification() {
        try {
            Notification notification = Notification.builder()
                    .setTitle("건조기 알림")
                    .setBody("건조기의 동작이 완료되었습니다.")
                    .build();

            Message message = Message.builder()
                    .setNotification(notification)
                    .setTopic("건조기")
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            return response;
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

