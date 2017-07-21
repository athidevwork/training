package org.training;

import java.util.List;

public class FlowerCounter {
	public static void main(String[] args) {
		Branch branch = new BranchImpl(5, 2);
		int flowerCount = getTotalNumberOfFlowers(branch);
		System.out.println(branch.toString() + " = "+ flowerCount);
		branch = new BranchImpl(2, 2);
		flowerCount = getTotalNumberOfFlowers(branch);
		System.out.println(branch.toString() + " = "+ flowerCount);
		branch = new BranchImpl(5, 5);
		flowerCount = getTotalNumberOfFlowers(branch);
		System.out.println(branch.toString() + " = "+ flowerCount);		
	}
	
    public static int getTotalNumberOfFlowers( Branch branch ) {
        int count = 0;
    	List<Branch> branchList = branch.getChildBranches();
    	
    	for (Branch oneBranch : branchList) {
    		count += oneBranch.getNumberOfFlowers();
    	}
    	return count;
    }
}
