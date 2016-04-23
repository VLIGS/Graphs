package roadgraph;

import geography.GeographicPoint;

public class MapEdge {
    private GeographicPoint start;
    private GeographicPoint end;
    private String streetName;
    private double distance;

    public MapEdge(GeographicPoint start, GeographicPoint end, String streetName, double distance){
        this.start = start;
        this.end = end;
        this.streetName = streetName;
        this.distance = distance;
    }
}
