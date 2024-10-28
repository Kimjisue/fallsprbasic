package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.domain.Faq;
import com.thc.fallsprbasic.domain.Notice;
import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.FaqDto;
import com.thc.fallsprbasic.dto.NoticeDto;
import com.thc.fallsprbasic.service.FaqService;
import com.thc.fallsprbasic.service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/faq")
@RestController
public class FaqRestController {
    private final FaqService faqService;
    public FaqRestController(
            FaqService faqService
    ) {
        this.faqService = faqService;
    }
    //원래 방법 but 이제는 이렇게 안쓴다.
    //    @PostMapping("") //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public FaqDto.CreateResDto create(@RequestBody FaqDto.CreateReqDto param){
//        return faqService.create(param);
//    }

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody FaqDto.CreateReqDto param){
        return ResponseEntity.ok(faqService.create(param));
    }

    @PutMapping("") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public ResponseEntity<String> update(@RequestBody FaqDto.UpdateReqDto param){
        faqService.update(param);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("")
    public ResponseEntity<String> delete(@RequestBody NoticeDto.UpdateReqDto param){
        faqService.delete(param.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detail")
    public ResponseEntity<FaqDto.DetailResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(faqService.detail(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<FaqDto.DetailResDto>> list(FaqDto.ListReqDto param){
        return ResponseEntity.ok(faqService.list(param));
    }

}
