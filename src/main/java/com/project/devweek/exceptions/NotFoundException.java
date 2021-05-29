package com.project.devweek.exceptions;

import com.project.devweek.util.MessageUtils;

public class NotFoundException extends RuntimeException {
  
  public NotFoundException() {
    super(MessageUtils.NO_RECORDS_FOUND);
  }

}
