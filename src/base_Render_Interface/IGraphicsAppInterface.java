package base_Render_Interface;

import com.jogamp.newt.opengl.GLWindow;

import base_Math_Objects.vectorObjs.doubles.myPoint;
import base_Math_Objects.vectorObjs.doubles.myVector;
import base_Math_Objects.vectorObjs.floats.myPointf;
import base_Math_Objects.vectorObjs.floats.myVectorf;
import base_Render_Interface.base.IRenderInterface;
import base_Render_Interface.shape.GL_PrimitiveType;
import base_Render_Interface.shape.IMeshInterface;
import base_Render_Interface.shape.IPrimShapeInterface;
import base_Render_Interface.shape.PrimitiveType;

/**
 * These are the functions that are expected to be found in a rendering class for proper rendering for 
 * a graphics-based application. 
 * This interface is very much a work in progress - ultimately, everything that can be expected from
 * whatever rendering mechanism is being used should be referenced here so all consuming code can be
 * implementation agnostic
 * @author john
 *
 */
public interface IGraphicsAppInterface extends IRenderInterface {

    
    ///////////////////////
    // required methods
    
    ////////////////
    // initialization methods
    /**
     * Initialize render interface implementation.
     */
    public void initRenderInterface();
    /**
     * set smoothing level based on renderer
     * @param smthLvl 0 == no smoothing,      int: either 2, 3, 4, or 8 depending on the renderer
     */
    public void setSmoothing(int smthLvl);
    
    /**
     * set initial location of window
     * @param x the x location
     * @param y the y location
     */
    public void setLocation(int x, int y);
    
    ///////////////////
    // query functions
    /**
     * Return the underlying GL Window for this JOGL 
     * @return
     */
    public GLWindow getGLWindow();
    /**
     * return target frame rate
     * @return
     */
    public float getFrameRate();
    
    /**
     * returns application window width in pxls
     * @return
     */
    public int getWidth();
    /**
     * returns application window height in pxls
     * @return
     */
    public int getHeight();
      
    /**
     * return x screen value for 3d point
     * @param x
     * @param y
     * @param z
     */
    public float getSceenX(float x, float y, float z);
    /**
     * return Y screen value for 3d point
     * @param x
     * @param y
     * @param z
     */
    public float getSceenY(float x, float y, float z);
    /**
     * return screen value of z (Z-buffer) for 3d point
     * @param x
     * @param y
     * @param z
     */
    public float getSceenZ(float x, float y, float z);
    /**
     * get depth at specified screen dim location
     * @param x
     * @param y
     * @return
     */
    public float getDepth(int x, int y);    
    /**
     * determine world location as myPointf based on mouse click and passed depth
     * @param x
     * @param y
     * @param depth
     * @return
     */
    public myPointf getWorldLoc_f(int x, int y, float depth);
    
    /**
     * determine world location as myPoint based on mouse click and passed depth
     * @param x
     * @param y
     * @param depth
     * @return
     */
    public myPoint getWorldLoc(int x, int y, float depth);
    
    /**
     * return screen location of passed point in world
     * @param pt
     * @return
     */
    public myPoint getScrLocOf3dWrldPt(myPoint pt);
    
    /**
     * get mouse x,y in myPoint form from underlying render interface
     * @return
     */
    public myPoint getMouse_Raw();    
    /**
     * return mouse drag vector
     * @return
     */
    public myVector getMouseDrag();

    /**
     * get mouse x,y in as 2 d array of ints
     * @return
     */
    public int[] getMouse_Raw_Int();    
    /**
     * return mouse drag vector as 2d array of ints
     * @return
     */
    public int[] getMouseDrag_Int();
    
    /**
     * get mouse x,y in myPointf form from underlying render interface
     * @return
     */
    public myPointf getMouse_Raw_f();    
    /**
     * return mouse drag vector as float vector
     * @return
     */
    public myVectorf getMouseDrag_f();        
    
    /////////////////////
    // transformation stack and transformations    
    
