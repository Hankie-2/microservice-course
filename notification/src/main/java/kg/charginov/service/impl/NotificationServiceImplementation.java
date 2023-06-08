package kg.charginov.service.impl;

import kg.charginov.model.entity.Notification;
import kg.charginov.notification.NotificationRequest;
import kg.charginov.repository.NotificationRepository;
import kg.charginov.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public record NotificationServiceImplementation
        (NotificationRepository notificationRepository)  implements NotificationService {

    @Override
    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .message(notificationRequest.message())
                .sender(notificationRequest.sender())
                .sentAt(LocalDateTime.now())
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .build();
        log.info("Created notification {}",notification);
        notificationRepository.save(notification);
    }
}
