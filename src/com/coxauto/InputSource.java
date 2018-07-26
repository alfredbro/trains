package com.coxauto;

/**
 * Created by rbrownin on 7/25/18.
 */
public class InputSource {

    private Node nodeA = new Node("UNINITIALIZED");


    public Node getNodeA() {
        return nodeA;
    }

    public void loadQAData(Graph graph) {

        this.nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        this.nodeA.addDestination(nodeB, 10);
        this.nodeA.addDestination(nodeC, 15);
        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);
        nodeC.addDestination(nodeE, 10);
        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);
        nodeF.addDestination(nodeE, 5);

        graph.addNode(this.nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
    }

    public void loadProdData(Graph graph) {

        this.nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        this.nodeA.addDestination(nodeB, 5);
        nodeB.addDestination(nodeC, 4);
        nodeC.addDestination(nodeD, 8);
        nodeD.addDestination(nodeC, 8);
        nodeD.addDestination(nodeE, 6);
        this.nodeA.addDestination(nodeD, 5);
        nodeC.addDestination(nodeE, 2);
        nodeE.addDestination(nodeB, 3);
        this.nodeA.addDestination(nodeE, 7);

        graph.addNode(this.nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
    }
}
