package com.tsystems.dco.AWSservices.SES.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@SuperBuilder
public class NotificationRequest {
  String body;
  String subject;
  String modeOfNotification;
  String username;
  String text;
}
