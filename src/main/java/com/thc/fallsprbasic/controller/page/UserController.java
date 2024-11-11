package com.thc.fallsprbasic.controller.page;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;

@RequestMapping("/user")
@Controller
public class UserController {
//    @GetMapping("/create") //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public String create(){
//        return "user/create";
//    }
//    @GetMapping("/list") //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public String list(){
//        return "user/list";
//    }
//    @GetMapping("/detail/{id}") //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public String detail(@PathVariable String id){
//        return "user/detail";
//    }
//    @GetMapping("/login") //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public String login(){
//        return "user/login";
//    }
//
//    @GetMapping("/signup") //이 안에 있는 주소값은 꼭 유니크해야함!!
//    public String signup(){
//        return "user/signup";
//    }
    @GetMapping("/{page}")
    public String page(@PathVariable String page){
    return "user/" + page;
}

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "user/" + page;
    }
    @ResponseBody
    @GetMapping(value = "/image/{file_name:.+}")
    public byte[] getImage(@PathVariable("file_name") String file_name) {
        String root_path = "/Users/kimjisue/fallbasic/";
        byte[] return_byte = null;
        //해당 이미지를 byte[]형태로 반환
        File file = new File(root_path + file_name);
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            return_byte = IOUtils.toByteArray(in);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        }
        return return_byte;
    }

    @ResponseBody
    @RequestMapping(value = "/download/{file_name:.+}", method = RequestMethod.GET)
    public void download(@PathVariable("file_name") String file_name, HttpServletResponse response) throws IOException {
        String root_path = "/Users/kimjisue/fallbasic/";
        File file = new File(root_path + file_name);

        //여기는 response 에 설정해주는 부분인데, 어려우면 당분간은 패쓰!!
        String mimeType= URLConnection.guessContentTypeFromName(file_name);		//--- 파일의 mime타입을 확인합니다.
        if(mimeType==null){			//--- 마임타입이 없을 경우 application/octet-stream으로 설정합니다.
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);	//--- response에 mimetype을 설정합니다.
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\""+ URLEncoder.encode(file.getName(), "utf-8") +"\"");
        //

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));	//--- inputstream 객체를 얻습니다.
        FileCopyUtils.copy(inputStream, response.getOutputStream());		//--- inputstream으로 파일을 읽고 outputsream으로 파일을 씁니다.
    }

}

