package com.buzzardsview.needalight.security;

import com.buzzardsview.needalight.security.exception.InvalidTokenException;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;

@Component
public class GoogleTokenVerifier {

    private static final HttpTransport transport = new NetHttpTransport();
    private static final JsonFactory jsonFactory = new JacksonFactory();
    private static final String CLIENT_ID = System.getenv("g_id");


    public Payload verify(String idTokenString)
            throws GeneralSecurityException, IOException, InvalidTokenException {
        return GoogleTokenVerifier.verifyToken(idTokenString);
    }

    private static Payload verifyToken(String idTokenString)
            throws GeneralSecurityException, IOException, InvalidTokenException {
        final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.
                Builder(transport, jsonFactory)
                .setIssuers(Arrays.asList("https://accounts.google.com", "accounts.google.com"))
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();


        System.out.println("validating:" + idTokenString);

        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(idTokenString);
        } catch (IllegalArgumentException e){

        }

        if (idToken == null) {
            throw new InvalidTokenException("idToken is invalid");
        }

        return idToken.getPayload();
    }
}
