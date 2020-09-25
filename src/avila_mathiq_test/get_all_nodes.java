/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 *
 * @author ONYEKA
 */
public class get_all_nodes {
    public static ArrayList<Node>getAllNodes(Parent root){
    ArrayList<Node>nodes=new ArrayList<>();
      addAllDescendents(root, nodes);
    return nodes;
}

private static void addAllDescendents(Parent parent, ArrayList<Node> nodes) {
    for (Node node : parent.getChildrenUnmodifiable()) {
        nodes.add(node);
        if (node instanceof Parent)
            addAllDescendents((Parent)node, nodes);
    }
}
}
