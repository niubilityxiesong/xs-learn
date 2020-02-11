package selflearning.xs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selflearning.xs.dto.BlogDetailDTO;
import selflearning.xs.entity.BlogDetail;
import selflearning.xs.mapper.BlogDetailMapper;
import selflearning.xs.repository.BlogDetailRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BlogDetailService {
    private final BlogDetailRepository blogDetailRepository;
    private final BlogDetailMapper blogDetailMapper;

    public BlogDetail create(BlogDetailDTO blogDetailDTO) {
        final BlogDetail blogDetail = blogDetailMapper.DtoToBlogDetail(blogDetailDTO);
        return blogDetailRepository.save(blogDetail);
    }
}
