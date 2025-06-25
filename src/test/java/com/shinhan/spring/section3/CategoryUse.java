package com.shinhan.spring.section3;

import com.shinhan.spring.util.CategoryEnum;

public class CategoryUse {

	void f1() {
		
		CategoryEnum result = CategoryEnum.fromCode(1);
		System.out.println(result == CategoryEnum.BAG?"OK":"FAIL");
        System.out.println(result.getName());
	    
		
	}
}
