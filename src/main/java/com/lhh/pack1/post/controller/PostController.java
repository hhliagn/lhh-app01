package com.lhh.pack1.post.controller;

import com.lhh.base.aware.SessionUser;
import com.lhh.base.exception.APIException;
import com.lhh.base.model.RestPrototypeController;
import com.lhh.base.utils.CommUtils;
import com.lhh.pack1.post.base.BaseVOController;
import com.lhh.pack1.post.base.OOSManager;
import com.lhh.pack1.post.base.WebRespModel;
import com.lhh.pack1.post.constant.SystemConstant;
import com.lhh.pack1.post.filter.SensitivewordFilter;
import com.lhh.pack1.post.vo.req.Post;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                    //插入数据
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

    //查询所有品牌


    //上传文件
    @ResponseBody
    @PostMapping("/img")
    public WebRespModel uploadOSS(@RequestParam("file") MultipartFile headImage){
        WebRespModel wrm = obtainWebResponse();
        //判空
        if (headImage == null){
            wrm.setCode(WebRespModel.ERROR);
            wrm.setMessage("请选择图片");
            return wrm;
        }
        //获取文件名
        String originalFilename = headImage.getOriginalFilename();

        //获取后缀
        String extension = null;
        if (originalFilename.lastIndexOf(".") > 0){
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }else {
            extension = ".jpg";
        }

        //拼接路径
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(now);
        String rulpath = null;
        rulpath = "upload/" + date + "/" + extension;


        //上传文件
        try {
            //1.获取流
            InputStream inputStream = headImage.getInputStream();
            //2.上传
            OOSManager.uploadPic(inputStream, rulpath);
            wrm.setCode(WebRespModel.OK);
            wrm.setData(SystemConstant.DOMAIN + rulpath);
        } catch (IOException e) {
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
