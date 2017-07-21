package org.training;

import java.util.List;

public interface Branch {
    // Returns number of flowers for this branch
    int getNumberOfFlowers();

    // Return the branches that sprouted from this branch
    List<Branch> getChildBranches();
}
