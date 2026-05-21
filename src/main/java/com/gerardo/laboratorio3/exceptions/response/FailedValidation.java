package com.gerardo.laboratorio3.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FailedValidation {
    private String field;
    private String message;
    private Object rejectedValue;
}
