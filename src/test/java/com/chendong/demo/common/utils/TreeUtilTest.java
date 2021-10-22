package com.chendong.demo.common.utils;

import com.chendong.demo.domain.vo.PermissionVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

public class TreeUtilTest {

    @Mock
    List<PermissionVO> menuList;
    @Mock
    List<Object> list;
    @InjectMocks
    TreeUtil treeUtil;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() {
        list.add("1");
        verify(list).add("1");
        System.out.println(list);
    }

    @Test
    public void testMenuList() {
        System.out.println(menuList);
        Assert.assertNotNull(menuList);
    }

    @Test
    public void testTreeMenu() throws Exception {
        List<Object> result = treeUtil.treeMenu(Arrays.<PermissionVO>asList(new PermissionVO()));
        Assert.assertEquals(Arrays.<Object>asList("replaceMeWithExpectedResult"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme