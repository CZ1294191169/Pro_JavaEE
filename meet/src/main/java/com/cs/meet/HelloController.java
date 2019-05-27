package com.cs.meet;


import com.cs.meet.entity.girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class HelloController {

//    //@RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
//    //@RequestMapping(value = {"/index/{id}"},method = RequestMethod.GET)
//
//    @Autowired
//    girlRes res;
//
//    @RequestMapping(value = {"/index"},method = RequestMethod.GET)
//    //@GetMapping代替上面的写法还有@PostMapping
//    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
//        List<girl> girlList = res.findAll();
//        String temp=null;
//        for(int i=0;i<girlList.size();i++) {
//            temp+=girlList.get(i).toString();
//        }
//        return  temp;
//    }
//
//    @PostMapping(value = "/saveone")
//    public void Saveone(@RequestParam("cupsize") Integer cupsize)
//    {
//        girl g = new girl();
//        g.setCupsize(cupsize);
//        res.save(g);
//    }
//
//    @PostMapping(value = "/findone/{id}")
//    public Optional<girl> find(@PathVariable("id") Integer id)
//    {
//       return res.findById(id);
//    }
//
//    @PostMapping(value = "/update/{id}")
//    public void  update(@RequestParam("cupsize") Integer cupsize,
//                        @PathVariable("id") Integer id){
//        girl g = new girl();
//        g.setId(id);
//        g.setCupsize(cupsize);
//        res.save(g);
//    }
}
