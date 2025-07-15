package base_Render_Interface.image;

import java.util.HashMap;
import java.util.Map;

/**
 * Interface for images, describing functional contract TODO not used yet
 */
public interface IImageInterface {
    
    /**
     * Format of an image
     */
    public enum ImageFormat{
        RGB(1), //3 channel
        ARGB(2), // 4 channel
        ALPHA(4); // grayscale using alpha channel
        private int value; 
        private final String[] _typeExplanation = new String[]{
            "RGB 3 Channel",
            "ARGB 4 Channel",
            "ALPHA Alpha Channel grayscale"
        };

        private static Map<Integer, ImageFormat> valmap = new HashMap<Integer, ImageFormat>(); 
        private static Map<Integer, ImageFormat> map = new HashMap<Integer, ImageFormat>(); 
        static { for (ImageFormat enumV : ImageFormat.values()) { valmap.put(enumV.value, enumV); map.put(enumV.ordinal(), enumV);}}
        private ImageFormat(int _val){value = _val;} 
        public String getName() {return this.name();}
        public int getVal(){return value;}     
        public static ImageFormat getEnumByIndex(int idx){return map.get(idx);}
        public static ImageFormat getEnumFromValue(int idx){return valmap.get(idx);}
        public static int getNumVals(){return map.size();}                        //get # of values in enum            
        @Override
        public String toString() { return ""+this.name()+":"+_typeExplanation[ordinal()]; }    
        public String toStrBrf() { return ""+_typeExplanation[ordinal()]; }    
    }
    
    

}//interface IImageInterface 
