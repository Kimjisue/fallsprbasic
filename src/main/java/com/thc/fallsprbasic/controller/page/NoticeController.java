package com.thc.fallsprbasic.controller.page;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notice")
@Controller
public class NoticeController {
    @GetMapping("/create") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String createNotice(){
        return "notice/create";
    }
    @GetMapping("/list") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String listNotice(){
        return "notice/list";
    }
    @GetMapping("/detail/{id}") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String detailNotice(@PathVariable String id){
        return "notice/detail";
    }



    //PathVariable => URL에 있는 값을 변수로 받아올 수 있는 기능이다.
    //이렇게도 사용 가능하다 하지만 선호하지는 않음
//    @GetMapping("/{page}")
//    public String page(@PathVariable String page){return "board/"+ page;}
//
//    @GetMapping("/{page}/id")
//    public String page2(@PathVariable String page, @PathVariable String id){
//        return "board/"+ page;
//    }
}
