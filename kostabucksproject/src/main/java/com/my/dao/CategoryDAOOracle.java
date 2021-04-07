package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.exception.FindException;
import com.my.vo.Category;
@Repository
public class CategoryDAOOracle implements CategoryDAO {
	@Autowired
	private SqlSessionFactory SqlSessionFactory;
	
	@Override
	public List<Category> selectAll() throws FindException {
		SqlSession session = null;
		try {
			session = SqlSessionFactory.openSession();
			List<Category> list = session.selectList("mybatis.CategoryMapper.selectAll");
			if(list.size() == 0) {
				throw new FindException("카테고리가 없습니다.");
			}
			return list;
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) session.close();
		}
	}

	@Override
	public List<Category> selectByNo(int category_no) throws FindException {
		SqlSession session = null;
		try {
			session = SqlSessionFactory.openSession();
			List<Category> list = session.selectList("mybatis.CategoryMapper.selectByNo", category_no);
			
			if(list.size() == 0) {
				throw new FindException("해당 카테고리가 없습니다.");
			}
			return list;
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) session.close();
		}
	}

}
