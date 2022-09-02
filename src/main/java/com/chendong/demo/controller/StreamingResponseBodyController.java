package com.chendong.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.Date;

@Controller
public class StreamingResponseBodyController {
    @GetMapping("/logs")
    public ResponseEntity<StreamingResponseBody> handleLog() {
        StreamingResponseBody stream = out -> {
          for (int i = 0; i < 1000; i++) {
            String msg = "log" + " @ ======================================== " + new Date();
            out.write(msg.getBytes());
            out.flush();
          }
          out.close();
        };
        return new ResponseEntity(stream, HttpStatus.OK);
    }
}