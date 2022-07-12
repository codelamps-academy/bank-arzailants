package com.codelamps.wss.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Nama : Andre Rizaldi Brillianto
 * Project : nasabah-webservice-app
 * Email : andrerizaldib@gmail.com
 * website : codelamps.com
 * instagram : codelamps.inc
 * telegram : @arzailants
 * github : codelamps-academy
 * medium : @codelamps
 * Date: 8/07/22
 */
@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NasabahNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;

    public NasabahNotFoundException(String message) {
        this.message = message;
    }
}
