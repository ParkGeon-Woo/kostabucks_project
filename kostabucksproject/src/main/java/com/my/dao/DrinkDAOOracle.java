package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.exception.FindException;
import com.my.vo.Drink;
@Repository
public class DrinkDAOOracle implements DrinkDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 모든 음료를 검색한다
	 * @return 음료 객체들
	 * @throws FindException 음료가 없거나 저장소에 문제가 있으면 
	 *                       FindException이 강제 발생한다.
	 */
	@Override
	public List<Drink> selectAll() throws FindException {
		SqlSession session = null;
		try {
		session = sqlSessionFactory.openSession();
		List<Drink> list = session.selectList("mybatis.DrinkMapper.selectAll");
		if(list.size() == 0) {
			throw new FindException("음료가 없습니다.");
		}
		return list;
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) session.close();
		}
	}

}
