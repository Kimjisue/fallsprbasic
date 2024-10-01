package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.domain.Notice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NoticeService {
    Map<String, Object> createNotice(Map<String, Object> params);
    Map<String, Object> updateNotice(Map<String, Object> params);
    Map<String, Object> deleteNotice(Long id);
    List<Notice> listNotice();
    Notice detailNotice(Long id);
}
