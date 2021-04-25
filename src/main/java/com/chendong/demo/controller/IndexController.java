package com.chendong.demo.controller;

import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.common.response.R;
import com.chendong.demo.controller.vo.EmpVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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

        return vo;
    }

}
