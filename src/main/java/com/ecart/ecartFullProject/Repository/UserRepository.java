package com.ecart.ecartFullProject.Repository;

import com.ecart.ecartFullProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
