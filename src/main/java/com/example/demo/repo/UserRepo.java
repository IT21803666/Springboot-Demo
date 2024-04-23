package com.example.demo.repo;

import com.example.demo.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<user, Integer> { //user - entity name
//integer - primary key data type

    @Query(value="SELECT * FROM USER WHERE ID = ?1", nativeQuery = true)
    user getUserByID(String userId);

    @Query(value = "SELECT * FROM USER WHERE ID = ?1 AND ADDRESS = ?2", nativeQuery = true)
    user getUserByIDAndAddress(String userID,String address);

}
