package com.tsystems.dco.AWSservices.SES.config;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sesv2.SesV2Client;
import software.amazon.awssdk.services.sesv2.model.*;
// snippet-end:[ses.java2.sendmessage.template.sesv2.import]

/**
 * Before running this AWS SDK for Java (v2) example, set up your development environment, including your credentials.
 * <p>
 * For more information, see the following documentation topic:
 * <p>
 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
 * <p>
 * Also, make sure that you create a template. See the following documentation topic:
 * <p>
 * https://docs.aws.amazon.com/ses/latest/dg/send-personalized-email-api.html
 */

public class SendEmailTemplate {

  public static void SendEmailTemplateTest() {

    final String usage = "\n" +
      "Usage:\n" +
      "    <template> <sender> <recipient> \n\n" +
      "Where:\n" +
      "    template - The name of the email template." +
      "    sender - An email address that represents the sender. \n" +
      "    recipient - An email address that represents the recipient. \n";

    String templateName = "temp";
    String sender = "shikha.jain55@gamil.com";
    String recipient = "shikha.jain@t-systems.com";
    Region region = Region.EU_CENTRAL_1;
    SesV2Client sesv2Client = SesV2Client.builder()
      .region(region)
      .credentialsProvider(ProfileCredentialsProvider.create())
      .build();

    send(sesv2Client, sender, recipient, templateName);
  }

  public static void send(SesV2Client client, String sender, String recipient, String templateName) {

    Destination destination = Destination.builder()
      .toAddresses(recipient)
      .build();

        /*
         Specify both name and favorite animal (favoriteanimal) in your code when defining the Template object.
         If you don't specify all the variables in the template, Amazon SES doesn't send the email.
        */
    Template myTemplate = Template.builder()
      .templateName(templateName)
      .templateData("{\n" +
        "  \"name\": \"Jason\"\n," +
        "  \"favoriteanimal\": \"Cat\"\n" +
        "}")
      .build();

    EmailContent emailContent = EmailContent.builder()
      .template(myTemplate)
      .build();

    SendEmailRequest emailRequest = SendEmailRequest.builder()
      .destination(destination)
      .content(emailContent)
      .fromEmailAddress(sender)
      .build();

    try {
      System.out.println("Attempting to send an email based on a template using the AWS SDK for Java (v2)...");
      client.sendEmail(emailRequest);
      System.out.println("email based on a template was sent");

    } catch (SesV2Exception e) {
      System.err.println(e.awsErrorDetails().errorMessage());
      System.exit(1);
    }
  }


}
