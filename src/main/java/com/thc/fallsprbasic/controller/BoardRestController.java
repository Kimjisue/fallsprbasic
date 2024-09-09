package com.thc.fallsprbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {
    List<Map<String,Object>> boardList = new ArrayList<>();

    @GetMapping("/create") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Map<String, Object> create(@RequestParam Map<String , Object>params){
        String title = (String) params.get("title");
        String content = params.get("content") + "";
        String author= params.get("author") + "";
        int order = boardList.size();

        Map<String, Object> boardMap = new HashMap<>();
        boardMap.put("order",++order);
        boardMap.put("title",title);
        boardMap.put("content",content);
        boardMap.put("author",author);
        boardList.add(boardMap)
;
        System.out.println(boardList);

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("resultCode",200);
        return resultMap;
    }
    @GetMapping("/list") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public List<Map<String,Object>> list(){
        return boardList;
    }

    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Map<String,Object> detail(@RequestParam String order){
        int index = Integer.parseInt(order) -1;
        Map<String,Object> boardMap = boardList.get(index);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        resultMap.put("detail_board", boardMap);

        return resultMap;
    }
    @GetMapping("/update") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Map<String,Object> update(@RequestParam Map<String,Object> params){
        int index = Integer.parseInt(params.get("order")+"") -1;
        Map<String,Object> boardMap = boardList.get(index);
        boardMap.put("title",params.get("title"));
        boardMap.put("content",params.get("content"));
        boardMap.put("author",params.get("author"));


        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        resultMap.put("detail_board", boardMap);

        return resultMap;
    }




//    @GetMapping("/mapTest") //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public Map<String, Object> mapTest(){
//        Map<String, Object> a_map = new HashMap<String, Object>();
//        a_map.put("hint", "praggre");
//        a_map.put("hint1", "t");
//        System.out.println(a_map);
//        Object value = a_map.get("hint");
//        Object value2 = a_map.get("hint3");
//        System.out.println(value);
//        a_map.remove("hint");
//        System.out.println(a_map);
//        return a_map;
//    }
    @GetMapping("/listTest") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public List<String> listTest(@RequestParam int item1, @RequestParam int item2){
        System.out.println("item1 : " + item1);
        System.out.println("item2 : " + item2);

        int sum = item1 + item2;

        List<String> a_list = new ArrayList();
        a_list.add("sum : " + sum);
        /*a_list.add("11");
        a_list.add("22");
        a_list.add("33");
        a_list.add("44");*/
        int a_size = a_list.size();
        System.out.println(a_list.get(0));
        return a_list;
    }
    @GetMapping("/paramTest") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Map<String, Object> paramTest(@RequestParam Map<String, Object> map){
        System.out.println("item1 : " + map.get("item1"));
        System.out.println("item2 : " + map.get("item2"));

        //int sum = Integer.parseInt(map.get("item1") + "") + Integer.parseInt(map.get("item2") + "");

        Map<String, Object> map_result = new HashMap<String, Object>();
        map_result.put("item1", map.get("item1"));
        map_result.put("item2", map.get("item2"));
        return map_result;
    }
}