    /**
     * Retrieve current push matrix/style depth - for debugging purposes.
     * @return
     */
    public int getCurrentPushMatDepth();
    /**
     * Retrieve current push style only depth - for debugging purposes.
     * @return
     */
    public int getCurrentPushStyleDepth();     
    /**
     * push gl transformation matrix onto trans stack, and possibly current style information if supported
     * @return push depth
     */
    public int pushMatState();
    /**
     * pop gl transformation matrix off of trans stack, and possibly current style information if supported
     * @return push depth
     */
    public int popMatState();
    /**
     * push current style/color params onto "style stack" (save current settings)
     *  @return style push depth
     */    
    public int pushJustStyleState();
    /**
     * pop current style/color params from "style stack" (restore/overwrite with last saved settings)
     *  @return style push depth
     */        
    public int popJustStyleState();
    
    //////
    // camera functions and projection matrices
    
    /**
     * set camera to passed 9-element values - should be called from window!
     * @param camVals
     */
    public void setCameraWinVals(float[] camVals);

    /**
     * used to handle camera location/motion
     * Use a final rotateX(MyMathUtils.HALF_PI_F) is to the scene with z up
     */
    public void setCamOrient(float rx, float ry);
    /**
     * used to draw text on screen without changing mode - reverses camera orientation setting
     * Use an initial rotateX(-MyMathUtils.HALF_PI_F) to remove the z-up orientation
     */
    public void unSetCamOrient(float rx, float ry);    
    
    /**
     * set perspective matrix based on frustum for camera
     * @param left left coordinate of the clipping plane
     * @param right right coordinate of the clipping plane
     * @param bottom bottom coordinate of the clipping plane
     * @param top top coordinate of the clipping plane
     * @param near near component of the clipping plane (> 0)
     * @param far far component of the clipping plane (> near)
     */
    public void setFrustum(float left, float right, float bottom, float top, float near, float far);
    
    /**
     * set perspective projection matrix for camera
     * @param fovy Vertical FOV
     * @param ar Aspect Ratio 
     * @param zNear Z position of near clipping plane
     * @param zFar Z position of far clipping plane 
     */
    public void setPerspective(float fovy, float ar, float zNear, float zFar);
    
    /**
     * set orthographic projection matrix for camera (2d or 3d)
     * @param left left plane of clipping volume
     * @param right right plane of the clipping volume
     * @param bottom bottom plane of the clipping volume
     * @param top top plane of the clipping volume
     * @param near maximum distance from the origin to the viewer
     * @param far maximum distance from the origin away from the viewer
     */
    public void setOrtho(float left, float right, float bottom, float top);
    public void setOrtho(float left, float right, float bottom, float top, float near, float far);
    //////
    // end camera functions and projection matrices
    
    /**
     * this will translate the passed box dimensions to keep them on the screen
     * using p as start point and rectDims[2] and rectDims[3] as width and height
     * @param P starting point
     * @param rectDims box dimensions 
     */
    public void transToStayOnScreen(myPointf P, float[] rectDims);    
    
    /////////////////
    /// shape/mesh creation
    /**
     * Create a mesh shape
     * @return
     */    
    public IMeshInterface createBaseMesh();  
    
    /**
     * Create a mesh shape
     * @param type of mesh to create
     * @return
     */    
    public IMeshInterface createBaseMesh(GL_PrimitiveType meshType);
    
    /**
     * Create a primitive shape
     * @param primType
     * @param params essential parameters required to build this construct (i.e. sphere radius)
     * @return
     */
    public IPrimShapeInterface createBasePrim(PrimitiveType primType, float... params);   
    
    /**
     * Create a mesh shape intended to be the parent of a group of shapes/meshes
     * @return
     */  
    public IMeshInterface createBaseGroupMesh();
    
    /**
     * Create a basic IMeshInterface and apply an initial transform to it. glBegin will specify the shape
     * @param transVec First applied transform - initial translation
     * @param scaleVec Scale applied after translate
     * @param rotAra First applied rotation
     * @param trans2Vec 2nd Applied translation
     * @param rotAra2 2nd Applied rotation
     * @param trans3Vec 3rd Applied translation
     * @param rotAra3 3rd Applied rotation
     * @return PShape created and transformed using passed transforms
     */
    public IMeshInterface createBaseMeshAndSetInitialTransform(myPointf transVec, myPointf scaleVec, float[] rotAra, myPointf trans2Vec, float[] rotAra2, myPointf trans3Vec, float[] rotAra3);
    
    
    ///////////////////////
    // display directives
    
    /**
     * opengl hint directive to not check for depth - use this to display text on screen
     */
    public void setBeginNoDepthTest();
    
    /**
     * opengl hint directive to start checking depth again
     */
    public void setEndNoDepthTest();
    
