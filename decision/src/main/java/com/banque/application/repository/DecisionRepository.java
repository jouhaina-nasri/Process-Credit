package com.banque.application.repository;

import com.banque.application.entity.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecisionRepository extends JpaRepository<Decision,Long> {
    @Query("select u from Decision u where u.reference = ?1")
    Decision findDecision(Long reference);
}
