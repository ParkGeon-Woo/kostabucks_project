package com.my.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.exception.FindException;
import com.my.service.DrinkService;
import com.my.vo.Drink;

@Controller
@RequestMapping("/drink/*")
public class DrinkController {
	@Autowired
	private DrinkService service;
	
	@RequestMapping("/list")
	public String list(@RequestParam(name = "drink", required = false, defaultValue = "")String word, Model model) throws FindException{
		try {
			if(word.equals("")) { //전체검색
				List<Drink> list = service.findAll();
				model.addAttribute("list", list);
			}else {
				
			}
			return "drinklistresult";
		}catch(FindException e){
			model.addAttribute("e", e);
			e.printStackTrace();
			return "errorresult";
		}
	}
}
