package org.training.comcast;

import java.util.ArrayList;
import java.util.List;

public class BranchImpl implements Branch {
	private int noOfFlowers;
	private int noOfBranches;
	
	@Override
	public int getNumberOfFlowers() {
		return noOfFlowers;
	}

	@Override
	public List<Branch> getChildBranches() {
		List<Branch> list = new ArrayList<Branch>(noOfBranches);
		for (int i = 0; i < noOfBranches; i++) {
			list.add(new BranchImpl(noOfFlowers, i));
		}
		return list;
	}

	public BranchImpl(int noOfFlowers, int noOfBranches) {
		super();
		this.noOfFlowers = noOfFlowers;
		this.noOfBranches = noOfBranches;
	}

	@Override
	public String toString() {
		return "BranchImpl [noOfFlowers=" + noOfFlowers + ", noOfBranches=" + noOfBranches + "]";
	}
}
