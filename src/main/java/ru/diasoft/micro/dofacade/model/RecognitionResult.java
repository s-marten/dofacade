package ru.diasoft.micro.dofacade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecognitionResult {

    private Boolean result;

    private Double percent;
}
