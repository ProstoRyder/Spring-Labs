package ecommercespringlabs.springbootlabslab4.dto.author;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorResponseDto {
    String id;
    String name;
    String phoneNumber;
    String email;
}
