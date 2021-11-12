package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NumberRepository extends JpaRepository<Number, Integer> {
    @Query(value = "select * from NUMBER_AUTO  where key_number like :code% order by number_sequence desc limit 1", nativeQuery = true)
    Number getNumbers(String code);

    @Query(value = "SELECT *\n" +
            "FROM (SELECT * FROM NUMBER_AUTO where key_number like :code% ORDER BY number_sequence desc )\n" +
            "WHERE ROWNUM = 1",nativeQuery = true)
    Number getNumber(String code);

}
