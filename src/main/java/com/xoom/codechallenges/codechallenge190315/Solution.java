package com.xoom.codechallenges.codechallenge190315;

import java.io.InputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static Tree solve() {
        return solveFromInputStream(System.in);
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    static Tree solveFromInputStream(final InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream);
        final int nodeCount = scanner.nextInt();
        final int[] values = new int[nodeCount];
        final Color[] colors = new Color[nodeCount];
        final int[] depths = new int[nodeCount];
        final List<Map.Entry<Integer, Integer>> relations = new ArrayList<>();
        final Set<Integer> nodes = new HashSet<>();
        for (int nodeIndex = 0; nodeIndex < nodeCount; nodeIndex++) {
            values[nodeIndex] = scanner.nextInt();
        }
        for (int nodeIndex = 0; nodeIndex < nodeCount; nodeIndex++) {
            colors[nodeIndex] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        while (scanner.hasNext()) {
            final int nodeParent = scanner.nextInt() - 1;
            final int nodeChild = scanner.nextInt() - 1;
            if (nodeParent == 0) {
                depths[nodeParent] = 0;
            }
            depths[nodeChild] = depths[nodeParent] + 1;
            relations.add(new AbstractMap.SimpleEntry<>(nodeParent, nodeChild));
            nodes.add(nodeParent);
            nodes.remove(nodeChild);
        }
        final Map<Integer, Tree> trees = new HashMap<>(nodeCount);
        for (int nodeIndex = 0; nodeIndex < nodeCount; nodeIndex++) {
            final Tree tree =
                    nodes.contains(nodeIndex) ?
                    new TreeNode(values[nodeIndex], colors[nodeIndex], depths[nodeIndex]) :
                    new TreeLeaf(values[nodeIndex], colors[nodeIndex], depths[nodeIndex]);
            trees.put(nodeIndex, tree);
        }
        for (Map.Entry<Integer, Tree> entry : trees.entrySet()) {
            final Tree tree = entry.getValue();
            if (tree instanceof TreeNode) {
                final TreeNode treeNode = (TreeNode) tree;
                for (Map.Entry<Integer, Integer> relation : relations) {
                    if (relation.getKey() == entry.getKey()) {
                        treeNode.addChild(trees.get(relation.getValue()));
                    }
                }
            }
        }
        return trees.get(0);
    }
}
