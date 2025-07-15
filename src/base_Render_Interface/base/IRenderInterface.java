package base_Render_Interface.base;

import base_Math_Objects.MyMathUtils;
import base_Math_Objects.vectorObjs.doubles.myPoint;
import base_Math_Objects.vectorObjs.doubles.myVector;
import base_Math_Objects.vectorObjs.floats.myPointf;
import base_Math_Objects.vectorObjs.floats.myVectorf;
import base_Render_Interface.IGraphicsAppInterface;
import base_Render_Interface.shape.GL_PrimitiveType;

/**
 * Interface for renderable/rendering construct
 */
public interface IRenderInterface {

    //added to support old color constant defs from old projects - should be an enum?
    public int gui_rnd         = -1;
    public int gui_Black       = 0;
    public int gui_White      = 1;    
    public int gui_Gray      = 2;
    
    public int gui_Red         = 3;
    public int gui_Blue     = 4;
    public int gui_Green     = 5;
    public int gui_Yellow     = 6;
    public int gui_Cyan     = 7;
    public int gui_Magenta     = 8;
    
    public int gui_LightRed = 9;
    public int gui_LightBlue = 10;
    public int gui_LightGreen = 11;
    public int gui_LightYellow = 12;
    public int gui_LightCyan = 13;
    public int gui_LightMagenta = 14;
    public int gui_LightGray = 15;
    
    public int gui_DarkCyan = 16;
    public int gui_DarkYellow = 17;
    public int gui_DarkGreen = 18;
    public int gui_DarkBlue = 19;
    public int gui_DarkRed = 20;
    public int gui_DarkGray = 21;
    public int gui_DarkMagenta = 22;
    
    public int gui_FaintGray = 23;
    public int gui_FaintRed = 24;
    public int gui_FaintBlue = 25;
    public int gui_FaintGreen = 26;
    public int gui_FaintYellow = 27;
    public int gui_FaintCyan = 28;
    public int gui_FaintMagenta = 29;
    
