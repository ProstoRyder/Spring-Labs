package ecommercespringlabs.springbootlabslab4.service.exception;

public class CategoryNotFoundException extends RuntimeException{
    public static final String Category_NOT_FOUND_MESSAGE = "Category with ID %s Not found";
    public CategoryNotFoundException(String id) {
        super(String.format(Category_NOT_FOUND_MESSAGE, id));
    }
}
