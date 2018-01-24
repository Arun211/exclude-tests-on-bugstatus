package org.allselenium.redmineImpl;

import java.util.Arrays;
import java.util.List;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;

public class RedmineImpl {
	
	/**
	 * We may not need objects of this class for validation.
	 */
	private RedmineImpl() {};

	public static boolean isBugValid(String bugId) {
		List<String> bugStatusToSkip = Arrays.asList("New", "Assigned", "Reopened", "Inprogress");
		int id = 0;
		
		try {
			id = Integer.parseInt(bugId);
		} catch(NumberFormatException|NullPointerException exception) {
			return false;
		}
		
		if(bugStatusToSkip.contains(getBugStatus(id))) {
			return true;
		} else {
			return false;
		}
	}
	
	private static String getBugStatus(int bugId) {
	    String uri = "https://RedmineInstalledURL/";
	    
	    //API access key; Will be available in 'MyAccount' page in Redmine website
	    String apiAccessKey = "3cf072b039a8d07045f986562b25aa55087630be";
	
	    RedmineManager mgr = RedmineManagerFactory.createWithApiKey(uri, apiAccessKey);
	    IssueManager issueManager = mgr.getIssueManager();
	
	    //Get issue by ID
	    Issue issue;
		try {
			issue = issueManager.getIssueById(bugId);
		} catch (RedmineException e) {
			return null;
		}
		
		//Get issue status 
	    return issue.getStatusName();
	}
}
