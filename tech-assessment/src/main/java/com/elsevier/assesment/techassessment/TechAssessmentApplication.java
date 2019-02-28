package com.elsevier.assesment.techassessment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.elsevier.assesment.techassessment.errorhandler.RestTemplateResponseErrorHandler;
import com.elsevier.assesment.techassessment.model.GitRepository;
import com.elsevier.assesment.techassessment.model.RepositoryContributers;

@SpringBootApplication(exclude = { JmxAutoConfiguration.class })
@AutoConfigurationPackage
public class TechAssessmentApplication {

	public static void main(String[] args) {

		//Getting the username from the user
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Git Repository username: ");
		try {
			String username = scanner.next();
			
			//this is the git-hub api domian
			String githubDomain = "https://api.github.com";

			
			RestTemplate restTemplate = new RestTemplate();
			
			//configuring the Response error handler for the http client 
			restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
			
			//sending a http request to fetch a repository for the user 
			ResponseEntity<GitRepository[]> gitRepositoryList = restTemplate
					.getForEntity(githubDomain + "/users/{username}/repos", GitRepository[].class, username);

			
			//check if there is no repository for this username
			if(gitRepositoryList.getBody().length==0) 
			{
				System.out.println("The username : " + username + " doesn't has repository to fetch.");
				return;	
				
			}
			
			System.out.println("The username : " + username + " has the following public repository with contributers");
			
			
			//Streaming the repos list and fetch the contributers

			Arrays.asList(gitRepositoryList.getBody()).stream().forEach(e -> {

				
				//fetching the repository contributer
				
				ResponseEntity<RepositoryContributers[]> gitRepositoryContributerList = restTemplate.getForEntity(
						githubDomain + "/repos/{username}/{repositoryId}/contributors", RepositoryContributers[].class,
						username, e.getName());
				
				//check t
				if(gitRepositoryContributerList.getBody().length==0) 
				{
					System.out.println("The repository "+e.getName()+" for the user "+username+" doesn't has any contributions");
				
				}
				e.setCollaborators(Arrays.asList(gitRepositoryContributerList.getBody()));
				e.getCollaborators().sort(Comparator.comparing(RepositoryContributers::getContributions));
				System.out.println(e.toString());

			});

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			System.exit(0);
		
		}

	}

}
