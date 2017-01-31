package com.theironyard.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by darionmoore on 1/28/17.
 */
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class CoffeeNotFoundException extends RuntimeException {
}
