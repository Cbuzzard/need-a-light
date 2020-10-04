package com.buzzardsview.needalight.data;

import com.buzzardsview.needalight.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> getByGoogleId(String id);

}