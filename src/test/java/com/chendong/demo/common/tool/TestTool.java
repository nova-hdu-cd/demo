package com.chendong.demo.common.tool;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.FIFOCache;
import cn.hutool.cache.impl.LFUCache;
import cn.hutool.cache.impl.LRUCache;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.*;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.chendong.demo.common.convert.HelloMapper;
import com.chendong.demo.common.constants.enums.global.ArgumentEnum;
import com.chendong.demo.common.exception.ArgumentException;
import com.chendong.demo.common.pojo.Dog;
import com.chendong.demo.common.pojo.People;
import com.chendong.demo.common.pojo.dto.TicketDTO;
import com.chendong.demo.common.pojo.dto.UserDTO;
import com.chendong.demo.common.pojo.vo.EmpVO;
import com.chendong.demo.common.pojo.vo.PermissionVO;
import com.chendong.demo.common.utils.TreeUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Junit5测试
 *
 * @ClassName TestTool
 * @Description: Junit5测试
 * @Author dong.chen
 * @Date 2021/4/23 11:18
 * @Version 1.0
 */
@SuppressWarnings("all")
@SpringBootTest
public class TestTool {

    @Resource
    private HelloMapper helloMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestTool.class);

    private static final Map<String, Object> store = new HashMap<>();

    @Test
    void testHelloMapper() {
        UserDTO dto = new UserDTO();
        dto.setId("10010");
        dto.setName("name");
        dto.setNamespace("unisoc");

        TicketDTO ticketDTO = helloMapper.buildTicketDTO(dto);

        System.out.println(ticketDTO);
    }

    //md5加密和解密测试
    @Test
    void testHutool() {
        String sercet = "yuiyuyuoiuououououoddd";
        //md5工具加密
        String md5_sercet = SecureUtil.md5(sercet);

        LOGGER.info("md5_sercet -> {}", md5_sercet);
        //模拟放入数据库中
        store.put("chendong", md5_sercet);

        //模拟验证用户登录
        String result = checkUserInfo("chendong", md5_sercet);

        LOGGER.info("登录的状态 ->{}", result);

    }

    private String checkUserInfo(String username, String md5_password) {
        return store.get(username) == md5_password ? "ok" : "false";
    }

    @Test
    void testHutoolUUID() {
        //uuid使用工具类
        String uuid = IdUtil.simpleUUID();
        LOGGER.info("uuid -> {}", uuid);
    }

    @Test
    void testJSONUtils() {
        List<String> emp1 = Arrays.asList("chendong", "xiaoming");
        List<String> emp2 = Arrays.asList("zhangmeng", "xiaohong");
        List<List<String>> emps = new ArrayList<>();
        emps.add(emp1);
        emps.add(emp2);
        LOGGER.info("emps -> {}", emps);

        String jsonStr1 = JSONUtil.toJsonStr(emps);
        LOGGER.info("jsonStr1 ->{}", jsonStr1);

        String jsonStr = JSONUtil.toJsonStr(new Dog("xiao_huang"));
        LOGGER.info("jsonStr -> {}", jsonStr);

        //把一个json字符串转换成一个java对象，jsonStr->jsonObject->dog
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        LOGGER.info("jsonObject -> {}", jsonObject);
        Dog dog = JSONUtil.toBean(jsonObject, Dog.class);
        LOGGER.info("dog -> {}", dog);
        Dog dog1 = JSONUtil.toBean(jsonStr, Dog.class);
        LOGGER.info("dog1 -> {}", dog1);
        String json = new JSONObject().set("id", "chendong").toString();
        LOGGER.info("json -> {}", json);

        //将任意一个Java对象转化成json
        Object wrap = JSONUtil.wrap(dog, new JSONConfig());
        LOGGER.info("wrap -> {}", wrap);

        //对map进行排序
        Map<String, String> map = new HashMap<>();
        map.put("a", "chendong");
        map.put("b", "zhangming");
        TreeMap<String, String> sortedMap = MapUtil.sort(map);
        LOGGER.info(" sortedMap -> {}", sortedMap);

    }

    @Test
    void testStreamApi() {
        Stream<String> stringStream = Stream.of("1", "2", "2", null, "3", "4").filter(item -> item != null);

        //supplier：一个能创造目标类型实例的方法。
        //accumulator：一个将当元素添加到目标中的方法。
        //combiner：一个将中间状态的多个结果整合到一起的方法（并发的时候会用到）
        //ArrayList<Object> collect1 = stringStream.collect(() -> new ArrayList<>(), (list, item) -> list.add(item), (one, two) -> one.addAll(two));
        //ArrayList<Object> collect = stringStream.collect(ArrayList::new, List::add, List::addAll);
        List<String> collect = stringStream.collect(Collectors.toList());

        //collect.forEach(System.out::print);
        //System.out.print(collect);

        EmpVO vo = new EmpVO();
        vo.setName("chendong");
        vo.setAge(26);
        vo.setUnisocId("12125");
        EmpVO vo1 = new EmpVO();
        vo1.setName("xiaoming");
        vo1.setAge(27);
        vo1.setUnisocId("12124");
        EmpVO vo2 = new EmpVO();
        vo2.setName("xiaoming");
        vo2.setAge(25);
        vo2.setUnisocId("12124");
        EmpVO vo3 = new EmpVO();
        vo3.setName("xiaohong");
        vo3.setAge(25);
        vo3.setUnisocId("12123");
        List<EmpVO> results = new ArrayList<>();
        results.add(vo);
        results.add(vo2);
        results.add(vo1);
        results.add(vo3);

        //将list<EmpVO>转换成name:age的Map形式
        final HashMap<Object, Object> maps
                = results.stream().collect(HashMap::new, (map, p) -> map.put(p.getName(), p.getAge()), Map::putAll);
        maps.forEach((k, v) -> System.out.println(k + ":" + v));

        final Map<String, Integer> collect1
                = results.stream().collect(Collectors.toMap(emp -> emp.getName(), emp -> emp.getAge(), (oldItem, newItem) -> newItem));
        collect1.forEach((k, v) -> System.out.println(k + ":" + v));

        //将List<EmpVO> -> Map<Age,List<EmpVO>>
        Map<Integer, List<EmpVO>> groupMap
                = results.stream().collect(Collectors.groupingBy(s -> s.getAge(), Collectors.toList()));
        System.out.println(groupMap);

        //将List<EmpVO> -> Map<Age,List<Name>>
        Map<Integer, List<String>> nameToAgeGroup
                = results.stream().collect(Collectors.groupingBy(s -> s.getAge(), Collectors.mapping(p -> p.getName(), Collectors.toList())));
        System.out.println(nameToAgeGroup);

        //统计
        Map<String, Integer> collect3 = results.stream().collect(Collectors.groupingBy(s -> s.getName(), Collectors.reducing(0, s -> s.getAge(), Integer::sum)));
        Map<String, Integer> collect2 = results.stream().collect(Collectors.groupingBy(s -> s.getName(), Collectors.summingInt(s -> s.getAge())));
        System.out.println(collect2);
        System.out.println(collect3);
    }

    /**
     * 构造简单的树形结构数据
     *
     * @return
     */
    private List<PermissionVO> getAllTreeNodes() {
        PermissionVO parent = new PermissionVO();
        parent.setId(100);
        parent.setMenu("yes");
        parent.setUrl("/menu");
        parent.setParentId("");//注意父节点的父节点id为“”

        PermissionVO children1 = new PermissionVO();
        children1.setId(101);
        children1.setMenu("yes");
        children1.setUrl("/menu1");
        children1.setParentId("100");

        PermissionVO children2 = new PermissionVO();
        children2.setId(102);
        children2.setMenu("yes");
        children2.setUrl("/menu2");
        children2.setParentId("100");

        List<PermissionVO> childrens = new ArrayList<>();
        childrens.add(children1);
        childrens.add(children2);
        parent.setList(childrens);

        List<PermissionVO> allNodes = new ArrayList<>();
        allNodes.add(parent);
        allNodes.add(children1);
        allNodes.add(children2);

        return allNodes;
    }

    @Test
    void testTreeUtil() {
        //所有的节点数据，包括父节点和子节点，注意父节点和子节点的关系
        List<PermissionVO> treeNodes = getAllTreeNodes();
        LOGGER.info("treeNodes -> {}", JSONUtil.toJsonStr(treeNodes));

        TreeUtil treeUtil = new TreeUtil();
        //构造树形结构的数据
        List<Object> treeData = treeUtil.treeMenu(treeNodes);
        LOGGER.info("treeData -> {}", JSONUtil.toJsonStr(treeData));

    }

    @Test
    void testHutoolTreeUtil() {
        List<PermissionVO> allTreeNodes = getAllTreeNodes();

        System.out.println(allTreeNodes);

        //todo 树形结构数据处理
        List<TreeNode<Integer>> list = allTreeNodes.stream().map(permissionVO -> {
            TreeNode<Integer> treeNode = new TreeNode<>();
            treeNode.setId(permissionVO.getId());
            treeNode.setName(permissionVO.getName());
            //父节点特殊处理
            if (permissionVO.getParentId().equals("")) {
                treeNode.setParentId(0);
            } else {
                treeNode.setParentId(Integer.parseInt(permissionVO.getParentId()));
            }
            Map<String, Object> extra = new HashMap<>();
            extra.put("url", "/menu");
            extra.put("icon", "yes");
            extra.put("isMenu", "yes");
            treeNode.setExtra(extra);
            return treeNode;
        }).collect(Collectors.toList());
        List<Tree<Integer>> trees = cn.hutool.core.lang.tree.TreeUtil.build(list);
        System.out.println(JSONUtil.toJsonStr(trees));
    }

    @Test
    void testCacheUtil() {

        //FIFO队列缓存
        FIFOCache<String, String> cache = CacheUtil.newFIFOCache(3);
        cache.put("chendong", "12125");
        cache.put("xiaoming", "12124");
        cache.put("zhanghong", "12123");
        cache.put("kangkang", "12122");
        String s1 = cache.get("chendong");
        System.out.println(s1);
        System.out.println("============================");

        //最少使用率缓存.
        LFUCache<String, String> lfuCache = CacheUtil.newLFUCache(3);
        lfuCache.put("chendong", "12125");
        lfuCache.put("xiaoming", "12124");
        lfuCache.put("xiaoming", "12129");
        lfuCache.put("chendong", "12126");
        lfuCache.put("chendong", "12127");

        lfuCache.forEach(System.out::println);
        System.out.println("====================");

        LRUCache<String, String> lruCache = CacheUtil.newLRUCache(3);
        lruCache.put("xiaoming", "12121");
        lruCache.put("xiaohong", "12122");
        lruCache.put("xiaokang", "12123");
        lruCache.put("xiaodong", "12124");

        lruCache.forEach(System.out::println);
    }

    @Test
    void testAssert() {
        //Assert.isFalse(true,()->new BusinessException(ArgumentEnum.PARAMETER_FAILURE));
        Assert.isNull(null);
        Assert.isNull("hello", () -> new ArgumentException(ArgumentEnum.PARAMETER_FAILURE));
    }

    @Test
    void testCaptchaUtil() {
        //圆圈干扰的验证码
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 8);
        System.out.println(circleCaptcha.getCode());
        circleCaptcha.write("d:/yanzhenma.png");
    }

    @Test
    void testExcelUtil() {
        //1.从文件中读取excel为ExcelReader
        //注意传入的参数为File对象，而File对象的入参为“d:/a.xlsx”
        ExcelReader reader1 = ExcelUtil.getReader(FileUtil.file("d:/a.xlsx"));
        int count = reader1.getColumnCount();
        System.out.println(count);

        //2.读取指定的sheet
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("d:/a.xlsx"));
        List<List<Object>> read = reader.read();
        System.out.println(read);

        //3.读取Excel中的所有行和列为map列表
        List<Map<String, Object>> maps = reader.readAll();
        List<People> res = new ArrayList<>();
        //excel中的整型数字注意为Long，浮点数据为Double
        maps.forEach(map -> {
            People p = new People();
            p.setName((String) map.get("name"));
            p.setAge((Long) (map.get("age")));
            p.setLocation((String) map.get("location"));
            p.setCarNum((String) map.get("carNum"));
            res.add(p);
        });
        System.out.println(maps);
        System.out.println(res);

        //4.读取Excel中的所有行和字段为Bean列表,Bean中的字段必须和excel的标题字段相同
        List<People> people = reader.readAll(People.class);
        System.out.println(people);


    }


    private RowHandler createRowHandler() {
        return (sheetIndex, rowIndex, rowList) ->
                Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowList);
    }

    @Test
    void testHugExcelUtil() {
        //读取07版本的excel
        Excel07SaxReader reader = ExcelUtil.read07BySax(FileUtil.file("d:/a.xlsx"), -1, createRowHandler());
    }

    @Test
    void testExcelWriter() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");

        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        //1.获取excel写对象
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeTest" + UUID.fastUUID().toString() + ".xlsx");
        //2.跳过第一行
        writer.passCurrentRow();
        //3.合并单元格后的标题行，使用默认的标题样式
        writer.merge(row1.size() - 1, "测试标题");
        //4.一次性写出内容，强制输出标题
        writer.write(rows, true);
        //5.关闭writer，释放内存
        writer.close();

    }

    @Test
    void testExcelUtilForMap() {
        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        row1.put("成绩", 88.32);
        row1.put("是否合格", true);
        row1.put("考试日期", DateUtil.date());
        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        row2.put("成绩", 59.50);
        row2.put("是否合格", false);
        row2.put("考试日期", DateUtil.date());
        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);

        ExcelWriter writer = ExcelUtil.getWriter("d:/writeMapTest.xlsx");
        writer.merge(rows.size() - 1, "一班成绩单");
        writer.write(rows, true);
        writer.close();
    }

    @Test
    void testExcelToBean() {
        People p1 = new People();
        p1.setName("张三");
        p1.setAge(25L);
        p1.setLocation("上海");
        p1.setCarNum("沪A23322");

        People p2 = new People();
        p2.setName("小明");
        p2.setAge(29L);
        p2.setLocation("上海");
        p2.setCarNum("沪A28822");

        List<People> peoples = CollUtil.newArrayList(p1, p2);
        ExcelWriter writer = ExcelUtil.getWriter(FileUtil.file("d:/people_total_alias.xlsx"));
        writer.merge(peoples.size() - 1, "人员汇总");
        //自定义excel的标题
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("location", "地址");
        writer.addHeaderAlias("carNum", "车牌号");
        writer.write(peoples, true);
        writer.close();
    }

    @Test
    void testBigExcelWriter() {
        List<?> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd", DateUtil.date(), 3.22676575765);
        List<?> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", DateUtil.date(), 250.7676);
        List<?> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2", DateUtil.date(), 0.111);
        List<?> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3", DateUtil.date(), 35);
        List<?> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4", DateUtil.date(), 28.00);

        List<List<?>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);

        //大量的数据写入到excel，用BigExcelWriter
        BigExcelWriter writer = ExcelUtil.getBigWriter("d:/xxx" + UUID.fastUUID().toString() + ".xlsx");
        writer.merge(rows.size() - 1, "汇总数据");
        writer.merge(rows.size() - 2, "XXXX公司");
        // 一次性写出内容，使用默认样式
        writer.write(rows);
        // 关闭writer，释放内存
        writer.close();

    }

    @Test
    void testCoustmerExcel() {
        ExcelWriter writer = ExcelUtil.getWriter("d:/coustmer-red.xlsx");

        List<?> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd", DateUtil.date(), 3.22676575765);
        List<?> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", DateUtil.date(), 250.7676);
        List<?> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2", DateUtil.date(), 0.111);
        List<?> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3", DateUtil.date(), 35);
        List<?> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4", DateUtil.date(), 28.00);

        List<List<?>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        writer.merge(rows.size() - 1, "汇总标题");


        //自定义单元格的背景色
        StyleSet styleSet = writer.getStyleSet();
        styleSet.setBackgroundColor(IndexedColors.RED, false);

        //自定义字体
        Font font = writer.createFont();
        font.setBold(true);
        font.setColor(Font.COLOR_NORMAL);
        font.setItalic(true);
        writer.getStyleSet().setFont(font, true);
        writer.write(rows, true);

        writer.close();

    }

    @Test
    void testSomething() {

        String str1 = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            str1 = "<tr>"
                    + "<td>" + String.valueOf(i) + "</td>"
                    + "<td>" + String.valueOf(i) + "</td>"
                    + "</tr>";
            sb.append(str1);
        }
        LOGGER.info("sb -> {}", sb);
        assert sb != null;


    }


}
