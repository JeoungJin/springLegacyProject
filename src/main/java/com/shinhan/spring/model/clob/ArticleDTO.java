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
    
    //  
    private String content; //  

 
}