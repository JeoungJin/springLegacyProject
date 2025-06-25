package com.shinhan.spring.model.s3;

import java.io.InputStream;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class S3Uploader {
 		
    private final AmazonS3 s3;
    private final String bucket = "shinhanbucket";
    public S3Uploader(@Value("${aws.accessKey}")  String accessKey, @Value("${aws.secretKey}") String secretKey,   @Value("${aws.region}")  String region ) {
    	log.info("S3Uploader initialized");
    	log.info("AWS Access Key: {}", accessKey != null ? "SET" : "NULL");
    	log.info("AWS Secret Key: {}", secretKey != null ? "SET" : "NULL");
    	log.info("AWS Region: {}", region);
        BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
        s3 = AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(creds))
                .build();
    }
 
    
    public String upload(MultipartFile file, String dir) throws Exception {
        String fileName = dir + "/" +  file.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize()); //  
        
        InputStream is = file.getInputStream();
        s3.putObject(bucket, fileName, is, metadata);
        return s3.getUrl(bucket, fileName).toString();  // S3 ���� URL
    }
    @PreDestroy
    public void shutdown() {
        if (s3 != null) {
        	s3.shutdown();
        }
    }
    
}

