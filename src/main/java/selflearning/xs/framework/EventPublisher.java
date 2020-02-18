package selflearning.xs.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventPublisher implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher publisher;

    public static void publish(ApplicationEvent event) {
        if (event != null) {
            publisher.publishEvent(event);
            log.info("publish name: {}", event.getClass().getSimpleName());
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
