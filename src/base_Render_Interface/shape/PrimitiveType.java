package base_Render_Interface.shape;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for primitive constructs (point, line, rect, etc...) that are constructed and implemented as individual shapes
 */
public enum PrimitiveType {
    POINT(0),
    LINE(1),
    TRIANGLE(2),
    QUAD(3),
    RECT(4),
    ELLIPSE(5),
    ARC(6),
    SPHERE(7),
    BOX(8);
    private int value; 
    private final String[] _typeExplanation = new String[]{
        "A point", "A line", "A triangle", "A quad", "A rectangle", "An ellipse", "An arc", "A 3d sphere", "A 3d Box",
    };

    private static Map<Integer, PrimitiveType> valmap = new HashMap<Integer, PrimitiveType>(); 
    private static Map<Integer, PrimitiveType> map = new HashMap<Integer, PrimitiveType>(); 
    static { for (PrimitiveType enumV : PrimitiveType.values()) { valmap.put(enumV.value, enumV); map.put(enumV.ordinal(), enumV);}}
    private PrimitiveType(int _val){value = _val;} 
    public String getName() {return this.name();}
    public int getVal(){return value;}     
    public static PrimitiveType getEnumByIndex(int idx){return map.get(idx);}
    public static PrimitiveType getEnumFromValue(int idx){return valmap.get(idx);}
    public static int getNumVals(){return map.size();}                        //get # of values in enum            
    @Override
    public String toString() { return ""+this.name()+":"+_typeExplanation[ordinal()]; }    
    public String toStrBrf() { return ""+_typeExplanation[ordinal()]; }    
     

}//enum PrimitiveType
