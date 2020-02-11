package selflearning.xs;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;
import selflearning.xs.repository.BlogDetailRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = XsApplication.class)
@ActiveProfiles("test")
public class BaseTestSetup {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SpringApplicationContext springApplicationContext;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        springApplicationContext.setApplicationContext(webApplicationContext);
    }

    protected MockMvcRequestSpecification given() {
        return RestAssuredMockMvc
                .given()
                .header("Accept", ContentType.JSON.withCharset("UTF-8"))
                .header("Content-Type", ContentType.JSON.withCharset("UTF-8"));
    }

    @AfterEach
    public void cleanUp() {
        SpringApplicationContext.getBean(BlogDetailRepository.class).deleteAll();
    }
}
