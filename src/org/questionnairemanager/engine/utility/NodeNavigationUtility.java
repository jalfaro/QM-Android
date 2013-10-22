package org.questionnairemanager.engine.utility;

import java.util.HashMap;

import org.questionnairemanager.engine.data.qmc.Node;

import android.content.Context;

public class NodeNavigationUtility {

	private HashMap<String,Node> navigation;
	private Context context;
	private Node currentNode;
	
	public NodeNavigationUtility(Context ctx) {
		context = ctx;
	}
	
	

}
