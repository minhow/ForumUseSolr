package com.opensns.forumn.db;

import java.util.HashMap;
import java.util.List;

import com.opensns.forumn.db.vo.PostVO;

public interface PostService {
	public List<PostVO> getPostList(HashMap<String, Object> map); 
}
