package ecommercespringlabs.springbootlabslab4.dto.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class AuthorRequestDto {
    @NotBlank(message = "Name is required.")
    @Size(max = 30, message = "Name must not exceed 99 characters.")
    String name;

    @NotBlank(message = "Phone number is required.")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be in a valid format, e.g., +1234567890.")
    String phoneNumber;

    @NotBlank(message = "Email is required.")
    @Email(message = "Please provide a valid email address.")
    String email;
}
