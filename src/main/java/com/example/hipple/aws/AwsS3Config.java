package com.example.hipple.aws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AwsS3Config {
    @Value("${spring.aws.credentials.accessKey}")
    private String accessKey;
    @Value("${spring.aws.credentials.secretKey}")
    private String secretKey;
    @Value("${spring.aws.region.static}")
    private String region;

    @Bean
    @Primary
    public BasicAWSCredentials awsCredentialsProvider() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentialsProvider()))
                .build();
    }
}