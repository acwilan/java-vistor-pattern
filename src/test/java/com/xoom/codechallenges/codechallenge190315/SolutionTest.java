package com.xoom.codechallenges.codechallenge190315;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class SolutionTest {

    @Test
    public void solveFromInputStream() throws Exception {
        final InputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/sample2"));

        final Tree root = Solution.solveFromInputStream(inputStream);
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

}
