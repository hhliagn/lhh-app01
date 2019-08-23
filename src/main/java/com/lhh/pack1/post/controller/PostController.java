package com.lhh.pack1.post.controller;

import com.lhh.base.aware.SessionUser;
import com.lhh.base.exception.APIException;
import com.lhh.base.model.RestPrototypeController;
import com.lhh.base.utils.CommUtils;
import com.lhh.pack1.post.base.BaseVOController;
import com.lhh.pack1.post.base.WebRespModel;
import com.lhh.pack1.post.filter.SensitivewordFilter;
import com.lhh.pack1.post.vo.req.Post;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Set;

@RestPrototypeController
@RequestMapping("/post")
public class PostController extends BaseVOController {

    //创建帖子
    public WebRespModel create(Post post) throws Exception {
        WebRespModel wrm = obtainWebResponse();
        try {
            //用户相关操作

            //敏感词处理
            if (!CommUtils.isNull(post.getContent())){
                Set<String> set= SensitivewordFilter.sensitiveUtil(post.getContent());
                if (set.size() > 0){
                    wrm.setCode(WebRespModel.OK);
                    wrm.setData(set);
                }else {
                    Integer count = postService.insert(post);
                    wrm.setCode(WebRespModel.OK);
                    wrm.setData(new HashMap<>());
                    wrm.setMessage("");
                }

            }else {
                throw new Exception("内容为空");
            }
            logger.info("发布帖子");
        }catch (Exception e){
            e.printStackTrace();
            wrm.setCode(WebRespModel.ERROR);
            wrm.setMessage(e.getMessage());
        }
        return wrm;
    }

    //查询推荐帖子

    //根据id查询帖子

    //修改帖子

    //删除帖子


}
