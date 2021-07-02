package jp.co.cybermissions.itspj.java.myapp.models;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Collection<Review>findByCategoryOrderById(String category);

    
}
