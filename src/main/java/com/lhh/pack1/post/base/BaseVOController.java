package com.lhh.pack1.post.base;

import com.lhh.base.model.BasicController;
import com.lhh.pack1.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseVOController extends BasicController {

    @Autowired
    public PostService postService;

    public WebRespModel obtainWebResponse() {
        WebRespModel response = new WebRespModel();
        response.setCode(WebRespModel.OK);
        return response;
    }



}
