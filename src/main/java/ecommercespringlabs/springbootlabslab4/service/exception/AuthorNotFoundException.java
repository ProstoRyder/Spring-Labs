package ecommercespringlabs.springbootlabslab4.service.exception;

public class AuthorNotFoundException extends RuntimeException{
    public static final String Author_NOT_FOUND_MESSAGE = "Author with ID %s Not found";
    public AuthorNotFoundException(String id) {
        super(String.format(Author_NOT_FOUND_MESSAGE, id));
    }
}
