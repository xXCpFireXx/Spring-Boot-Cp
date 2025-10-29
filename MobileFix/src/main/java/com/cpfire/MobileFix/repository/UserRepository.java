package com.cpfire.MobileFix.repository;

import com.cpfire.MobileFix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
