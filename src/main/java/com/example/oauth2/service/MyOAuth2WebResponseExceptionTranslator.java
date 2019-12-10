package com.example.oauth2.service;

import com.example.oauth2.exception.MyOAuth2Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

@Component
public class MyOAuth2WebResponseExceptionTranslator implements
                                                    WebResponseExceptionTranslator<OAuth2Exception>{

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {

        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity
                .status(oAuth2Exception.getHttpErrorCode())
                .body(new MyOAuth2Exception(oAuth2Exception.getMessage()));
    }
}