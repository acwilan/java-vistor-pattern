package com.xoom.codechallenges.codechallenge190315;

class ProductOfRedNodesVisitor extends TreeVis {

    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result == 0 ? 1 : result) * node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result == 0 ? 1 : result) * leaf.getValue();
        }
    }

}
