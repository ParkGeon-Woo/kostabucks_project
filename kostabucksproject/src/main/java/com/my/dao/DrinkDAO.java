package com.my.dao;

import java.util.List;

import com.my.exception.FindException;
import com.my.vo.Drink;

public interface DrinkDAO {

	/**
	 * 모든 음료를 검색한다
	 * @return 음료 객체들
	 * @throws FindException 음료가 없거나 저장소에 문제가 있으면 
	 *                       FindException이 강제 발생한다.
	 */
	List<Drink> selectAll() throws FindException;
}
