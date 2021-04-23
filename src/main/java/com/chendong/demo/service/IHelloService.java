package com.chendong.demo.service;

import com.chendong.demo.service.request.HelloReq;
import com.chendong.demo.service.request.IndexReq;

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
    String returnName(IndexReq req);

    /**
     * @param req
     * @return
     */
    String hello(HelloReq req);
}
