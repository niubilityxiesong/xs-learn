package selflearning.xs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selflearning.xs.dto.UserDto;
import selflearning.xs.entity.User;
import selflearning.xs.mapper.UserMapper;
import selflearning.xs.repository.UserRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User create(UserDto userDto) {
        final User user = userMapper.dtoToUser(userDto);
        return userRepository.save(user);
    }
}