    /**
     * disable lights in scene
     */
    public void disableLights();
    
    /**
     * enable lights in scene
     */
    public void enableLights();    
    
    /**
     * Sets window title. AppMgr constructs window title
     * @param windowTitle string to display in the window titlebar
     */
    public void setWindowTitle(String windowTitle);

    /**
     * Set the background painted color for specified window idx
     * @param winIdx window idx to set color for
     * @param r
     * @param g
     * @param b
     * @param alpha
     */
    public void setRenderBackground(int winIdx, int r, int g, int b, int alpha);
    default void setRenderBackground(int winIdx, int[] clr, int alpha) {setRenderBackground(winIdx, clr[0],clr[1],clr[2],alpha);}
    
    /**
     * Draw the specified window's background color
     * @param winIdx
     */
    public void drawRenderBackground(int winIdx);
    
    /**
     * Load a background "skybox" sphere using texture from filename
     * @param idx window index using specified skybox sphere
     * @param filename Texture to use for background skybox sphere
     */
    public void loadBkgndSphere(int idx, String filename);
    
    /**
     * Set loaded background sphere as skybox for passed window idx
     * @param winIdx index of window to set 
     */
    public void drawBkgndSphere(int winIdx);

    /**
     * set general detail of sphere to be synthesized and drawn
     * @param det
     */    
    public void setSphereDetail(int det);
    /**
     * Get currently set global sphere detail
     * @return
     */
    public int getSphereDetail();
    
    ///////////////////////
    // point cloud
    /**
     * draw a cloud of points with all points having same color value as an integrated shape
     * @param numPts number of points to draw
     * @param ptIncr incrementer between points, to draw only every 2nd, 3rd or more'th point
     * @param ptClrIntAra array of 3-color stroke values for all points
     * @param ptPosX per point x value
     * @param ptPosY per point y value
     * @param ptPosZ per point z value
     */
    public void drawPointCloudWithColor(int numPts, int ptIncr, int[] ptClrIntAra, float[] ptPosX, float[] ptPosY, float[] ptPosZ);
    /**
     * draw a cloud of points with passed color values as an integrated shape
     * @param numPts number of points to draw
     * @param ptIncr incrementer between points, to draw only every 2nd, 3rd or more'th point
     * @param ptClrIntAra 2d array of per point 3-color stroke values
     * @param ptPosX per point x value
     * @param ptPosY per point y value
     * @param ptPosZ per point z value
     */
    public void drawPointCloudWithColors(int numPts, int ptIncr, int[][] ptClrIntAra, float[] ptPosX, float[] ptPosY, float[] ptPosZ);

    ////////////////////////
    // lines
    /**
     * draw line with given end points in 3d, represented as float coords
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     */
    public void drawLine(float x1, float y1, float z1, float x2, float y2, float z2);
    /**
     * draw line with given end points in 3d, represented as float coords
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     */
    default void drawLine(double x1, double y1, double z1, double x2, double y2, double z2){drawLine((float)x1,(float)y1,(float)z1,(float)x2,(float)y2,(float)z2 );}
    /**
     * draw line with given end points in 3d, represented as 2 points
     * @param p1
     * @param p2
     */
    default void drawLine(myPoint p1, myPoint p2){drawLine((float)p1.x,(float)p1.y,(float)p1.z,(float)p2.x,(float)p2.y,(float)p2.z);}
    /**
     * draw line with given end points in 3d, represented as 2 points
     * @param p1
     * @param p2
     */
    default void drawLine(myPointf p1, myPointf p2){drawLine(p1.x,p1.y,p1.z,p2.x,p2.y,p2.z);}
    /**
     * draw line with given end points in 3d, represented as 2 points with floating point coords, with start and end color represented as integer keys to color array
     * @param a
     * @param b
     * @param stClr
     * @param endClr
     */
    public void drawLine(myPointf a, myPointf b, int stClr, int endClr);
    /**
     * draw line with given end points in 3d, represented as 2 points with floating point coords, with start and end color represented as integer arrays
     * @param a
     * @param b
     * @param stClr
     * @param endClr
     */
    public void drawLine(myPointf a, myPointf b, int[] stClr, int[] endClr);    
    
    ////////////////////////
    // splines
    /**
     * implementation of catumull rom - array needs to be at least 4 points, if not, then reuses first and last points as extra cntl points  
     * @param pts
     */
    public void catmullRom2D(myPointf[] pts);
    /**
     * implementation of catumull rom - array needs to be at least 4 points, if not, then reuses first and last points as extra cntl points  
     * @param pts
     */
    public void catmullRom2D(myPoint[] pts);
    
