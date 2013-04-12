package org.gitistics.visitor.commit;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.gitistics.visitor.commit.edit.EditListVisitor;
import org.gitistics.visitor.commit.filechange.FileChangeCallback;

public class TreeWalkVisitorImpl implements CommitVisitor {

	private TreeWalkVisitorRoot root;
	
	private TreeWalkVisitorStandard standard;
	
	public TreeWalkVisitorImpl(Repository repository) {
		this.root = new TreeWalkVisitorRoot(repository);
		this.standard = new TreeWalkVisitorStandard(repository);
	}
	
	public void visit(RevCommit commit) {
		root.visit(commit);
		standard.visit(commit); 
	}

	public void setEditVisitors(EditListVisitor... editVisitors) {
		this.root.setEditVisitors(editVisitors);
		this.standard.setEditVisitors(editVisitors);
	}
	
	public void setFileChangeCallback(FileChangeCallback... fileChangeCallbacks) {
		this.root.setFileChangeCallback(fileChangeCallbacks);
		this.standard.setFileChangeCallback(fileChangeCallbacks);
	}
}