package kg.charginov.service;

import kg.charginov.notification.NotificationRequest;

public interface NotificationService {
    void sendNotification(NotificationRequest notificationRequest);
}