    /**
     * implementation of 3d catumull rom - array needs to be at least 4 points, if not, then reuses first and last points as extra cntl points  
     * @param pts
     */
    public void catmullRom3D(myPointf[] pts);
    /**
     * implementation of 3d catumull rom - array needs to be at least 4 points, if not, then reuses first and last points as extra cntl points  
     * @param pts
     */
    public void catmullRom3D(myPoint[] pts);
    
    /**
     * draw a cubic bezier through passed points
     * @param A
     * @param B
     * @param C
     * @param D
     */
    public void bezier(myPoint A, myPoint B, myPoint C, myPoint D); // draws a cubic Bezier curve with control points A, B, C, D
    /**
     * draw a cubic bezier through passed points
     * @param C
     */
    default void bezier(myPoint [] C){bezier(C[0],C[1],C[2],C[3]);}  // draws a cubic Bezier curve with control points A, B, C, D
    /**
     * return a point on bezier curve described by array of points c, @ t
     * @param C
     * @param t
     * @return
     */
    public myPoint bezierPoint(myPoint[] C, float t);
    /**
     * return a tangent on bezier curve described by array of points c, @ t
     * @param C
     * @param t
     * @return
     */
    public myVector bezierTangent(myPoint[] C, float t);
    /**
     * Set a vertex's UV texture coordinates
     * @param P myPointf for vertex
     * @param u float u texture coordinate (0-1)
     * @param v float v texture coordinate (0-1)
     */
    public void vTextured(myPointf P, float u, float v);
    /**
     * Set a vertex's UV texture coordinates
     * @param P myPoint for vertex
     * @param u double u texture coordinate (0-1)
     * @param v double v texture coordinate (0-1)
     */
    public void vTextured(myPoint P, double u, double v);                       

    /////////////////////////////////////////
    // objects
    
    /**
     * draw a translucent representation of a canvas plane ortho to eye-to-mouse vector
     * @param eyeToMse vector 
     * @param canvas3D bounded points to draw polygon edge of canvas
     * @param color color to paint the canvas - should be translucent, 
     *                 light for dark backgrounds and dark for light backgrounds
     */
    public void drawCanvas(myVector eyeToMse, myPointf[] canvas3D, int[] color);
    
    /**
     * draw a sphere of specified radius
     * @param rad 
     */
    public void drawSphere(float rad);
    /**
     * draw a sphere of passed radius and detail at point P
     * @param P
     * @param rad
     * @param det
     */
    public void drawSphere(myPoint P, double rad, int det);
    /**
     * draw a sphere of passed radius and detail at point P
     * @param P
     * @param rad
     * @param det
     */
    public void drawSphere(myPointf P, float rad, int det);
    /**
     * draw a 2 d ellipse 
     * @param x
     * @param y
     * @param xr
     * @param yr
     */
    public void drawEllipse2D(float x, float y, float xr, float yr);
    /**
     * draw a 2 d ellipse 
     * @param a 4 element array : x,y,x rad, y rad
     */
    default void drawEllipse2D(float[] a) {drawEllipse2D(a[0],a[1],a[2],a[3]);}
    /**
     * draw a 2 d ellipse at point p (x,y) with radius r
     * @param p
     * @param r
     */
    default void drawEllipse2D(myPoint p, double r){drawEllipse2D((float)p.x, (float)p.y, (float)r, (float)r);}    
    /**
     * draw a 2 d ellipse at point p (x,y) with radius r
     * @param p
     * @param r
     */
    default void drawEllipse2D(myPointf p, float r){drawEllipse2D(p.x, p.y, r, r);}

    /**
     * draw a circle in 3d centered at P with specified radius r in plane proscribed by passed axes using n number of points
     * @param P center
     * @param r radius
     * @param I x axis
     * @param J y axis
     * @param n # of points to use
     */
    public void drawCircle3D(myPoint P, double r, myVector I, myVector J, int n);
    
    /**
     * draw a circle in 3d centered at P with specified radius r in plane proscribed by passed axes using n number of points
     * @param P center
     * @param r radius
     * @param I x axis
     * @param J y axis
     * @param n # of points to use
     */
    public void drawCircle3D(myPointf P, float r, myVectorf I, myVectorf J, int n);
    
