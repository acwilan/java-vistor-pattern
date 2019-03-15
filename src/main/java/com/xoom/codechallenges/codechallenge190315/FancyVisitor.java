package com.xoom.codechallenges.codechallenge190315;

class FancyVisitor extends TreeVis {

    private int nonLeafNodesSum = 0;
    private int greenLeafNodesSum = 0;

    public int getResult() {
        return Math.abs(nonLeafNodesSum - greenLeafNodesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafNodesSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafNodesSum += leaf.getValue();
        }
    }

}
