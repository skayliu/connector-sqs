/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.model;

import com.amazonaws.services.sqs.model.MessageAttributeValue;
import io.camunda.connector.api.annotation.Secret;
import java.util.Map;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class QueueRequestData {

  @NotEmpty @Secret private String url;
  @NotEmpty @Secret private String region;

  @NotNull
  private Object messageBody; // we don't need to know the customer message as we will pass it as-is

  private Map<String, MessageAttributeValue> messageAttributes;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Object getMessageBody() {
    return messageBody;
  }

  public void setMessageBody(Object messageBody) {
    this.messageBody = messageBody;
  }

  public Map<String, MessageAttributeValue> getMessageAttributes() {
    return messageAttributes;
  }

  public void setMessageAttributes(Map<String, MessageAttributeValue> messageAttributes) {
    this.messageAttributes = messageAttributes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueueRequestData that = (QueueRequestData) o;
    return url.equals(that.url)
        && region.equals(that.region)
        && messageBody.equals(that.messageBody)
        && Objects.equals(messageAttributes, that.messageAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, region, messageBody, messageAttributes);
  }

  @Override
  public String toString() {
    return "QueueRequestData{"
        + "url='"
        + url
        + '\''
        + ", region='"
        + region
        + '\''
        + ", messageBody="
        + messageBody
        + ", messageAttributes="
        + messageAttributes
        + '}';
  }
}
