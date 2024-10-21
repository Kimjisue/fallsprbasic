package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.dto.FaqDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface FaqService {

    FaqDto.CreateResDto create(FaqDto.CreateReqDto param);

    void update(FaqDto.UpdateReqDto params);
    void delete(Long id);
    List<FaqDto.DetailResDto> list(FaqDto.ListReqDto param);
    FaqDto.DetailResDto detail(Long id);
}
