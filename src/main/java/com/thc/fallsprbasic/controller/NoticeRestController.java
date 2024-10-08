package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.domain.Notice;
import com.thc.fallsprbasic.dto.NoticeDto;
import com.thc.fallsprbasic.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/notice")
@RestController
public class NoticeRestController {
    private final NoticeService noticeService;
    public NoticeRestController(
            NoticeService noticeService
    ) {
        this.noticeService = noticeService;
    }


//    @GetMapping("/create") //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public Map<String, Object> createNotice(@RequestParam Map<String , Object>params){
//        return noticeService.createNotice(params);
//    }
    //create - post
    //update - put

    @PostMapping("") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public NoticeDto.CreateResDto createNotice(@RequestBody NoticeDto.CreateReqDto param){
        return noticeService.createNotice(param);
    }
    @PutMapping("") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public void updateNotice(@RequestBody NoticeDto.UpdateReqDto param){
        noticeService.updateNotice(param);
    }
    @DeleteMapping("")
    public void deleteNotice(@RequestBody NoticeDto.UpdateReqDto param){
        noticeService.deleteNotice(param.getId());
    }

    @GetMapping("/list") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public List<Notice> listNotice(){
        return noticeService.listNotice();
        //return boardList;
    }

    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    Notice detailNotice(@RequestParam Long id){
        return noticeService.detailNotice(id);
    }





}