    public int gui_TransBlack = 30;
    public int gui_TransGray = 31;
    public int gui_TransMagenta = 32;    
    public int gui_TransLtGray = 33;
    public int gui_TransRed = 34;
    public int gui_TransBlue = 35;
    public int gui_TransGreen = 36;
    public int gui_TransYellow = 37;
    public int gui_TransCyan = 38;    
    public int gui_TransWhite = 39;    
    public int gui_OffWhite = 40;
    /**
     * returns integer color value array corresponding to defined color
     * @param colorVal int constant representing desired color
     * @param alpha desired alpha color
     * @return integer array of colors, with specified alpha
     */
    default int[] getClr(int colorVal, int alpha){
        switch (colorVal){
            case gui_rnd                     : { return MyMathUtils.randomIntClrAra(alpha);}
            case gui_Black                   : { return new int[] {0,0,0,alpha};}
            case gui_Gray                    : { return new int[] {120,120,120,alpha}; }
            case gui_White                   : { return new int[] {255,255,255,alpha}; }
            case gui_Yellow                  : { return new int[] {255,255,0,alpha}; }
            case gui_Cyan                    : { return new int[] {0,255,255,alpha};} 
            case gui_Magenta                 : { return new int[] {255,0,255,alpha};}  
            case gui_Red                     : { return new int[] {255,0,0,alpha};} 
            case gui_Blue                    : { return new int[] {0,0,255,alpha};}
            case gui_Green                   : { return new int[] {0,255,0,alpha};}  
            case gui_DarkGray                : { return new int[] {80,80,80,alpha};}
            case gui_DarkRed                 : { return new int[] {120,0,0,alpha};}
            case gui_DarkBlue                : { return new int[] {0,0,120,alpha};}
            case gui_DarkGreen               : { return new int[] {0,120,0,alpha};}
            case gui_DarkYellow              : { return new int[] {120,120,0,alpha};}
            case gui_DarkMagenta             : { return new int[] {120,0,120,alpha};}
            case gui_DarkCyan                : { return new int[] {0,120,120,alpha};}       
            case gui_LightGray               : { return new int[] {200,200,200,alpha};}
            case gui_LightRed                : { return new int[] {255,110,110,alpha};}
            case gui_LightBlue               : { return new int[] {110,110,255,alpha};}
            case gui_LightGreen              : { return new int[] {110,255,110,alpha};}
            case gui_LightYellow             : { return new int[] {255,255,110,alpha};}
            case gui_LightMagenta            : { return new int[] {255,110,255,alpha};}
            case gui_LightCyan               : { return new int[] {110,255,255,alpha};}
            case gui_FaintGray               : { return new int[] {110,110,110,alpha};}
            case gui_FaintRed                : { return new int[] {110,0,0,alpha};}
            case gui_FaintBlue               : { return new int[] {0,0,110,alpha};}
            case gui_FaintGreen              : { return new int[] {0,110,0,alpha};}
            case gui_FaintYellow             : { return new int[] {110,110,0,alpha};}
            case gui_FaintCyan               : { return new int[] {0,110,110,alpha};}
            case gui_FaintMagenta            : { return new int[] {110,0,110,alpha};}        
            case gui_TransBlack              : { return new int[] {0,0,0,alpha/2};}      
            case gui_TransGray               : { return new int[] {110,110,110,alpha/2};}
            case gui_TransLtGray             : { return new int[] {180,180,180,alpha/2};}
            case gui_TransRed                : { return new int[] {110,0,0,alpha/2};}
            case gui_TransBlue               : { return new int[] {0,0,110,alpha/2};}
            case gui_TransGreen              : { return new int[] {0,110,0,alpha/2};}
            case gui_TransYellow             : { return new int[] {110,110,0,alpha/2};}
            case gui_TransCyan               : { return new int[] {0,110,110,alpha/2};}
            case gui_TransMagenta            : { return new int[] {110,0,110,alpha/2};}    
            case gui_TransWhite              : { return new int[] {220,220,220,alpha/2};}    
            case gui_OffWhite                : { return new int[] {255,255,235,alpha};}   
        }//switch
        return new int[] {120,120,120,alpha};
    }//getClr
    
    
    /**
     * index of color definition next after static IGraphicsAppInterface defs
     */
    public int gui_nextColorIDX = 41;
    /**
     * colors used for axes
     */
    public int[] rgbClrs = new int[]{gui_Red,gui_Green,gui_Blue};

    
    
    /////////////////////////
    /// Color creation and specification 
    
    /**
     * Takes argb color in hex, and converts to array of [0-255] ints for r,g,b,alpha
     * @param argb hex color of format 0xAARRGGBB
     * @return array of [0-255] ints with 3 colors r,g,b if no alpha given, or 
     * 4 colors r,g,b,alpha if alpha present and non-zero
     */
    default int[] getClrFromHex(int argb) {
        int b = argb & 0xFF;
        int tmpRgb = argb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        tmpRgb &= 0xFF;
        //alpha value
        if (tmpRgb > 0) {
            return new int[] {r,g,b,tmpRgb};
        }
        // No alpha given, so 3 element array r,g,b
        return new int[] {r,g,b};
    }
    
    /**
     * return a randomly chosen color index as defined in IGraphicsAppInterface
     * @return
     */
    default int getRndClrIndex(){return MyMathUtils.randomInt(0,IGraphicsAppInterface.gui_nextColorIDX);}   
    
    /**
     * Return an array holding random 4-int stroke (idx 0) and fill (idx 1) color where the fill is a lighter, scaled version of the stroke
     * @return
     */
    default int[][] getRndMatchedStrkFillClrs(){
        int[] strkColor = MyMathUtils.randomIntClrAra(255);
        int[] fillClr = new int[4];
        for(int i=0;i<3;++i ) {
            // make fill color ~80% brighter
            fillClr[i] = (strkColor[i] + 1024)/5;    
        }
        fillClr[3] = 255;
        return new int[][] {strkColor, fillClr};
    }//getRndMatchedStrkFillClrs
    
    
    /**
     * Returns ARGB hex value of passed color values. Assumes r,g,b are all 0-255 range (forces alpha to 255)
     * Mod 256 is performed on all values, so all rgb values should be [0,255]
     */
    default int getClrAsHex(int r, int g, int b) {
        return 0xFF000000 + (r & 0xFF)<<16 + (g & 0xFF) << 8 + (b & 0xFF);
    }
    
