package com.chendong.demo.common.tool;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.chendong.demo.common.pojo.Dog;
import com.chendong.demo.common.utils.TreeUtil;
import com.chendong.demo.controller.vo.EmpVO;
import com.chendong.demo.controller.vo.PermissionVO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName TestTool
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/23 11:18
 * @Version 1.0
 */
@SuppressWarnings("all")
public class TestTool {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestTool.class);

    private static final Map<String, Object> store = new HashMap<>();

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
        System.out.println(JSONUtil.toJsonStr(treeNodes));
        TreeUtil treeUtil = new TreeUtil();


        //构造树形结构的数据
        List<Object> treeData = treeUtil.treeMenu(treeNodes);
        System.out.println(JSONUtil.toJsonStr(treeData));

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

}
