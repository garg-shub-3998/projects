package SpringBoot.MiniFlipkart.application.config.token;

public class TokenRdo {

    private String token;

    public TokenRdo(){

    }

    public TokenRdo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
