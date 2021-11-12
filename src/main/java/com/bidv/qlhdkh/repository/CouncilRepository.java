package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Council;
import com.bidv.qlhdkh.model.CouncilDtoModel;
import com.bidv.qlhdkh.model.CouncilModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouncilRepository extends JpaRepository<Council, Integer> {
    @Query(value = "select  c from Council  c where c.Id = :id")
    Optional<Council> getCouncil(int id);

}
