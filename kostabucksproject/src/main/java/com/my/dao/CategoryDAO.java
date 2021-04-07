package com.my.dao;

import java.util.List;

import com.my.exception.FindException;
import com.my.vo.Category;

public interface CategoryDAO {

	/**
	 * 모든 카테고리를 검색한다
	 * @return 카테고리 객체들
	 * @throws FindException 카테고리가 없거나 저장소에 문제가 있으면 
	 *                       FindException이 강제 발생한다.
	 */
	List<Category> selectAll() throws FindException;
	
	/**
	 * 카테고리번호 해당하는 카테고리 검색한다
	 * @param category_no 카테고리번호
	 * @return 카테고리 객체
	 * @throws FindException 번호에 해당하는 카테고리가 없거나 저장소에 문제가 있으면 
	 *                        FindException이 강제 발생한다
	 */
	List<Category> selectByNo(int category_no) throws FindException;
	
}
