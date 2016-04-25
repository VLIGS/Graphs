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
    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeGeographicPoint1Null(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint to = new GeographicPoint(53.01799, -2.1675);
        myTestGraph.addEdge(null, to, "main street", "residential", 23.1 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeGeographicPoint2Null(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint from = new GeographicPoint(53.01799, -2.1675);
        myTestGraph.addEdge(from, null, "main street", "residential", 23.1 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeGeographicRoadNameNull(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint from = new GeographicPoint(53.01799, -2.1675);
        GeographicPoint to = new GeographicPoint(52.47, -1.9706);
        myTestGraph.addEdge(from, to, null, "residential", 23.1 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeGeographicRoadTypeNull(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint from = new GeographicPoint(53.01799, -2.1675);
        GeographicPoint to = new GeographicPoint(52.47, -1.9706);
        myTestGraph.addEdge(from, to, "main street", null, 23.1 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeGeographicLengthNull(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint from = new GeographicPoint(53.01799, -2.1675);
        GeographicPoint to = new GeographicPoint(52.47, -1.9706);
        myTestGraph.addEdge(from, to, "main street", "residential", 0.0 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeLengthNegative(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint from = new GeographicPoint(53.01799, -2.1675);
        GeographicPoint to = new GeographicPoint(52.47, -1.9706);
        myTestGraph.addEdge(from, to, "main street", "residential", -23.1 );

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeGeographicPoint1NotInGraph(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint from = new GeographicPoint(53.01799, -2.1675);
        GeographicPoint to = new GeographicPoint(52.47, -1.9706);
        myTestGraph.addVertex(to);
        myTestGraph.addEdge(from, to, "main street", "residential", 23.1 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeGeographicPoint2NotInGraph(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint from = new GeographicPoint(53.01799, -2.1675);
        GeographicPoint to = new GeographicPoint(52.47, -1.9706);
        myTestGraph.addVertex(from);
        myTestGraph.addEdge(from, to, "main street", "residential", 23.1 );
    }

    @Test
    public void testNumberOfEdgesEmptyGraph(){
        MapGraph myTestGraph = new MapGraph();
        assertEquals(0,myTestGraph.getNumEdges());
    }

    @Test
    public void testNumberOfEdgesGraphNoEdges(){
        MapGraph myTestGraph = new MapGraph();
        assertEquals(0,myTestGraph.getNumEdges());
    }

    @Test
    public void testNumberOfEdgesGraphWithEdges(){
        MapGraph myTestGraph = new MapGraph();
        GeographicPoint from = new GeographicPoint(53.01799, -2.1675);
        GeographicPoint to = new GeographicPoint(52.47, -1.9706);
        myTestGraph.addVertex(from);
        myTestGraph.addVertex(to);
        myTestGraph.addEdge(from, to, "main street", "residential", 23.1 );
        assertEquals(2,myTestGraph.getNumEdges());
    }
}
