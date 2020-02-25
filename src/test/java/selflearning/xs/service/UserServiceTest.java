package selflearning.xs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import selflearning.xs.exceptions.UserIdNotExistException;
import selflearning.xs.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void should_return_exception_when_user_id_not_exist() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        final UserIdNotExistException ex = assertThrows(UserIdNotExistException.class,
                () -> userService.getUserById(userId));
        assertEquals("userId: 1 do not exist", ex.getMessage());
        assertEquals(userId, ex.getUserId());
    }
}