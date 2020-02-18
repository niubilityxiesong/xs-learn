package selflearning.xs.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import selflearning.xs.BaseTestSetup;
import selflearning.xs.dto.UserDto;
import selflearning.xs.entity.User;
import selflearning.xs.repository.UserRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class UserControllerTest extends BaseTestSetup {

    @Autowired
    private UserRepository userRepository;

    @Test
    void should_create_a_user() {
        final UserDto userDto = new UserDto("xs", "12345678", "test");
        given()
                .body(userDto)
                .when()
                .post("user")
                .then()
                .statusCode(HttpStatus.CREATED.value());

        final List<User> users = userRepository.findAll();
        assertThat(users.size(), is(1));
        final User user = users.get(0);
        assertThat(user.getArticleNumber(), is(0));
        assertThat(user.getUsername(), is("xs"));
    }
}