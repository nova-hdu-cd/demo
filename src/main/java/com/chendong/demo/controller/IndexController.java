package com.chendong.demo.controller;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.domain.dto.InfoDTO;
import com.chendong.demo.domain.entity.User;
import com.chendong.demo.domain.response.Result;
import com.chendong.demo.domain.vo.EmpVO;
import com.chendong.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author dong.chen
 */
@Controller
@RequestMapping("/index")
@Api(tags = "接口2模块")
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IUserService userService;

    @Resource
    private ApplicationContext applicationContext;

    @ApiOperation(value = "获取所有的用户")
    @GetMapping("/getAll")
    @ResponseBody
    public Result<String> getAll() {

        IndexController indexController = applicationContext.getBean(IndexController.class);
        String allString = indexController.getAllString();

        return Result.success(allString);

    }

    private String getAllString() {
        return "success";
    }


    @ApiImplicitParam(name = "id", value = "id", required = true)
    @ApiOperation(value = "获取用户")
    @GetMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Integer id) {
        User user = userService.selectUserById(id);
        log.info("user - > {}", JSONUtil.toJsonStr(user));
        Assert.notNull(user, "user不为空！");
        return user;
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        log.info("请求域==》[]->{}", JSONUtil.toJsonStr(request.getAttribute("demo-index")));
        return "index";
    }

    @ResponseBody
    @GetMapping("/addEmpV4/{id}/{username}")
    @ApiOperation(value = "添加员工V4", notes = "开发中")
    public Result<EmpVO> addEmpV4(@PathVariable("id") Long id,
                                  @PathVariable("username") String username) {
        return new Result<>();
    }

    @ResponseBody
    @GetMapping("/addEmpV3/{id}/{username}")
    public Result<String> addEmpV3(@ApiParam(name = "id", value = "用户id", example = "1111", required = true)
                                   @PathVariable("id") Long id,
                                   @ApiParam(name = "username", value = "姓名", example = "xiaohua", required = true)
                                   @PathVariable("username") String username) {

        return Result.success("hello world!");
    }

    @ResponseBody
    @PostMapping("/addEmp")
    public Result<EmpVO> addEmp(@RequestBody @ApiParam(name = "EmpVO", value = "员工vo", example = "empvo", required = true) EmpVO empVO) {

        //模拟业务过程
        EmpVO vo = new EmpVO();
        vo.setName("chendong");
        vo.setAge(26);
        return Result.success(vo);
    }

    @ResponseResult
    @ResponseBody
    @PostMapping("/getEmp")
    public EmpVO getEmp(@RequestBody EmpVO empVO) {

        EmpVO vo = new EmpVO();
        vo.setName("chendong");
        vo.setAge(26);
        vo.setUnisocId("1176213349");
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

    @ResponseBody
    @GetMapping("/showInfo/{infoId}")
    public Result<InfoDTO> showInfo(
            @ApiParam(name = "infoId", value = "员工id", example = "12120", required = true)
            @PathVariable("infoId") String infoId) {

        //模拟业务过程
        InfoDTO infoDTO = new InfoDTO();
        infoDTO.setName("hello world!");

        return Result.success(infoDTO);
    }

}
