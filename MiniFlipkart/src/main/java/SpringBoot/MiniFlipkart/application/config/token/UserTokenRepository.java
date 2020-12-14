package SpringBoot.MiniFlipkart.application.config.token;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,Integer> {

    @Query(value="SELECT j FROM UserToken j WHERE j.token = :t")
    public UserToken getByToken(@Param("t") String token);
}
