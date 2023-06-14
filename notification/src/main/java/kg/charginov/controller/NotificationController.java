package kg.charginov.controller;

import kg.charginov.notification.NotificationRequest;
import kg.charginov.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notifications")
@Slf4j
public record NotificationController(NotificationService notificationService) {
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request){
        log.info("Send notification {}",request);
        notificationService.sendNotification(request);
    }

}
