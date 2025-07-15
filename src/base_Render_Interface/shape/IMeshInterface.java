package base_Render_Interface.shape;

import base_Render_Interface.shape.base.IShapeInterface;

/**
 * Interface to describe mesh-based shape objects
 */
public interface IMeshInterface extends IShapeInterface {   
    
    /**
     * Beginning a shape without specification will be interpreted as a polygon
     */
    public void gl_beginShape();
    /**
     * Set ambient color to be passed hex color - only inside begin/end
     */
    public void gl_setAmbient(int _hexClr);
    /**
     * Set specular color to be passed hex color - only inside begin/end
     */
    public void gl_setSpecular(int _hexClr);
    /**
     * Set emissive color to be passed hex color - only inside begin/end
     */
    public void gl_setEmissive(int _hexClr);
    /**
     * Set shininess to be passed float value - only inside begin/end
     */
    public void gl_setShininess(float shininess);
    
}// interface IMeshInterface
