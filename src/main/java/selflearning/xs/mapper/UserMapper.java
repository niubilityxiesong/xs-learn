package selflearning.xs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import selflearning.xs.dto.UserDto;
import selflearning.xs.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User dtoToUser(UserDto userDto);
}
