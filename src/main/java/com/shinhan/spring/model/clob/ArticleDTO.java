package com.shinhan.spring.model.clob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticleDTO {
    private int id;
    private String title;
    
    // Oracle CLOB 컬럼과 매핑되는 필드
    private String content; // CLOB → String

 
}