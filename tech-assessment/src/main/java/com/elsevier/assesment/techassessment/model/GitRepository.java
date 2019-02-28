package com.elsevier.assesment.techassessment.model;

import java.util.ArrayList;
import java.util.List;

public class GitRepository {

	private String name = null;
	private List<RepositoryContributers> collaborators = null;

	public GitRepository() {

		collaborators = new ArrayList<RepositoryContributers>();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RepositoryContributers> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(List<RepositoryContributers> collaborators) {
		this.collaborators = collaborators;
	}

	@Override
	public String toString() {
		String stringObject = "The repository Name: " + this.name + "  contains the following contributers \n\n";

		for (int i = 0; i < collaborators.size(); i++) {
			stringObject += "\t\t\t Contributer Name : " + collaborators.get(i).getLogin()
					+ " with Total No. of contribution = " + collaborators.get(i).getContributions() + "\n\n";

		}
		return stringObject;

	}
}
