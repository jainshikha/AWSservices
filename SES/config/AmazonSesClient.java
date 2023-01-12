package com.tsystems.dco.AWSservices.SES.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AmazonSesClient {

  @Bean
  public AmazonSimpleEmailService getAmazonSimpleEmailService() {
    try {
      return AmazonSimpleEmailServiceClientBuilder.standard()
        .withCredentials(getAwsCredentialProvider())
        .withRegion(Regions.EU_CENTRAL_1)
        .build();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  private AWSCredentialsProvider getAwsCredentialProvider() {
    AWSCredentials awsCredentials =
      new BasicAWSCredentials("ASIAWUEL6J4GJ2VBYOUE", "V5LL21hT/SxpIUbp/o9bpR5QtI/xv74hpH4C6ghg");
    return new AWSStaticCredentialsProvider(awsCredentials);
  }
}