    /**
     * Returns ARGB hex value of passed color values. Assumes r,g,b,alpha are all 0-255 range
     * Mod 256 is performed on all values, so all rgb values should be [0,255]
     */
    default int getClrAsHex(int r, int g, int b, int alpha) {
        int res = 0;
        if (alpha > 0){res = ((alpha & 0xFF)<<24);}//A
        return res + ((r & 0xFF)<<16) + ((g & 0xFF) << 8) + (b & 0xFF);
    }
    /**
     * Returns ARGB hex value of passed RGB color value array. Assumes array values all 0-255 range
     */
    default int getClrAsHex(int[] clrs) {return getClrAsHex(clrs[0],clrs[1],clrs[2]);}
    
    /**
     * Returns ARGB hex value of passed RGB color value array with alpha. Assumes array values and alpha all 0-255 range
     */
    default int getClrAsHex(int[] clrs, int alpha) {return getClrAsHex(clrs[0],clrs[1],clrs[2], alpha);}

    /**
     * Returns ARGB hex value of passed color expressed as point.  Assumes point representation is integer RGB range 0-255
     */
    default int getClrAsHex(myPoint p) {return getClrAsHex((int)p.x,(int)p.y,(int)p.z);}
    /**
     * Returns ARGB hex value of passed color expressed as point.  Assumes point representation is integer RGB range 0-255
     */
    default int getClrAsHex(myPointf p) {return getClrAsHex((int)p.x,(int)p.y,(int)p.z);}
    /**
     * Returns ARGB hex value of passed color expressed as point.  Assumes point representation is integer RGB range 0-255
     */
    default int getClrAsHex(myPoint p, int alpha){return getClrAsHex((int)p.x,(int)p.y,(int)p.z, alpha);}
    /**
     * Returns ARGB hex value of passed color expressed as point.  Assumes point representation is integer RGB range 0-255
     */
    default int getClrAsHex(myPointf p, int alpha){return getClrAsHex((int)p.x,(int)p.y,(int)p.z, alpha);}
    
    /**
     * Returns alpha value [0-255] from passed hex color
     */
    default int getAlpha(int argb) {return (argb>>24)& 0xFF;}
    /**
     * Returns red value [0-255] from passed hex color
     */
    default int getRed(int argb) {return (argb>>16) & 0xFF;}
    /**
     * Returns green value [0-255] from passed hex color
     */
    default int getGreen(int argb) {return (argb>>8) & 0xFF;}
    /**
     * Returns blue value [0-255] from passed hex color
     */
    default int getBlue(int argb) {return argb & 0xFF;}

    /**
     * return an interpolation between two colors
     * @param a Initial color, as integer array [0,255]
     * @param b Final color, as integer array [0,255]
     * @param t time value, between 0.0 and 1.0
     * @return Integer array of color values [0,255] between a and b
     */
    default Integer[] getClrMorph(int[] a, int[] b, double t) {
        if(t==0){return new Integer[]{a[0],a[1],a[2],a[3]};} else if(t==1){return new Integer[]{b[0],b[1],b[2],b[3]};}
        return new Integer[]{(int)(((1.0f-t)*a[0])+t*b[0]),(int)(((1.0f-t)*a[1])+t*b[1]),(int)(((1.0f-t)*a[2])+t*b[2]),(int)(((1.0f-t)*a[3])+t*b[3])};
    }
    
