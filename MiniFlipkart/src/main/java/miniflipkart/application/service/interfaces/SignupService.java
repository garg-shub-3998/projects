package miniflipkart.application.service.interfaces;


import miniflipkart.application.qdos.SignupQdo;

// SignupService provides functionalities for signupService
public interface SignupService {

    boolean registerUser(SignupQdo signupBody);
}
