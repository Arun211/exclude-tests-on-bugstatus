package org.allselenium.jiraImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JiraImpl {

	private static List<String> bugStatus = Arrays.asList("New", "Assigned", "Inprogress", "Resolved", "Reopened", "Verified");
	private static List<String> bugStatusToSkip = Arrays.asList("New", "Assigned", "Reopened", "Inprogress");
	
	public static boolean isBugValid(String bugId) {
		if(bugId != null && bugStatusToSkip.contains(getBugStatus(bugId))) {
			return true;
		} else {
			return false;
		}
	}
	
	private static String getBugStatus(String bugId) {
		/**
		 * code to get bug status
		 */
		return bugStatus.get(new Random().nextInt(6));
	}
}