    /////////////////////////
    // Shape Creation modification parameters
    /**
     * begin an open GL shape
     * @param type
     */
    public void gl_beginShape(GL_PrimitiveType primType);
    /**
     * Begin an open GL default shape : GL_PrimitiveType.GL_POLYGON
     */
    default void gl_beginShape() {gl_beginShape(GL_PrimitiveType.GL_POLYGON);}
    /**
     * End an open GL shape
     * @param isClosed Whether shape is closed or not
     */    
    public void gl_endShape(boolean isClosed);
    /**
     * End an open GL shape without closing it.
     */
    default void gl_endShape() {gl_endShape(false);}
    
    /**
     * Set normal for smooth shading
     * @param x
     * @param y
     * @param z
     */
    public void gl_normal(float x, float y, float z);          
    /**
     * Set normal for smooth shading
     * @param V normalized vector
     */
    default void gl_normal(myVector V) {gl_normal((float)V.x, (float)V.y, (float)V.z);}          
    /**
     * Set normal for smooth shading
     * @param V normalized vector
     */
    default void gl_normal(myVectorf V) {gl_normal(V.x, V.y, V.z);}
    
    /**
     * Set a vertex for drawing shapes
     * @param P
     */
    public void gl_vertex(float x, float y, float z);   
    /**
     * vertex for drawing shapes
     * @param P
     */
    default void gl_vertex(myPoint V) {gl_vertex((float)V.x, (float)V.y, (float)V.z);}          
    /**
     * vertex for drawing shapes
     * @param P
     */
    default void gl_vertex(myPointf V) {gl_vertex(V.x, V.y, V.z);}       
    /**
     * Set a vertex for drawing shapes with u,v coords
     * @param P
     */
    public void gl_vertex(float x, float y, float z, float u, float v);     
    
    ///////////////////////////////////////
    /// Fill and stroke specification
    
    ///
    /// Fill
    ///
    /**
     * Set fill color by value for a specified object (within gl_beginShape/gl_endShape)
     * @param r integer red 0-255
     * @param g integer green 0-255
     * @param b integer blue 0-255
     * @param alpha integer alpha 0-255
     */
    public void gl_setFill(int r, int g, int b, int alpha);
    /**
     * Set fill color by passed hex argb color, assumes alpha >0, otherwise forces to be 255
     * @param rgb 
     */
    default void gl_setFill(int argb) {
        int b = argb & 0xFF;
        int tmpRgb = argb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int alpha = tmpRgb > 0 ? tmpRgb : 255;  
        gl_setFill(r,g,b,alpha);
    }
    
    /**
     * Set fill color by passed hex argb color, assumes alpha >0, otherwise forces to be 255
     * @param rgb 
     */
    default void gl_setFill(int rgb, int alpha) {
        int b = rgb & 0xFF;
        int tmpRgb = rgb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8; 
        gl_setFill(r,g,b,alpha);
    }
    
    /**
     * Set fill color by value for a specified object (within gl_beginShape/gl_endShape)
     * @param clr integer array of color 0-255
     * @param alpha integer alpha 0-255
     */
    default void gl_setFill(int[] clr, int alpha) {gl_setFill(clr[0],clr[1],clr[2],alpha);}
    /**
     * Set to have no fill color for a specified object (within gl_beginShape/gl_endShape)
     */
    public void gl_setNoFill();
    
    /**
     * set fill color by value
     * @param clr 1st 3 values denote integer color vals
     * @param alpha 
     */
    public void setFill(int r, int g, int b, int alpha);
    
    /**
     * Turn off fill
     */
    public void setNoFill();
    
    /**
     * Set fill color by passed hex argb color, assumes alpha >0, otherwise forces to be 255
     * @param rgb 
     */
    default void setFill(int argb) {
        int b = argb & 0xFF;
        int tmpRgb = argb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int alpha = tmpRgb > 0 ? tmpRgb : 255;  
        setFill(r,g,b,alpha);
    }
    
