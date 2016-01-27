package com.opensns.forumn.db;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensns.forumn.db.dao.PostDao;
import com.opensns.forumn.db.vo.PostVO;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Override
	public List<PostVO> getPostList(HashMap<String, Object> map) {		
		return postDao.getPostList(map);
	}

}
