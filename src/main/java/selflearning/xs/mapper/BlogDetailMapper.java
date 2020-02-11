package selflearning.xs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import selflearning.xs.dto.BlogDetailDTO;
import selflearning.xs.entity.BlogDetail;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogDetailMapper {
    BlogDetail DtoToBlogDetail(BlogDetailDTO blogDetailDTO);
}