    /**
     * Set fill color by passed hex argb color, assumes alpha >0, otherwise forces to be 255
     * @param rgb 
     */
    default void setFill(int rgb, int alpha) {
        int b = rgb & 0xFF;
        int tmpRgb = rgb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8; 
        setFill(r,g,b,alpha);
    }  
    default void setFill(int[] clr, int alpha) {setFill(clr[0],clr[1],clr[2],alpha);}
    /**
     * set fill color based on passed constant color index
     * @param colorVal constant color index
     * @param alpha desired alpha
     */
    default void setColorValFill(int colorVal, int alpha){
        if(colorVal == gui_TransBlack) {
            setFill(1,1,1,1);//    have to use hex so that alpha val is not lost
        } else {
            setFill(getClr(colorVal, alpha), alpha);
        }    
    }//setcolorValFill   
    
    
    ///
    /// Stroke
    ///
    /**
     * Set stroke color by value for a specified object (within gl_beginShape/gl_endShape)
     * @param r
     * @param g
     * @param b
     * @param alpha
     */
    public void gl_setStroke(int r, int g, int b, int alpha);
 
    
    /**
     * Set stroke color by passed hex argb color, assumes alpha >0, otherwise forces to be 255
     * @param rgb 
     */
    default void gl_setStroke(int argb) {
        int b = argb & 0xFF;
        int tmpRgb = argb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int alpha = tmpRgb > 0 ? tmpRgb : 255;  
        gl_setStroke(r,g,b,alpha);
    }
    /**
     * Set stroke color by passed hex argb color, assumes alpha >0, otherwise forces to be 255
     * @param rgb 
     */
    default void gl_setStroke(int rgb, int alpha) {
        int b = rgb & 0xFF;
        int tmpRgb = rgb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        gl_setStroke(r,g,b,alpha);
    }
    
    /**
     * Set stroke color by value for a specified object (within gl_beginShape/gl_endShape)
     * @param clr integer array of color 0-255
     * @param alpha integer alpha 0-255
     */
    default void gl_setStroke(int[] clr, int alpha) {gl_setStroke(clr[0],clr[1],clr[2],alpha);}
    /**
     * Set to have no stroke color for a specified object (within gl_beginShape/gl_endShape)
     */
    public void gl_setNoStroke();    
    /**
     * Set stroke weight for a specified object (within gl_beginShape/gl_endShape)
     * @param wt
     */
    public void gl_setStrokeWt(float wt);
    
    /**
     * set stroke color by value
     * @param clr rgba
     * @param alpha 
     */
    public void setStroke(int r, int g, int b, int alpha);
    
    /**
     * Turn off stroke
     */
    public void setNoStroke();
    
    /**
     * Set stroke color by passed hex argb color, assumes alpha >0, otherwise forces to be 255
     * @param rgb 
     */
    default void setStroke(int argb) {
        int b = argb & 0xFF;
        int tmpRgb = argb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int alpha = tmpRgb > 0 ? tmpRgb : 255;  
        setStroke(r,g,b,alpha);
    }
    /**
     * Set stroke color by passed hex argb color, assumes alpha >0, otherwise forces to be 255
     * @param rgb 
     */
    default void setStroke(int rgb, int alpha) {
        int b = rgb & 0xFF;
        int tmpRgb = rgb>>8;
        int g = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        int r = tmpRgb & 0xFF;
        tmpRgb >>= 8;
        setStroke(r,g,b,alpha);
    }
    
    default void setStroke(int[] clr, int alpha) {setStroke(clr[0],clr[1],clr[2],alpha);}
    
    /**
     * set stroke color based on passed constant color index
     * @param colorVal constant color index
     * @param alpha desired alpha
     */
    default void setColorValStroke(int colorVal, int alpha){
        setStroke(getClr(colorVal, alpha), alpha);        
    }//setcolorValStroke    
    
    /**
     * set stroke weight
     */
    public void setStrokeWt(float stW);   
    
