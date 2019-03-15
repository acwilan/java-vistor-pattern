package com.xoom.codechallenges.codechallenge190315;

class SumInLeavesVisitor extends TreeVis {

    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}
