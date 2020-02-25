package selflearning.xs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selflearning.xs.dto.UserDto;
import selflearning.xs.entity.User;
import selflearning.xs.exceptions.UserIdNotExistException;
import selflearning.xs.mapper.UserMapper;
import selflearning.xs.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User create(UserDto userDto) {
        final User user = userMapper.dtoToUser(userDto);
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        final Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserIdNotExistException(String.format("userId: %d do not exist", id), id);
        }
    }
}
