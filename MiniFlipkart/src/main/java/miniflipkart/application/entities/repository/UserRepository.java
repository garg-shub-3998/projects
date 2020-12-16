package miniflipkart.application.entities.repository;

import miniflipkart.application.entities.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Find the User by userName and pasword
    @Query(value = "SELECT u FROM User u WHERE u.userName = :userName and u.password = :password")
    public User getByUsernamePassword(@Param("userName") String userName, @Param("password") String password);

    // Find the User by userName
    @Query(value = "SELECT u FROM User u WHERE u.userName = :userName")
    public User findByUsername(@Param("userName") String userName);

    // Find the User by email
    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    public User findByEmail(@Param("email") String email);

    // Find the User by phoneNumber
    @Query(value = "SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber")
    public User findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
