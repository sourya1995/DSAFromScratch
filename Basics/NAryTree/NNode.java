package Basics.NAryTree;

import java.util.ArrayList;
import java.util.List;

public class NNode {
    int data;
    List<NNode> children;

    public NNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(NNode child) {
        children.add(child);
    }
}
