package com.lhh.pack1.post.service;


import com.lhh.pack1.post.dao.PostDao;
import com.lhh.pack1.post.vo.req.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public Integer insert(Post post) {
        return postDao.insert(post);
    }
}
