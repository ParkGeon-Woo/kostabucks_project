package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.DrinkDAO;
import com.my.exception.FindException;
import com.my.vo.Drink;

@Service
public class DrinkService {
	@Autowired
	private DrinkDAO dao;
	
	/**
	 * 모든 음료를 검색한다
	 * @return 음료 객체들
	 * @throws FindException 음료가 없거나 저장소에 문제가 있으면 
	 *                       FindException이 강제 발생한다.
	 */
	public List<Drink> findAll() throws FindException{
		return dao.selectAll();
	}
}
