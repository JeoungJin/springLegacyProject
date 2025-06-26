package com.shinhan.spring.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor 
public enum CategoryEnum {
 
	CLOTH(1, "옷"), BAG(2, "가방");
	
	private final int code;
    private final String name;
 
    
 
    public static CategoryEnum fromCode(int code) {
        for (CategoryEnum category : CategoryEnum.values()) {
            if (category.getCode() == code) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    // �̸����� enum ã��
    public static CategoryEnum fromName(String name) {
        try {
            return CategoryEnum.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
    }
    
}
