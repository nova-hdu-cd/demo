package com.chendong.demo.controller;

import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.common.response.R;
import com.chendong.demo.controller.vo.EmpVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
//@SwaggerIgnore TODO 为啥失效了？
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 第一种
     *
     * @param empVO
     * @return
     */
    @ResponseBody
    @PostMapping("/addEmp")
    public R<EmpVO> addEmp(@RequestBody EmpVO empVO) {

        //模拟业务过程
        EmpVO vo = new EmpVO();
        vo.setName("chendong");
        vo.setAge(26);

        return R.success(vo);
    }

    /**
     * 第二种返回
     *
     * @param empVO
     * @return
     */
    @ResponseResult
    @ResponseBody
    @PostMapping("/getEmp")
    public EmpVO getEmp(@RequestBody EmpVO empVO) {

        EmpVO vo = new EmpVO();
        vo.setName("chendong");
        vo.setAge(26);
        vo.setUnisocId("12125");
        //vo = null;

        return Optional.ofNullable(vo).orElse(new EmpVO());


    }

    @ResponseResult
    @ResponseBody
    @PostMapping("/getEmpV2")
    public Map<String, Integer> getEmpV2(@RequestBody EmpVO empVO) {

        EmpVO vo = new EmpVO();
        vo.setName("chendong");
        vo.setAge(26);
        vo.setUnisocId("12125");

        EmpVO vo2 = new EmpVO();
        vo2.setName("xiaoming");
        vo2.setAge(25);
        vo2.setUnisocId("12124");

        List<EmpVO> emps = new ArrayList<>(10);
        emps.add(vo);
        emps.add(vo2);

        Map<String, Integer> collect = emps.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getAge()));

        String name = Optional.ofNullable(vo).map(s -> s.getName()).map(s -> s.trim().toUpperCase()).orElse("");

        EmpVO value = new EmpVO();
        value.setName(name);
        return collect;


    }

}
