package com.alpha.ThoseEngineers.repositories.users;

import com.alpha.ThoseEngineers.modules.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT id FROM users WHERE name =:Name AND mob_no =:mobNo AND email_id =:emailId", nativeQuery = true)
    public int getUserId(String Name, Long mobNo, String emailId);
}