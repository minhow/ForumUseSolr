package com.opensns.forumn.db.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opensns.forumn.db.vo.PostVO;

@Component
public interface PostDao {
	public List<PostVO> getPostList(HashMap<String, Object> map);
}
