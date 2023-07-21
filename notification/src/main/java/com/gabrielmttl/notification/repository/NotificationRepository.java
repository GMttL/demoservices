package com.gabrielmttl.notification.repository;

import com.gabrielmttl.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
