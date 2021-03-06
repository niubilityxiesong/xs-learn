package selflearning.xs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import selflearning.xs.dto.BlogDetailDTO;
import selflearning.xs.entity.BlogDetail;
import selflearning.xs.entity.User;
import selflearning.xs.exceptions.UserIdNotExistException;
import selflearning.xs.repository.UserRepository;
import selflearning.xs.service.BlogDetailService;
import selflearning.xs.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/blog-detail")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BlogDetailController {

    private final BlogDetailService blogDetailService;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogDetail createBlog(@RequestBody BlogDetailDTO blogDetail, @RequestParam Long userId) {
        final User user = userService.getUserById(userId);
        return blogDetailService.create(blogDetail, user);
    }
}
