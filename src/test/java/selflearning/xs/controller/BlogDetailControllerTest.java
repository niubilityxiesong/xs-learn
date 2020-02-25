package selflearning.xs.controller;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import selflearning.xs.BaseTestSetup;
import selflearning.xs.SpringApplicationContext;
import selflearning.xs.dto.BlogDetailDTO;
import selflearning.xs.entity.BlogDetail;
import selflearning.xs.entity.User;
import selflearning.xs.repository.BlogDetailRepository;
import selflearning.xs.repository.UserRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BlogDetailControllerTest extends BaseTestSetup {

    @Autowired
    private BlogDetailRepository blogDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SpringApplicationContext springApplicationContext;

    private BlogDetailDTO blogDetailDTO;
    private User returnUser;

    @Override
    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        springApplicationContext.setApplicationContext(webApplicationContext);
        final User user = new User(1L,"xs", "12345678", "test", 0);
        returnUser = userRepository.save(user);
        blogDetailDTO = new BlogDetailDTO("test", "Test word length", "xs");
    }

    @Test
    void should_create_blog_detail() {
        given()
                .body(blogDetailDTO)
                .param("userId", returnUser.getId())
                .when()
                .post("/blog-detail")
                .then()
                .statusCode(HttpStatus.CREATED.value());

        final List<BlogDetail> blogDetails = blogDetailRepository.findAll();
        assertThat(blogDetails.size(), is(1));
        assertThat(blogDetails.get(0).getWordNumber(), is(16L));
        assertThat(blogDetails.get(0).getAuthor(), is("xs"));
        assertThat(blogDetails.get(0).getType(), is("test"));
    }

    @Test
    void should_add_article_number_when_create_a_blog() {
        given()
                .body(blogDetailDTO)
                .param("userId", returnUser.getId())
                .when()
                .post("/blog-detail")
                .then()
                .statusCode(HttpStatus.CREATED.value());

        final User result = userRepository.findAll().get(0);
        assertThat(result.getArticleNumber(), is(1));
    }

    @Test
    void should_throw_exception_when_user_id_do_not_exist() {
        given()
                .body(blogDetailDTO)
                .param("userId", 0L)
                .when()
                .post("/blog-detail")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}