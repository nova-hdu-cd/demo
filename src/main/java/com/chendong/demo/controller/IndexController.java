package com.chendong.demo.controller;

import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.common.response.R;
import com.chendong.demo.controller.vo.EmpVO;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Api(value = "IndexController", tags = {"首页操作接口", "测试接口", "学习swagger注解的接口"})
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @ResponseBody
    @GetMapping("/addEmpV4")
    @ApiOperation(value = "添加员工V4", tags = {"添加员工V4"}, notes = "开发中")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id", name = "用户id", required = true),
            @ApiImplicitParam(value = "username", name = "用户名称", required = true)
    })
    public R<EmpVO> addEmpV4(@PathVariable("id") Long id, @PathVariable("username") String username) {
        return new R<>();
    }

    /**
     * @param id
     * @param username
     * @return
     */
    @ResponseBody
    @GetMapping("/addEmpV3")
    @ApiOperation(value = "添加员工V3", tags = {"添加员工V3"}, notes = "开发中")
    public R<EmpVO> addEmpV3(@ApiParam(name = "id", value = "用户id", example = "1111", required = true)
                             @PathVariable("id") Long id,
                             @ApiParam(name = "姓名", value = "姓名", example = "xioahua", required = true)
                             @PathVariable("username") String username) {
        return new R<>();
    }

    /**
     * 第一种
     *
     * @param empVO
     * @return
     */
    @ResponseBody
    @PostMapping("/addEmp")
    @ApiOperation(value = "添加员工", tags = {"添加员工"}, notes = "开发中", consumes = "application/json")
    public R<EmpVO> addEmp(@RequestBody @ApiParam(name = "员工vo", value = "员工vo", example = "empvo", required = true) EmpVO empVO) {

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
        vo.setUnisocId("8888888888888888");
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
