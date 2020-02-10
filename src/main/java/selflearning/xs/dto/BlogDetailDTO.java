package selflearning.xs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDetailDTO {
    private String type;
    private Long wordNumber;
    private String author;
}
