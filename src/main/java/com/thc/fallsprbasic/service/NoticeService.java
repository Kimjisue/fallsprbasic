package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.domain.Notice;
import com.thc.fallsprbasic.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NoticeService {

    NoticeDto.CreateResDto createNotice(NoticeDto.CreateReqDto param);

    void updateNotice(NoticeDto.UpdateReqDto params);
    Map<String, Object> deleteNotice(Long id);
    List<NoticeDto.DetailResDto> list();
    NoticeDto.DetailResDto detail(Long id);
}
