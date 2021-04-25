package com.chendong.demo.service;

import com.chendong.demo.service.request.HelloBaseReq;
import com.chendong.demo.service.request.IndexBaseReq;

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
    String returnName(IndexBaseReq req);

    /**
     * @param req
     * @return
     */
    String hello(HelloBaseReq req);
}
