package com.elsevier.assesment.techassessment.errorhandler;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
	
		
		return !response.getStatusCode().is2xxSuccessful();
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		
		switch (response.getStatusCode()) {
		case FORBIDDEN:
			System.err.println("You are trying too many times. please try again later ");
			break;
			
		case NOT_FOUND:
			System.err.println("The username is not exists in the git-hub repositiry / The contributer doesn't have any contibution in this repository");
			break;

		default:
			break;
		}
		
	}

}
