package com.chendong.demo.service;

import com.chendong.demo.domain.entity.User;
import com.chendong.demo.service.request.HelloParamRequest;
import com.chendong.demo.service.request.IndexBaseRequest;

/**
 * @author chendong
 * @date 2020/6/19 4:27 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public interface IHelloService {
    /**
     * @param req
     * @return
     */
    String returnName(IndexBaseRequest req);

    /**
     * @param req
     * @return
     */
    String hello(HelloParamRequest req);


    /**
     * @param id
     * @return
     */
    User selectUserById(Integer id);
}
