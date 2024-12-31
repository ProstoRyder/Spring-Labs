package ecommercespringlabs.springbootlabslab4.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Author {
    String id;
    String name;
    String phoneNumber;
    String email;
}
