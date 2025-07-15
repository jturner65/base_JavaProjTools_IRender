package base_Render_Interface.shape.base;

import base_Render_Interface.base.IRenderInterface;

/**
 * Interface that describes either a primitive shape or a mesh-based shape
 */
public interface IShapeInterface extends IRenderInterface {
    
    /**
     * Whether object is visible/being rendered
     * @return
     */
    public boolean isVisible();
    /**
     * Set whether object should be visible/rendered
     */
    public void setIsVisible(boolean isVis);
    /**
     * Returns number of children meshes attached to this mesh
     */
    public int getNumChildren();
    /**
     * Get the child of this IMeshInterface object specified by the given layer
     * @param layer
     * @return
     */
    public IShapeInterface getChildShape(int layer);
    /**
     * Get the child of this IMeshInterface object with the given name
     * @param name
     * @return
     */
    public IShapeInterface getChildShape(String name);
    /**
     * Add the given child to this IMeshInterface. This IMeshInterface object needs to be defined as a group object.
     * @param child
     */
    public void addChildShape(IShapeInterface child);
    /**
     * Add the given child to this IMeshInterface at the specified index. This IMeshInterface object needs to be defined as a group object.
     * @param child
     */
    public void addChildShape(IShapeInterface child, int idx);

}//interface IShapeInterface
