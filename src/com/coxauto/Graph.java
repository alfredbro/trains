package com.coxauto;

import java.util.*;

/**
 * Created by rbrownin on 7/25/18.
 */
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }


    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {

        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for(Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();

            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {

        Integer sourceDistance = sourceNode.getDistance();

        if(sourceDistance + edgeWeight < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeight);

            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }


    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);


        while(unsettledNodes.size() > 0) {

            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for(Map.Entry<Node, Integer> adjacentPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacentPair.getKey();
                Integer edgeWeigth = adjacentPair.getValue();

                if(!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeigth, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }

            settledNodes.add(currentNode);
        }

        return graph;
    }


    public String calculateDistance(String routes) {

        String[] routeLegs = routes.split("-");

        Node legOrigin = this.findOrigin(routeLegs[0]);
        Node legDestination = null;
        int distanceBucket = 0;

        for(int i = 1; i < routeLegs.length; i++) {

            Map.Entry<Node, Integer> entryLegDestination = this.findAdjacent(legOrigin, routeLegs[i]);

            if(entryLegDestination == null) {
                return "NO SUCH ROUTE";
            }

            distanceBucket += entryLegDestination.getValue();
            // System.out.println("Node " + entryLegDestination.getKey().getName() + " has distance " + entryLegDestination.getValue());

            legOrigin = entryLegDestination.getKey();
        }

        return String.valueOf(distanceBucket);
    }


    public Node findOrigin(String originName) {

        for(Node node : this.nodes) {

            if(node.getName().equals(originName)) {
                return node;
            }

        }
        return null;
    }


    public Map.Entry<Node, Integer> findAdjacent(Node node, String adjacentName) {

        for (Map.Entry<Node, Integer> entry : node.adjacentNodes.entrySet()) {
            // System.out.println("     entry name: " + entry.getKey().getName() + "   distance: " + entry.getValue());
            if(entry.getKey().getName().equals(adjacentName)) {
                return entry;
            }
        }

        return null;
    }

}

