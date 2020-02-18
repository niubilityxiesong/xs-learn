package selflearning.xs.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import selflearning.xs.entity.User;
import selflearning.xs.event.UserEvent;
import selflearning.xs.repository.UserRepository;

@Component
@AllArgsConstructor
@Slf4j
public class UserListener implements ApplicationListener<UserEvent> {

    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        log.info("im in user event");
        final User user = userEvent.getUser();
        user.setArticleNumber(user.getArticleNumber() + 1);
        userRepository.save(user);
    }
}
