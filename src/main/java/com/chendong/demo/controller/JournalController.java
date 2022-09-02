package com.chendong.demo.controller;

import com.alibaba.fastjson.JSON;
import com.chendong.demo.domain.response.Rep;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.icepear.echarts.Line;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.render.Engine;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@RestController
@RequestMapping("/data")
public class JournalController extends BaseController {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Emp {
        private Integer id;
        private String name;
        private Integer age;
        private String phone;
        private String region;
        private String price;


    }

    private static final HashMap<String, Object> map = new HashMap<>();

    private static final List<Emp> list = new ArrayList<>();

    static {
        list.add(new Emp(1, "xiaoming", 1, "1335689745", "上海", "1256"));
        list.add(new Emp(2, "xiaohong", 2, "1335689785", "天津", "1356"));
        list.add(new Emp(3, "xiaobo", 3, "1335689746", "北京", "1257"));
        map.put("count", 3);
        map.put("rows", list);
    }


    @GetMapping("/all")
    public Rep<Map<String, Object>> getMock(String keywords) {
        Rep<Map<String, Object>> rep = new Rep<>();

        if(StringUtils.isNotBlank(keywords)) {
            Emp emp = list.stream().findFirst().get();
            HashMap<String, Object> map = new HashMap<>();
            map.put("count", 1);
            map.put("rows", Arrays.asList(emp));
            rep.setData(map);
            return rep;

        }

        rep.setData(map);
        return rep;

    }

    @GetMapping("/all/{id}")
    public Rep<Emp> get(@PathVariable(value = "id") Integer id) {

        Rep<Emp> rep = new Rep<>();
        rep.setData(list.get(id - 1));
        return rep;

    }

    @PostMapping("/all/{id}")
    public Rep<Emp> postEmp(@RequestBody Emp emp) {

        Iterator<Emp> iterator = list.iterator();
        while (iterator.hasNext()) {
            Emp next = iterator.next();
            if (next.getId().equals(emp.getId())) {
                iterator.remove();
            }
        }
        list.add(emp);
        Rep<Emp> rep = new Rep<>();
        rep.setData(emp);
        return rep;

    }

    @PostMapping("/all")
    public Rep<Emp> addEmp(@RequestBody Emp emp) {

        list.add(emp);
        Rep<Emp> rep = new Rep<>();
        rep.setData(emp);
        return rep;

    }

    @DeleteMapping("/all/{id}")
    public Rep<String> del(@PathVariable(value = "id") Integer id) {
        list.removeIf(next -> next.getId().equals(id));
        Rep<String> rep = new Rep<>();
        return rep;

    }

    @GetMapping("/report")
    public Rep<String> getReport() {

        Line lineChart = new Line()
                .addXAxis(new CategoryAxis()
                        .setData(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"})
                        .setBoundaryGap(false))
                .addYAxis()
                .addSeries(new LineSeries()
                        .setData(new Number[]{820, 932, 901, 934, 1290, 1330, 1320})
                        .setAreaStyle(new LineAreaStyle()));
        Engine engine = new Engine();
        // It is recommended that you can  get the serialized version of Option in the representation of JSON, which can be used directly in the template or in the RESTful APIs.
        String jsonStr = engine.renderJsonOption(lineChart);

        Rep<String> rep = new Rep<>();
        rep.setData(jsonStr);

        Object o = JSON.parse(jsonStr);
        System.out.println(o);
        return rep;


    }


}
