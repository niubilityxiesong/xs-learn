package selflearning.xs.event;

import org.springframework.context.ApplicationEvent;
import selflearning.xs.entity.User;

public class UserEvent extends ApplicationEvent {
    private static final long serialVersionUID = 123456789L;
    private User user;

    public UserEvent(User source) {
        super(source);
        this.user = source;
    }

    public User getUser() {
        return user;
    }
}
