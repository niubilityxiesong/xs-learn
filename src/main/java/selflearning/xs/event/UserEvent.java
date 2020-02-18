package selflearning.xs.event;

import org.springframework.context.ApplicationEvent;
import selflearning.xs.entity.User;

public class UserEvent extends ApplicationEvent {
    private User user;

    public UserEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
