package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.domain.Notice;
import com.thc.fallsprbasic.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/create") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Map<String, Object> createNotice(@RequestParam Map<String , Object>params){
        return noticeService.createNotice(params);
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
    @GetMapping("/update") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Map<String,Object> updateNotice(@RequestParam Map<String,Object> params){
        return noticeService.updateNotice(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> deleteNotice(@RequestParam Map<String, Object> params){
        return noticeService.deleteNotice(Long.parseLong(params.get("id") + ""));
    }




}
