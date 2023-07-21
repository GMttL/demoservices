package com.gabrielmttl.notification.service;


import com.gabrielmttl.clients.notification.NotificationRequest;
import com.gabrielmttl.notification.entity.Notification;
import com.gabrielmttl.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    public final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .to_customer_id(notificationRequest.toCustomerId())
                        .to_customer_email(notificationRequest.toCustomerName())
                        .sender("gabrielmttl")
                        .message(notificationRequest.message())
                        .sent_at(LocalDateTime.now())
                        .build()
        );

    }
}
