package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Faq;
import com.thc.fallsprbasic.domain.User;
import com.thc.fallsprbasic.dto.FaqDto;
import com.thc.fallsprbasic.mapper.FaqMapper;
import com.thc.fallsprbasic.repository.FaqRepository;
import com.thc.fallsprbasic.repository.UserRepository;
import com.thc.fallsprbasic.service.FaqService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FaqServiceImpl implements FaqService {

    private final FaqRepository faqRepository;
    private final FaqMapper faqMapper;
    private final UserRepository userRepository;
    public FaqServiceImpl(
            FaqRepository faqRepository
            , FaqMapper faqMapper
            ,UserRepository userRepository
    ) {
        this.faqRepository = faqRepository;
        this.faqMapper = faqMapper;
        this.userRepository = userRepository;

    }

    @Override
    public FaqDto.CreateResDto create(FaqDto.CreateReqDto param) {

        return faqRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(FaqDto.UpdateReqDto param) {
       Faq faq = faqRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
       if(param.getTitle() !=null){
           faq.setTitle(param.getTitle());
       }
        if(param.getContent() !=null){
            faq.setContent(param.getContent());
        }
        faqRepository.save(faq);
    }

    @Override
    public void delete(Long id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        faqRepository.delete(faq);
    }

//    public FaqDto.DetailResDto entityToDto(Faq faq){
//        //돌려줄 디티오에 정보를 담아보겠습니다. (실제로는 Mapper를 사용할 것이라, 이렇게는 잘 안씀)
//        FaqDto.DetailResDto res = new FaqDto.DetailResDto();
//        res.setId(faq.getId());
//        res.setTitle(faq.getTitle());
//        res.setContent(faq.getContent());
//        res.setUserId(faq.getUserId());
//        //사용자 id 값을 가져올 수 있다.
//        Long userId = faq.getUserId();
//        try{
//            User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException(""));
//            res.setUserUsername((user.getUsername()));
//        }catch(Exception e){
//
//        }
//
//        return res;
//    }

    @Override
    public FaqDto.DetailResDto detail(Long id) {
//        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
//        return entityToDto(faq);
        return faqMapper.detail(id);
    }


    @Override
    public List<FaqDto.DetailResDto> list(FaqDto.ListReqDto param) {
        return faqMapper.list(param);
//        List<FaqDto.DetailResDto> list = new ArrayList<FaqDto.DetailResDto>();
//        List<Faq> faqList = faqRepository.findAll();
//        for(Faq faq : faqList) {
//            list.add(entityToDto(faq));
//        }
//        return list;
    }
}
