package com.banque.application.blacklist.repository;

import com.banque.application.entity.blacklist.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList,Long> {

    @Query("select u from BlackList u where u.cin = ?1")
    BlackList findByCin(long cin);
}
