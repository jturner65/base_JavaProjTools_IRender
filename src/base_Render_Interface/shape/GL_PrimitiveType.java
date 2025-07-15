package base_Render_Interface.shape;

import java.util.HashMap;
import java.util.Map;

import com.jogamp.opengl.GL2;

/**
 * Mesh building styles used with gl_beginMesh (glBegin) to describe the kind of OpenGL Primitives being built.
 * Possible values :
 * GL_POINTS : multiple points with no edges (GL_POINTS)
 * GL_LINES : every pair of points describes a distinct line/edge (GL_LINES)
 * GL_LINE_LOOP : builds a multi-sided polygon from list of points, with an edge between last and first vert (GL_LINE_LOOP)
 * GL_LINE_STRIP : adjacent pairs of verts are connected as lines (GL_LINE_STRIP)
 * GL_TRIANGLES : every triple of points describes a distinct triangle (GL_TRIANGLES)
 * GL_TRIANGLE_STRIP : draw triangle strip (i.e. GL_TRIANGLE_STRIP) 
 * GL_TRIANGLE_FAN : first vert + subsequent pairs form individual triangles (GL_TRIANGLE_FAN)
 * GL_QUADS : Treats each group of four vertices as an independent quadrilateral
 * GL_QUAD_STRIP : Defines connected quadrilaterals. One quadrilateral is defined for each pair 
 * of vertices presented after the first pair.
 * GL_POLYGON : A single convex polygon
 * @author John
 *
 */
public enum GL_PrimitiveType {
    /**
     * POINTS : multiple points with no edges (GL_POINTS)
     */
    GL_POINTS(GL2.GL_POINTS), 
    /**
     * LINES : every pair of points describes a distinct line/edge (GL_LINES)
     */        
    GL_LINES(GL2.GL_LINES),
    /**
     * LINE_LOOP : builds a multi-sided polygon from list of points, with an edge between last and first vert (GL_LINE_LOOP)
     */        
    GL_LINE_LOOP(GL2.GL_LINE_LOOP),
    /**
     * LINE_STRIP : adjacent pairs of verts are connected as lines (GL_LINE_STRIP)
     */
    GL_LINE_STRIP(GL2.GL_LINE_STRIP), 
    /**
     * TRIANGLES : every triple of points describes a distinct triangle (GL_TRIANGLES)
     */
    GL_TRIANGLES(GL2.GL_TRIANGLES), 
    /**
     * TRIANGLE_STRIP : draw triangle strip (i.e. GL_TRIANGLE_STRIP) 
     */
    GL_TRIANGLE_STRIP(GL2.GL_TRIANGLE_STRIP),    
    /**
     * TRIANGLE_FAN : first vert + subsequent pairs form individual triangles (GL_TRIANGLE_FAN)
     */
    GL_TRIANGLE_FAN(GL2.GL_TRIANGLE_FAN),
    //QUADS AND QUAD_STRIP BELOW ARE DEPRECATED IN OPEN GL 3.0 and removed after 3.1
    /**
     * QUADS : Treats each group of four vertices as an independent quadrilateral. (GL2.GL_QUADS)
     */
    GL_QUADS(GL2.GL_QUADS),
    /**
     * QUAD STRIP : Defines connected quadrilaterals. One quadrilateral is defined for each pair 
     * of vertices presented after the first pair.  (GL2.GL_QUAD_STRIP)
     */
    GL_QUAD_STRIP(GL2.GL_QUAD_STRIP),
    /**
     * POLYGON : A single convex polygon (GL2.GL_POLYGON)
     */
    GL_POLYGON(GL2.GL_POLYGON)
    ;
    
    private int value; 
    private final String[] _typeExplanation = new String[]{
        "Multiple points with no edges",
        "Every pair of points describes a distinct line/edge",
        "Builds a multi-sided polygon from list of points, with an edge between last and first vert",
        "Adjacent pairs of verts are connected as lines",
        "Every triple of points describes a distinct triangle",
        "Strip of Triangles",
        "First vert + subsequent pairs form individual triangles",
        "Every quartet of points describes a distinct quadrilateral",
        "Strip of Quadrilaterals - every pair of points after the first pair describes a distinct quadrilateral",
        "A convex polygon",
    };

    private static Map<Integer, GL_PrimitiveType> valmap = new HashMap<Integer, GL_PrimitiveType>(); 
    private static Map<Integer, GL_PrimitiveType> map = new HashMap<Integer, GL_PrimitiveType>(); 
    static { for (GL_PrimitiveType enumV : GL_PrimitiveType.values()) { valmap.put(enumV.value, enumV); map.put(enumV.ordinal(), enumV);}}
    private GL_PrimitiveType(int _val){value = _val;} 
    public String getName() {return this.name();}
    public int getVal(){return value;}     
    public static GL_PrimitiveType getEnumByIndex(int idx){return map.get(idx);}
    public static GL_PrimitiveType getEnumFromValue(int idx){return valmap.get(idx);}
    public static int getNumVals(){return map.size();}                        //get # of values in enum            
    @Override
    public String toString() { return ""+this.name()+":"+_typeExplanation[ordinal()]; }    
    public String toStrBrf() { return ""+_typeExplanation[ordinal()]; }    
}//enum GL_PrimitiveType
