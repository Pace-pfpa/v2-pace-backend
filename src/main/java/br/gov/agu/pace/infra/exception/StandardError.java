package br.gov.agu.pace.infra.exception;


import lombok.*;

import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardError {


    private Instant timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;
}
