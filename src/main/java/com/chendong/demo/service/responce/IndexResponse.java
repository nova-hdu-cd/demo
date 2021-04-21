package com.chendong.demo.service.responce;


import com.chendong.demo.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dong.chen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexResponse extends Response {

    private String id;
    private String uuid;

}
