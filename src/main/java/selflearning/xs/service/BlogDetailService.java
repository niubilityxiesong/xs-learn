package selflearning.xs.service;

import org.springframework.stereotype.Service;
import selflearning.xs.dto.BlogDetailDTO;
import selflearning.xs.entity.BlogDetail;
import selflearning.xs.repository.BlogDetailRepository;

@Service
public class BlogDetailService {
    private final BlogDetailRepository blogDetailRepository;

    public BlogDetailService(BlogDetailRepository blogDetailRepository) {
        this.blogDetailRepository = blogDetailRepository;
    }

    public BlogDetail create(BlogDetailDTO blogDetailDTO) {
        final BlogDetail blogDetail = new BlogDetail();
        blogDetail.setAuthor(blogDetailDTO.getAuthor());
        blogDetail.setType(blogDetailDTO.getType());
        blogDetail.setWordNumber(blogDetailDTO.getWordNumber());
        return blogDetailRepository.save(blogDetail);
    }
}
