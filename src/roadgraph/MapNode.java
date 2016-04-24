package roadgraph;

import geography.GeographicPoint;

import java.util.ArrayList;
import java.util.List;

public class MapNode {
    private GeographicPoint location;
    private List<MapEdge> myEdges;

    public MapNode(GeographicPoint location){
        this.location = location;
        myEdges = new ArrayList<MapEdge>();
    }
    public void addEdge(MapEdge edge){
        myEdges.add(edge);
    }
    public GeographicPoint getLocation(){
        return location;
    }
}


