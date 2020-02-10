package selflearning.xs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import selflearning.xs.dto.BlogDetailDTO;
import selflearning.xs.entity.BlogDetail;
import selflearning.xs.service.BlogDetailService;

@RestController
@RequestMapping("/blog-detail")
public class BlogDetailController {
    private final BlogDetailService blogDetailService;

    public BlogDetailController(BlogDetailService blogDetailService) {
        this.blogDetailService = blogDetailService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogDetail createBlog(@RequestBody BlogDetailDTO blogDetail) {
        return blogDetailService.create(blogDetail);
    }
}
