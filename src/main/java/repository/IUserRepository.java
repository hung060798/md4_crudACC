package repository;

import model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IUserRepository extends PagingAndSortingRepository <User, Integer>{
    @Query(value = "select u from User as u where u.userName like  concat('%', :userName ,'%') ")
    ArrayList<User> findAllByName(@Param("userName") String userName);
}
