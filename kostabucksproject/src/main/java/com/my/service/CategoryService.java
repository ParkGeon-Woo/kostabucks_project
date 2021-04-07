package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.CategoryDAO;
import com.my.exception.FindException;
import com.my.vo.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryDAO dao;
	
	/**
	 * 모든 카테고리를 검색한다
	 * @return 카테고리 객체들
	 * @throws FindException 카테고리가 없거나 저장소에 문제가 있으면 
	 *                       FindException이 강제 발생한다.
	 */
	public List<Category> findAll() throws FindException{
		return dao.selectAll();
	}
	
	/**
	 * 카테고리번호 해당하는 카테고리 검색한다
	 * @param category_no 카테고리번호
	 * @return 카테고리 객체
	 * @throws FindException 번호에 해당하는 카테고리가 없거나 저장소에 문제가 있으면 
	 *                        FindException이 강제 발생한다
	 */
	public List<Category> findByNo(int category_no) throws FindException{
		return dao.selectByNo(category_no);
	}
}
