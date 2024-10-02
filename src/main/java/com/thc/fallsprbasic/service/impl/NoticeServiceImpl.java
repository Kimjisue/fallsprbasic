package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Notice;
import com.thc.fallsprbasic.dto.NoticeDto;
import com.thc.fallsprbasic.repository.NoticeRepository;
import com.thc.fallsprbasic.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    public NoticeServiceImpl(
            NoticeRepository noticeRepository
    ) {
        this.noticeRepository = noticeRepository;
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
       if(param.getTitle() !=null){
           notice.setTitle(param.getTitle());
       }
        if(param.getContent() !=null){
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

    @Override
    public List<Notice> listNotice() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList;
    }

    @Override
    public Notice detailNotice(Long id) {
        return noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }
}