    /**
     * draw a rectangle in 2D using the passed values as x,y,w,h
     * @param a 4 element array : x,y,w,h
     */
    public void drawRect(float a, float b, float c, float d);
    /**
     * draw a rectangle in 2D using the passed values as [x,y,w,h]
     * @param a array holding x,y,w,h
     */
    default void drawRect(float[] a) {drawRect(a[0],a[1],a[2],a[3]);}
    
    /**
     * draw a box centered at origin with passed dimensions, in 3D
     */
    public void drawBox3D(int x, int y, int z);
    
    /**
     * draw a 6 pointed star centered at p inscribed in circle radius r
     */
    public void drawStar2D(myPointf p, float r);
    /**
     * draw a triangle at 3 locations in 2D (only uses x,y)
     * @param a
     * @param b
     * @param c
     */
    public void drawTriangle2D(myPointf a, myPointf b, myPointf c);
    
    /**
     * draw a triangle at 3 locations in 2D (only uses x,y)
     * @param a
     * @param b
     * @param c
     */
    public void drawTriangle2D(myPoint a, myPoint b, myPoint c);
    
    /**
     * Draw a cylinder frame centered at 2 points, with end cap colors
     * @param A center of one end-cap of cylinder
     * @param B center of the other end-cap of cylinder
     * @param r radius of desired cylinder
     * @param c1 predefined color constant for color at end-cap A
     * @param c2 predefined color constant for color at end-cap B
     */
    default void drawCylinder_NoFill(myPoint A, myPoint B, double r, int c1, int c2) {
        drawCylinder_NoFill(A, B, r, getClr(c1, 255), getClr(c2, 255));
    }
    /**
     * Draw a cylinder frame centered at 2 points, with end cap colors
     * @param A center of one end-cap of cylinder
     * @param B center of the other end-cap of cylinder
     * @param r radius of desired cylinder
     * @param c1 predefined color constant for color at end-cap A
     * @param c2 predefined color constant for color at end-cap B
     */
    default void drawCylinder_NoFill(myPointf A, myPointf B, float r, int c1, int c2) {
        drawCylinder_NoFill(A, B, r, getClr(c1, 255), getClr(c2, 255));
    }

    /**
     * Draw a cylinder frame centered at 2 points, with end cap colors
     * @param A center of one end-cap of cylinder
     * @param B center of the other end-cap of cylinder
     * @param r radius of desired cylinder
     * @param c1 color at end-cap A
     * @param c2 color at end-cap B
     */
    public void drawCylinder_NoFill(myPoint A, myPoint B, double r, int[] c1, int[] c2);
    /**
     * Draw a cylinder frame centered at 2 points, with end cap colors
     * @param A center of one end-cap of cylinder
     * @param B center of the other end-cap of cylinder
     * @param r radius of desired cylinder
     * @param c1 color at end-cap A
     * @param c2 color at end-cap B
     */
    public void drawCylinder_NoFill(myPointf A, myPointf B, float r, int[] c1, int[] c2);
    
    
    /**
     * Draw a cylinder centered at 2 points, with end cap colors
     * @param A center of one end-cap of cylinder
     * @param B center of the other end-cap of cylinder
     * @param r radius of desired cylinder
     * @param c1 predefined color constant for color at end-cap A
     * @param c2 predefined color constant for color at end-cap B
     */    
    default void drawCylinder(myPoint A, myPoint B, double r, int c1, int c2) {
        drawCylinder(A, B, r, getClr(c1, 255), getClr(c2, 255));
    }
    
    /**
     * Draw a cylinder centered at 2 points, with end cap colors
     * @param A center of one end-cap of cylinder
     * @param B center of the other end-cap of cylinder
     * @param r radius of desired cylinder
     * @param c1 predefined color constant for color at end-cap A
     * @param c2 predefined color constant for color at end-cap B
     */
    default void drawCylinder(myPointf A, myPointf B, float r, int c1, int c2) {
        drawCylinder(A, B, r, getClr(c1, 255), getClr(c2, 255));
    }
    
    /**
     * Draw a cylinder centered at 2 points, with end cap colors
     * @param A center of one end-cap of cylinder
     * @param B center of the other end-cap of cylinder
     * @param r radius of desired cylinder
     * @param c1 color at end-cap A
     * @param c2 color at end-cap B
     */    
    public void drawCylinder(myPoint A, myPoint B, double r, int[] c1, int[] c2);
    
