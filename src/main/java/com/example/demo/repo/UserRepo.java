package com.example.demo.repo;


import com.example.demo.model.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


    @Query(value="SELECT *ALL *FROM USER WHERE id=?1",nativeQuery = true)
    User getUserBy(Integer  userId);
}
