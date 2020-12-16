package miniflipkart.application.entities.repository;


import miniflipkart.application.entities.models.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,Integer> {

    // Find the UserToken by token
    @Query(value="SELECT j FROM UserToken j WHERE j.token = :token")
    public UserToken getByToken(@Param("token") String token);
}
