package roadgraph;

import geography.GeographicPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMapGraph {

    @Test
    public void testAddVertexPassInNull(){
        MapGraph myTestGraph = new MapGraph();
        assertEquals(false, myTestGraph.addVertex(null));
    }
    @Test
    public void testAddVertexPassNewVertex(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint location = new GeographicPoint(53.01799, -2.1675);
        assertEquals(true, myTestGraph.addVertex(location));
    }
    @Test
    public void testAddVertexPassInExistingVertex(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint location = new GeographicPoint(53.01799, -2.1675);
        myTestGraph.addVertex(location);
        assertEquals(false, myTestGraph.addVertex(location));
    }
}
