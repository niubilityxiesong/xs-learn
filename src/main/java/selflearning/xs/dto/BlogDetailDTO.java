package selflearning.xs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDetailDTO {
    private String type;
    private String content;
    private String author;

    public Long getWordNumber() {
        return (long) this.content.length();
    }
}
