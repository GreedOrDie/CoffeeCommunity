package com.theironyard.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by darionmoore on 1/26/17.
 */
@ResponseStatus(value = HttpStatus.CREATED)
public class CoffeeExistsException extends RuntimeException{
}
