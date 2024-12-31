package ecommercespringlabs.springbootlabslab4.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    String  id;
    String title;
}