    /**
     * Draw a cylinder centered at 2 points, with end cap colors
     * @param A center of one end-cap of cylinder
     * @param B center of the other end-cap of cylinder
     * @param r radius of desired cylinder
     * @param c1 color at end-cap A
     * @param c2 color at end-cap B
     */
    public void drawCylinder(myPointf A, myPointf B, float r, int[] c1, int[] c2);
    
    /**
     * Draw a shape from the passed myPoint ara
     * @param ara array of myPoints
     */
    public void drawShapeFromPts(myPoint[] ara);
    
    /**
     * Draw a shape from passed myPoint array with given normal
     * @param ara array of myPoints
     * @param norm surface normal for resultant shape
     */
    public void drawShapeFromPts(myPoint[] ara, myVector norm);
    
    /**
     * Draw a shape from the given myPoint array of points with the given myVector array
     * of normals per point.  NOTE : point array size and normal array size is not checked.
     * 
     * @param ara array of myPoints
     * @param normAra array of per-point myVector surface normals for shape.
     * SIZE IS NOT VERIFIED - this must be at least as many normals
     * as there are points for shape
     */
    public void drawShapeFromPts(myPoint[] ara, myVector[] normAra);
    
    /**
     * Draw a shape from the passed myPointf ara
     * @param ara array of myPointfs
     */    
    public void drawShapeFromPts(myPointf[] ara);
    
    /**
     * Draw a shape from passed myPointf array with given normal
     * @param ara array of myPointfs
     * @param norm myVectorf surface normal for resultant shape
     */    
    public void drawShapeFromPts(myPointf[] ara, myVectorf norm);
    
    /**
     * Draw a shape from the given myPointf array of points with the given myVectorf array
     * of normals per point.  NOTE : point array size and normal array size is not checked.
     * 
     * @param ara array of myPointfs
     * @param normAra array of per-point myVectorf surface normals for shape.
     * SIZE IS NOT VERIFIED - this must be at least as many normals
     * as there are points for shape
     */    
    public void drawShapeFromPts(myPointf[] ara, myVectorf[] normAra);
        
    ////////////////////
    // showing double points as spheres or circles
    
    /**
     * show a point as a sphere, using double point as center
     * @param P point for center
     * @param r radius
     * @param det sphere detail
     * @param fclr fill color index
     * @param sclr scale color index
     */
    public void showPtAsSphere(myPoint P, double r, int det, int fclr, int sclr);
    /**
     * show a point as a sphere, using double point as center
     * @param P point for center
     * @param r radius
     * @param det sphere detail
     * @param fclr fill color array
     * @param sclr scale color array
     */
    public void showPtAsSphere(myPoint P, double r, int det, int[] fclr, int[] sclr);    
    /**
     * show a point as a flat circle, using double point as center
     * @param P point for center
     * @param r radius
     * @param fclr fill color index
     * @param sclr scale color index
     */
    public void showPtAsCircle(myPoint P, double r, int fclr, int sclr);
    /**
     * show a point as a flat circle, using double point as center
     * @param P point for center
     * @param r radius
     * @param det sphere detail
     * @param fclr fill color array
     * @param sclr scale color array
     */
    public void showPtAsCircle(myPoint P, double r, int[] fclr, int[] sclr);    
    /**
     * show a point either as a sphere or as a circle, with text
     * @param P
     * @param r
     * @param s
     * @param D
     * @param clr
     * @param flat
     */
    public void showPtWithText(myPoint P, double r, String s, myVector D, int clr, boolean flat);
    /**
     * draw a vector
     * @param ctr
     * @param len
     * @param v
     */
    public void showVec(myPoint ctr, double len, myVector v);
    /**
     * display text at a specific location in 3d
     * @param P location as point
     * @param s text to show
     */
    public void showTextAtPt(myPoint P, String s);
    /**
     * display text at a specific location in 3d, offset by vector displacement d
     * @param P location as point
     * @param s text to show
     * @param D displacement from point
     */
    public void showTextAtPt(myPoint P, String s, myVector D);
    
    ////////////////////
    // showing float points as spheres or circles
    
