package com.thc.fallsprbasic.repository;

import com.thc.fallsprbasic.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
