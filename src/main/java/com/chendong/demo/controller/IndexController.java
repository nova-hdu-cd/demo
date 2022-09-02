package com.chendong.demo.controller;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.domain.dto.InfoDTO;
import com.chendong.demo.domain.entity.User;
import com.chendong.demo.domain.response.Result;
import com.chendong.demo.domain.vo.EmpVO;
import com.chendong.demo.common.pdf.ScatterPlotChartTest;
import com.chendong.demo.common.pdf.TemplateBO;
import com.chendong.demo.common.pdf.component.PDFHeaderFooter;
import com.chendong.demo.common.pdf.component.PDFKit;
import com.chendong.demo.common.pdf.component.chart.ScatterPlotChart;
import com.chendong.demo.common.pdf.component.chart.impl.DefaultLineChart;
import com.chendong.demo.common.pdf.component.chart.model.XYLine;
import com.chendong.demo.service.IUserService;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author dong.chen
 */
@Controller
@RequestMapping("/app/gate")
@Api(tags = "接口2模块")
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IUserService userService;

    @Resource
    private ApplicationContext applicationContext;

    public OutputStream createPDF(Object data, String filePath, HttpServletResponse response) {
        //pdf保存路径
        try {
            //设置自定义PDF页眉页脚工具类
            PDFHeaderFooter headerFooter = new PDFHeaderFooter();
            PDFKit kit = new PDFKit();
            kit.setHeaderFooterBuilder(headerFooter);
            return kit.exportToResponse(filePath, data, response);

        } catch (Exception e) {
            log.error("PDF生成失败{}", ExceptionUtils.getFullStackTrace(e));
            return null;
        }

    }

    @ApiOperation(value = "下载pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    @GetMapping("/download")
    @ResponseBody
    public void download(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        /* 设置文件ContentType类型，这样设置，会自动判断下载文件类型 */
        response.setContentType("application/pdf");
        /* 设置文件头：最后一个参数是设置下载文件名 */
        response.setHeader("Content-Disposition", "attachment;filename=aaa.pdf");
        createPDF(getPdfData(), "hello.ftl", response);


    }

    private Object getPdfData() {
        TemplateBO templateBO = new TemplateBO();
        templateBO.setTemplateName("Hello iText! Hello freemarker! Hello jFreeChart!");
        templateBO.setFreeMarkerUrl("http://www.zheng-hang.com/chm/freemarker2_3_24/ref_directive_if.html");
        templateBO.setITEXTUrl("http://developers.itextpdf.com/examples-itext5");
        templateBO.setJFreeChartUrl("http://www.yiibai.com/jfreechart/jfreechart_referenced_apis.html");
        templateBO.setImageUrl("http://mss.vip.sankuai.com/v1/mss_74e5b6ab17f44f799a524fa86b6faebf/360report/logo_1.png");
        List<String> scores = new ArrayList<String>();
        scores.add("90");
        scores.add("95");
        scores.add("98");
        templateBO.setScores(scores);
        //折线图
        List<XYLine> lineList = getTemperatureLineList();
        DefaultLineChart lineChart = new DefaultLineChart();
        lineChart.setHeight(500);
        lineChart.setWidth(300);
        String picUrl = lineChart.draw(lineList, 0);
        templateBO.setPicUrl(picUrl);

        //散点图
        String scatterUrl = ScatterPlotChart.draw(ScatterPlotChartTest.getData(), 1, "他评得分(%)", "自评得分(%)");
        templateBO.setScatterUrl(scatterUrl);
        return templateBO;
    }

    public static List<XYLine> getTemperatureLineList() {
        List<XYLine> list = Lists.newArrayList();
        for (int i = 1; i <= 7; i++) {
            XYLine line = new XYLine();
            float random = Math.round(Math.random() * 10);
            line.setXValue("星期" + i);
            line.setYValue(20 + random);
            line.setGroupName("下周");
            list.add(line);
        }
        for (int i = 1; i <= 7; i++) {
            XYLine line = new XYLine();
            float random = Math.round(Math.random() * 10);
            line.setXValue("星期" + i);
            line.setYValue(20 + random);
            line.setGroupName("这周");
            list.add(line);
        }
        return list;
    }

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
    public Result<EmpVO> addEmpV4(@PathVariable("id") Long id, @PathVariable("username") String username) {
        return new Result<>();
    }

    @ResponseBody
    @GetMapping("/addEmpV3/{id}/{username}")
    public Result<String> addEmpV3(
            @ApiParam(name = "id", value = "用户id", example = "1111", required = true) @PathVariable("id") Long id,
            @ApiParam(name = "username", value = "姓名", example = "xiaohua",
                    required = true) @PathVariable("username") String username) {

        return Result.success("hello world!");
    }

    @ResponseBody
    @PostMapping("/addEmp")
    public Result<EmpVO>
    addEmp(@RequestBody @ApiParam(name = "EmpVO", value = "员工vo", example = "empvo", required = true) EmpVO empVO) {

        // 模拟业务过程
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
        // vo = null;

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
    public Result<InfoDTO> showInfo(@ApiParam(name = "infoId", value = "员工id", example = "12120",
            required = true) @PathVariable("infoId") String infoId) {

        // 模拟业务过程
        InfoDTO infoDTO = new InfoDTO();
        infoDTO.setName("hello world!");

        return Result.success(infoDTO);
    }

}
