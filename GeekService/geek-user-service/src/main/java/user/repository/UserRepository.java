package user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import user.entity.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);


    User findByUserId(String userId);

    List<User> findByUserIdIn(List<String> userIds);

}
