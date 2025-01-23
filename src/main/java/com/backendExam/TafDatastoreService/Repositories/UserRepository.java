package com.backendExam.TafDatastoreService.Repositories;

import com.backendExam.TafDatastoreService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
}
