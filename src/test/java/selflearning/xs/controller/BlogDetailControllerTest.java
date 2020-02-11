package selflearning.xs.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import selflearning.xs.BaseTestSetup;
import selflearning.xs.dto.BlogDetailDTO;
import selflearning.xs.entity.BlogDetail;
import selflearning.xs.repository.BlogDetailRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BlogDetailControllerTest extends BaseTestSetup {

    @Autowired
    private BlogDetailRepository blogDetailRepository;

    @Test
    void should_create_blog_detail() {
        final BlogDetailDTO blogDetailDTO = new BlogDetailDTO("test", 200L, "xsTest");
        given()
                .body(blogDetailDTO)
                .when()
                .post("/blog-detail")
                .then()
                .statusCode(HttpStatus.CREATED.value());

        final List<BlogDetail> blogDetails = blogDetailRepository.findAll();
        assertThat(blogDetails.size(), is(1));
        assertThat(blogDetails.get(0).getWordNumber(), is(200L));
        assertThat(blogDetails.get(0).getAuthor(), is("xsTest"));
        assertThat(blogDetails.get(0).getType(), is("test"));
    }
}