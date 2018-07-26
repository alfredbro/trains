package com.coxauto;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        InputSource inputSource = new InputSource();

        // inputSource.loadQAData(graph);
        inputSource.loadProdData(graph);

        Graph.calculateShortestPathFromSource(graph, inputSource.getNodeA());


        System.out.println("Shortest path from Node A: ");

        for(Node node : graph.getNodes()) {

            for(Node nodeLeg : node.getShortestPath()) {
                System.out.print(nodeLeg.getName());
                System.out.print(" -> ");
            }
            System.out.print(node.getName());

            System.out.print("    total distance: " + node.getDistance());
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("");
        }


        System.out.println("");
        System.out.println("");
        System.out.println("Route Distances");

//      // QA Data
//        System.out.println("Distance 1 = " + graph.calculateDistance("A-B-D"));
//        System.out.println("Distance 2 = " + graph.calculateDistance("A-B-F-E"));
//        System.out.println("Distance 3 = " + graph.calculateDistance("A-C-E"));

        System.out.println("");
        System.out.println("Output #1: " + graph.calculateDistance("A-B-C"));
        System.out.println("Output #2: " + graph.calculateDistance("A-D"));
        System.out.println("Output #3: " + graph.calculateDistance("A-D-C"));
        System.out.println("Output #4: " + graph.calculateDistance("A-E-B-C-D"));
        System.out.println("Output #5: " + graph.calculateDistance("A-E-D"));
    }
}
