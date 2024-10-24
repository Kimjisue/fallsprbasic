package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Notice;
import com.thc.fallsprbasic.dto.NoticeDto;
import com.thc.fallsprbasic.mapper.NoticeMapper;
import com.thc.fallsprbasic.repository.NoticeRepository;
import com.thc.fallsprbasic.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;

    public NoticeServiceImpl(
            NoticeRepository noticeRepository
            , NoticeMapper noticeMapper
    ) {
        this.noticeRepository = noticeRepository;
        this.noticeMapper = noticeMapper;
    }

    @Override
    public NoticeDto.CreateResDto createNotice(NoticeDto.CreateReqDto param) {

        System.out.println("createNotice");
//        Notice notice = param.toEntity();
//        notice = noticeRepository.save(notice);
//
//        NoticeDto.CreateReqDto resDto = notice.toCreateResDto;
//        return resDto;
        return noticeRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void updateNotice(NoticeDto.UpdateReqDto param) {
        System.out.println("update");
        Notice notice = noticeRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if (param.getTitle() != null) {
            notice.setTitle(param.getTitle());
        }
        if (param.getContent() != null) {
            notice.setContent(param.getContent());
        }
        noticeRepository.save(notice);
    }

    @Override
    public Map<String, Object> deleteNotice(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        noticeRepository.delete(notice);
        return null;
    }

//    public NoticeDto.DetailResDto entityToDto(Notice notice){
//        //돌려줄 디티오에 정보를 담아보겠습니다. (실제로는 Mapper를 사용할 것이라, 이렇게는 잘 안씀)
//        NoticeDto.DetailResDto res = new NoticeDto.DetailResDto();
//        res.setId(notice.getId());
//        res.setTitle(notice.getTitle());
//        res.setContent(notice.getContent());
//        return res;
//    }

    @Override
    public NoticeDto.DetailResDto detail(Long id) {
        NoticeDto.DetailResDto reurnVal = noticeMapper.detail(id);
        return reurnVal;
//        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
//        return entityToDto(notice);
    }


    @Override
    public List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto param) {
        List<NoticeDto.DetailResDto> list = noticeMapper.list(param);
        return list;
    }
}
