package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.dto.FaqDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface FaqService {

    FaqDto.CreateResDto create(FaqDto.CreateReqDto param);

    void update(FaqDto.UpdateReqDto params);
    Map<String, Object> delete(Long id);
    List<FaqDto.DetailResDto> list();
    FaqDto.DetailResDto detail(Long id);
}