    /**
     * show a point as a sphere, using float point as center
     * @param P point for center
     * @param r radius
     * @param det sphere detail
     * @param fclr fill color index
     * @param sclr scale color index
     */
    public void showPtAsSphere(myPointf P, float r,int det, int fclr, int sclr);
    /**
     * show a point as a sphere, using float point as center
     * @param P point for center
     * @param r radius
     * @param det sphere detail
     * @param fclr fill color array
     * @param sclr scale color array
     */
    public void showPtAsSphere(myPointf P, float r, int det, int[] fclr, int[] sclr);
    
    /**
     * show a point as a flat circle, using float point as center
     * @param P point for center
     * @param r radius
     * @param fclr fill color index
     * @param sclr scale color index
     */
    public void showPtAsCircle(myPointf P, float r, int fclr, int sclr);
    /**
     * show a point as a flat circle, using float point as center
     * @param P point for center
     * @param r radius
     * @param det sphere detail
     * @param fclr fill color array
     * @param sclr scale color array
     */
    public void showPtAsCircle(myPointf P, float r, int[] fclr, int[] sclr);

    /**
     * show a point either as a sphere or as a circle, with text
     * @param P
     * @param r
     * @param s
     * @param D
     * @param clr
     * @param flat
     */
    public void showPtWithText(myPointf P, float r, String s, myVectorf D, int clr, boolean flat);
    /**
     * draw a vector
     * @param ctr
     * @param len
     * @param v
     */
    public void showVec(myPointf ctr, float len, myVectorf v);
    
    /**
     * display text at a specific location in 3d
     * @param P location as point
     * @param s text to show
     */
    public void showTextAtPt(myPointf P, String s);
    /**
     * display text at a specific location in 3d, offset by vector displacement d
     * @param P location as point
     * @param s text to show
     * @param D displacement from point
     */
    public void showTextAtPt(myPointf P, String s, myVectorf D);
    
    ////////////////////
    // showing text    
    /**
     * display text at x,y location
     * @param txt
     * @param x
     * @param y
     */
    public void showText(String txt, float x, float y);
    
    /**
     * display text at x,y,z location
     * @param txt
     * @param x
     * @param y
     * @param z
     */
    public void showText(String txt, float x, float y, float z );
    
    /**
     * display an array of text at a location on screen. Color needs to have been specified before calling.
     * @param x initial x location
     * @param y initial y location
      * @param txtAra string array to display
     */    
    public void showTextAra(float x, float y, String[] txtAra);
    
    /**
     * display an array of text at a location on screen
     * @param x initial x location
     * @param y initial y location
     * @param tclr text color
      * @param txtAra string array to display
     */
    public void showTextAra(float x, float y, int tclr, String[] txtAra);
    
    /**
     * show array displayed at specific point on screens
     * @param P
     * @param rad
     * @param det
     * @param clrs
     * @param txtAra
     */
    public void showTextAra(myPointf P, float rad, int det, int[] clrs, String[] txtAra);
    
    /**
     * draw a box at a point containing an array of text
     * @param P
     * @param rad
     * @param det
     * @param clrs
     * @param txtAra
     * @param rectDims
     */
    public void showBoxTextAra(myPointf P, float rad, int det, int[] clrs, String[] txtAra, float[] rectDims);    
    
    ////////////////////
    // showing centered text    
    /**
     * display text centered at x,y location
     * @param txt
     * @param ctrX x location of center
     * @param y
     */
    public void showCenteredText(String txt, float ctrX, float y);
    
    /**
     * display text centered at x,y,z location
     * @param txt
     * @param ctrX x location of center
     * @param y
     * @param z
     */
    public void showCenteredText(String txt, float ctrX, float y, float z );
    
    /**
     * display an array of text centered at a location on screen. Color needs to have been specified before calling.
     * @param ctrX x location of center
     * @param initY initial y location
      * @param txtAra string array to display
     */    
    public void showCenteredTextAra(float ctrX, float initY, String[] txtAra);
    
    /**
     * display an array of text centered at a location on screen
     * @param ctrX x location of center
     * @param initY initial y location
     * @param tclr text color
      * @param txtAra string array to display
     */
    public void showCenteredTextAra(float ctrX, float initY, int tclr, String[] txtAra);
        
    /**
     * return the size, in pixels, of the passed text string, accounting for the currently set font dimensions
     * @param txt the text string to be measured
     * @return the size in pixels
     */
    public float getTextWidth(String txt);
    
    /**
     * Set the current text font size
     * @param size
     */
    public void setTextSize(float size);

}//IGraphicsAppInterface
