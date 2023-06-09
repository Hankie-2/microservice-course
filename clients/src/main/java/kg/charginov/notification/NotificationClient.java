package kg.charginov.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        value = "notification",
        path = "api/v1/notifications")
public interface NotificationClient {

    @PostMapping
    void sendNotification(NotificationRequest notificationRequest);

}
