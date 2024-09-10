package com.thc.fallsprbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thc.fallsprbasic.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {
}