    /**
     * 
     * @param _hexClr
     */
    public void setAmbient(int _hexClr);
    /**
     * 
     * @param _hexClr
     */
    public void setSpecular(int _hexClr);
    /**
     * 
     * @param _hexClr
     */
    public void setEmissive(int _hexClr);
    /**
     * 
     * @param _shininess
     */
    public void setShininess(float _shininess); 
    
         
    ///////////////////////////
    /// Transformations
    
    /**
     * 2D translate by the given values
     * @param x
     * @param y
     */
    public void translate(float x, float y);
    /**
     * 2D translate by the given values
     * @param x
     * @param y
     */
    default void translate(double x, double y) {translate((float)x,(float)y);    }
    
    /**
     * 3D translate by the given values
     * @param x
     * @param y
     * @param z
     */
    public void translate(float x, float y, float z);
    /**
     * 3D translate by the given values
     * @param x
     * @param y
     * @param z
     */
    default void translate(double x, double y, double z){translate((float)x,(float)y,(float)z);    }
    /**
     * 3D translate by the given point values
     * @param p
     */
    default void translate(myPoint p){translate((float)p.x,(float)p.y,(float)p.z);}
    /**
     * 3D translate by the given point values
     * @param p
     */
    default void translate(myPointf p){translate(p.x,p.y,p.z);}

    /**
     * Rotate by given theta around specified axis
     * @param thet angle to rotate in radians
     * @param x x component of axis
     * @param y y component of axis
     * @param z z component of axis
     */
    public void rotate(float thet, float x, float y, float z);
    /**
     * Rotate by given theta around specified axis
     * @param thet angle to rotate in radians
     * @param x x component of axis
     * @param y y component of axis
     * @param z z component of axis
     */
    default void rotate(float thet, double x, double y, double z) {rotate(thet, (float)x,(float)y,(float)z);};
    /**
     * Rotate by given theta around specified axis 
     * @param thet angle to rotate in radians
     * @param axis rotation axis vector must be normalized
     */
    default void rotate(float thet, myPoint axis) {rotate(thet, (float)axis.x,(float)axis.y,(float)axis.z);}
    /**
     * Rotate by given theta around specified axis 
     * @param thet angle to rotate in radians
     * @param axis rotation axis vector must be normalized
     */
    default void rotate(float thet, myPointf axis){rotate(thet, axis.x,axis.y,axis.z);}
    /**
     * Rotate by given theta around x axis
     * @param thet
     */
    default void rotateX(float thet) {rotate(thet, 1.0f, 0, 0);}
    /**
     * Rotate by given theta around y axis
     * @param thet
     */
    default void rotateY(float thet) {rotate(thet, 0, 1.0f, 0);}
    /**
     * Rotate by given theta around z axis
     * @param thet
     */
    default void rotateZ(float thet) {rotate(thet, 0, 0, 1.0f);}

    /**
     * Scale an object uniformly in all dimensions
     * @param s scale amount applied equally in all dimensions
     */
    public void scale(float s);
    /**
     * Scale an object by given fractions
     * @param x x dimension scale amount
     * @param y y dimension scale amount
     */
    public void scale(float x, float y);
    /**
     * Scale an object by given fractions
     * @param x x dimension scale amount
     * @param y y dimension scale amount
     * @param z z dimension scale amount
     */
    public void scale(float x, float y, float z);
    
    /**
     * Scale an object uniformly in all dimensions
     * @param s scale amount applied equally in all dimensions
     */
    default void scale(double s) {scale((float)s);}
    /**
     * Scale an object by given fractions
     * @param x x dimension scale amount
     * @param y y dimension scale amount
     */
    default void scale(double x,double y) {scale((float)x,(float)y);}
    /**
     * Scale an object by given fractions
     * @param x x dimension scale amount
     * @param y y dimension scale amount
     * @param z z dimension scale amount
     */
    default void scale(double x, double y, double z) {scale((float)x,(float)y,(float)z);}       

    ///////////////////////
    /// drawing/rendering
    
    /**
     * Loop to execute program code and render buffers.
     */
    public void draw();
}// interface IRenderInterface
