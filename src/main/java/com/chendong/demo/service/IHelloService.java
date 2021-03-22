package com.chendong.demo.service;

import com.chendong.demo.service.request.HelloRequest;
import com.chendong.demo.service.request.IndexRequest;

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
    String returnName(IndexRequest req);

    /**
     * @param req
     * @return
     */
    String hello(HelloRequest req);
}
