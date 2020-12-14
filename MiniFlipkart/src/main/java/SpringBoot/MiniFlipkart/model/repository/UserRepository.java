package SpringBoot.MiniFlipkart.model.repository;

import SpringBoot.MiniFlipkart.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.userName = :un and u.password = :pass")
    public User getByUsernamePassword(@Param("un") String username, @Param("pass") String password);

    @Query(value = "SELECT u FROM User u WHERE u.userName = :un")
    public User findByUsername(@Param("un") String username);

    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    public User findByEmail(@Param("email") String email);

    @Query(value = "SELECT u FROM User u WHERE u.phoneNumber = :pn")
    public User findByPhoneNumber(@Param("pn") String phonenumber);

}
