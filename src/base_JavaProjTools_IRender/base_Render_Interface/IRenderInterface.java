package base_JavaProjTools_IRender.base_Render_Interface;

import java.util.ArrayDeque;

import base_Math_Objects.vectorObjs.doubles.myPoint;
import base_Math_Objects.vectorObjs.doubles.myVector;
import base_Math_Objects.vectorObjs.floats.myPointf;
import base_Math_Objects.vectorObjs.floats.myVectorf;

/**
 * These are the functions that are expected to be found in a rendering class for proper rendering 
 * This interface is very much a work in progress - ultimately, everything that can be expected from
 * whatever rendering mechanism is being used should be referenced here so all consuming code can be
 * implementation agnostic
 * @author john
 *
 */
public interface IRenderInterface {
	//added to support old color constant defs from old projects - should be an enum
	public int gui_rnd = -1;
	public int gui_Black 	= 0;
	public int gui_White 	= 1;	
	public int gui_Gray 	= 2;
	
	public int gui_Red 	= 3;
	public int gui_Blue 	= 4;
	public int gui_Green 	= 5;
	public int gui_Yellow 	= 6;
	public int gui_Cyan 	= 7;
	public int gui_Magenta = 8;
	
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
	 * index of color definition next after static IRenderInterface defs
	 */
	public int gui_nextColorIDX = 41;
	/**
	 * colors used for axes
	 */
	public int[] rgbClrs = new int[]{gui_Red,gui_Green,gui_Blue};

	/**
	 * max ratio of width to height to use for windows
	 */
	public float maxWinRatio =  1.77777778f;
	/**
	 * size of printed text (default is 12)
	 */
	public int txtSz = 11;

	
	///////////////////////
	// required methods
	
	////////////////
	// initialization methods
	/**
	 * set smoothing level based on renderer
	 * @param smthLvl 0 == no smoothing,  	int: either 2, 3, 4, or 8 depending on the renderer
	 */
	public void setSmoothing(int smthLvl);
	
	///////////////////
	// query functions
	/**
	 * return target frame rate
	 * @return
	 */
	public float getFrameRate();
	
	/**
	 * returns the width of the visible display in pxls
	 * @return
	 */
	public int getDisplayWidth();
	/**
	 * returns the height of the visible display in pxls
	 * @return
	 */
	public int getDisplayHeight();
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
	 * returns integer color value corresponding to defined color
	 * @param colorVal int constant representing desired color
	 * @param alpha desired alpha color
	 * @return integer array of colors, with specified alpha
	 */
	default int[] getClr(int colorVal, int alpha){
		switch (colorVal){
			case gui_Black			         : { return new int[] {0,0,0,alpha};}
			case gui_Gray   		         : { return new int[] {120,120,120,alpha}; }
			case gui_White  		         : { return new int[] {255,255,255,alpha}; }
			case gui_Yellow 		         : { return new int[] {255,255,0,alpha}; }
			case gui_Cyan   		         : { return new int[] {0,255,255,alpha};} 
			case gui_Magenta		         : { return new int[] {255,0,255,alpha};}  
			case gui_Red    		         : { return new int[] {255,0,0,alpha};} 
			case gui_Blue			         : { return new int[] {0,0,255,alpha};}
			case gui_Green			         : { return new int[] {0,255,0,alpha};}  
			case gui_DarkGray   	         : { return new int[] {80,80,80,alpha};}
			case gui_DarkRed    	         : { return new int[] {120,0,0,alpha};}
			case gui_DarkBlue  	 	         : { return new int[] {0,0,120,alpha};}
			case gui_DarkGreen  	         : { return new int[] {0,120,0,alpha};}
			case gui_DarkYellow 	         : { return new int[] {120,120,0,alpha};}
			case gui_DarkMagenta	         : { return new int[] {120,0,120,alpha};}
			case gui_DarkCyan   	         : { return new int[] {0,120,120,alpha};}	   
			case gui_LightGray   	         : { return new int[] {200,200,200,alpha};}
			case gui_LightRed    	         : { return new int[] {255,110,110,alpha};}
			case gui_LightBlue   	         : { return new int[] {110,110,255,alpha};}
			case gui_LightGreen  	         : { return new int[] {110,255,110,alpha};}
			case gui_LightYellow 	         : { return new int[] {255,255,110,alpha};}
			case gui_LightMagenta	         : { return new int[] {255,110,255,alpha};}
			case gui_LightCyan   	         : { return new int[] {110,255,255,alpha};}
			case gui_FaintGray 		         : { return new int[] {110,110,110,alpha};}
			case gui_FaintRed 	 	         : { return new int[] {110,0,0,alpha};}
			case gui_FaintBlue 	 	         : { return new int[] {0,0,110,alpha};}
			case gui_FaintGreen 	         : { return new int[] {0,110,0,alpha};}
			case gui_FaintYellow 	         : { return new int[] {110,110,0,alpha};}
			case gui_FaintCyan  	         : { return new int[] {0,110,110,alpha};}
			case gui_FaintMagenta  	         : { return new int[] {110,0,110,alpha};}    	
			case gui_TransBlack  	         : { return new int[] {0,0,0,alpha/2};}  	
			case gui_TransGray  	         : { return new int[] {110,110,110,alpha/2};}
			case gui_TransLtGray  	         : { return new int[] {180,180,180,alpha/2};}
			case gui_TransRed  	         	 : { return new int[] {110,0,0,alpha/2};}
			case gui_TransBlue  	         : { return new int[] {0,0,110,alpha/2};}
			case gui_TransGreen  	         : { return new int[] {0,110,0,alpha/2};}
			case gui_TransYellow  	         : { return new int[] {110,110,0,alpha/2};}
			case gui_TransCyan  	         : { return new int[] {0,110,110,alpha/2};}
			case gui_TransMagenta  	         : { return new int[] {110,0,110,alpha/2};}	
			case gui_TransWhite  	         : { return new int[] {220,220,220,alpha/2};}	
			case gui_OffWhite				 : { return new int[] {255,255,235,alpha};}
			default         		         : { return getClr_Custom(colorVal,alpha);}    
		}//switch
	}//getClr
	/**
	 * any instancing-class-specific colors - colorVal set to be higher than IRenderInterface.gui_OffWhite
	 * @param colorVal
	 * @param alpha
	 * @return
	 */
	public int[] getClr_Custom(int colorVal, int alpha);
	/**
	 * return a random int color array, forcing alpha 255
	 * @return
	 */	
	default int[] getRndClr(){return getRndClr(255);	}	
	/**
	 * return a random int color array, passing alpha
	 * @return
	 */	
	public int[] getRndClr(int alpha);
	/**
	 * return a brighter random int color array, forcing alpha 255
	 * @return
	 */		
	default int[] getRndClrBright(){return getRndClrBright(255);}
	/**
	 * return a brighter random int color array, passing alpha
	 * @return
	 */		
	public int[] getRndClrBright(int alpha);
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
	/**
	 * set camera to passed 9-element values - should be called from window!
	 * @param camVals
	 */
	public void setCameraWinVals(float[] camVals);
	
	/**
	 * used to handle camera location/motion
	 */
	public void setCamOrient(float rx, float ry);
	/**
	 * used to draw text on screen without changing mode - reverses camera orientation setting
	 */
	public void unSetCamOrient(float rx, float ry);	
	
	/**
	 * translate by the given values
	 * @param x,y,z
	 */
	public void translate(float x, float y);
	default void translate(double x, double y) {translate((float)x,(float)y);	}
	public void translate(float x, float y, float z);
	default void translate(double x, double y, double z){translate((float)x,(float)y,(float)z);	}
	default void translate(myPoint p){translate((float)p.x,(float)p.y,(float)p.z);}
	default void translate(myPointf p){translate(p.x,p.y,p.z);}

	/**
	 * this will translate the passed box dimensions to keep them on the screen
	 * using p as start point and rectDims[2] and rectDims[3] as width and height
	 * @param P starting point
	 * @param rectDims box dimensions 
	 */
	public void transToStayOnScreen(myPointf P, float[] rectDims);	
	/**
	 * rotate by given theta around specified axis 
	 * @param thet
	 * @param x,y,z must be normalized
	 */
	public void rotate(float thet, float x, float y, float z);
	
	/**
	 * rotate by given theta around specified axis 
	 * @param thet
	 * @param axis must be normalized
	 */
	default void rotate(float thet, myPoint axis) {rotate(thet, (float)axis.x,(float)axis.y,(float)axis.z);}
	/**
	 * rotate by given theta around specified axis 
	 * @param thet
	 * @param axis must be normalized
	 */
	default void rotate(float thet, myPointf axis){rotate(thet, axis.x,axis.y,axis.z);}
	/**
	 * rotate by given theta around specified axis 
	 * @param thet
	 * @param x,y,z must be normalized
	 */
	default void rotate(float thet, double x, double y, double z) {rotate(thet, (float)x,(float)y,(float)z);};

	
	/**
	 * set scale by passed values
	 */
	public void scale(float x);
	public void scale(float x, float y);
	public void scale(float x, float y, float z);

	default void scale(double x) {scale((float)x);}
	default void scale(double x,double y) {scale((float)x,(float)y);}
	default void scale(double x, double y, double z) {scale((float)x,(float)y,(float)z);}	

	
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
	 * set fill color by value
	 * @param clr 1st 3 values denot integer color vals
	 * @param alpha 
	 */
	public void setFill(int r, int g, int b, int alpha);
	default void setFill(int[] clr, int alpha) {setFill(clr[0],clr[1],clr[2],alpha);}
	/**
	 * set fill color based on passed constant color index
	 * @param colorVal constant color index
	 * @param alpha desired alpha
	 */
	public void setColorValFill(int colorVal, int alpha);

	/**
	 * set stroke color by value
	 * @param clr rgba
	 * @param alpha 
	 */
	public void setStroke(int r, int g, int b, int alpha);
	default void setStroke(int[] clr, int alpha) {setStroke(clr[0],clr[1],clr[2],alpha);}
	
	/**
	 * set stroke color based on passed constant color index
	 * @param colorVal constant color index
	 * @param alpha desired alpha
	 */
	public void setColorValStroke(int colorVal, int alpha);
	
	/**
	 * set ambient fill color based on passed constant color index
	 * @param colorVal constant color index
	 * @param alpha desired alpha
	 */
	public void setColorValFillAmb(int colorVal, int alpha);
	
	/**
	 * tell current drawing cycle that there should be no stroke 
	 */
	public void noStroke();
	
	/**
	 * tell current drawing cycle that there should be no Fill Color 
	 */
	public void noFill();
	
	/**
	 * set stroke weight
	 */
	public void setStrokeWt(float stW);
	/**
	 * set general detail of sphere to be synthesized and drawn
	 * @param det
	 */	
	public void setSphereDetail(int det);
	
	/////////////////////////
	// display objects
	 /**
	  * changes normal for smooth shading
	  * @param V
	  */
	public void gl_normal(float x, float y, float z);          
	default void gl_normal(myVector V) {gl_normal((float)V.x, (float)V.y, (float)V.z);}          
	default void gl_normal(myVectorf V) {gl_normal(V.x, V.y, V.z);}   
	/**
	 * vertex for drawing shapes
	 * @param P
	 */
	public void gl_vertex(float x, float y, float z);   
	default void gl_vertex(myPoint V) {gl_vertex((float)V.x, (float)V.y, (float)V.z);}          
	default void gl_vertex(myPointf V) {gl_vertex(V.x, V.y, V.z);}   
	
	/**
	 * set fill color by value during shape building
	 * @param clr 1st 3 values denot integer color vals
	 * @param alpha 
	 */
	public void gl_SetFill(int r, int g, int b, int alpha);
	default void gl_SetFill(int[] clr, int alpha) {gl_SetFill(clr[0],clr[1],clr[2],alpha);}

	/**
	 * set stroke color by value during shape building
	 * @param clr rgba
	 * @param alpha 
	 */
	public void gl_SetStroke(int r, int g, int b, int alpha);
	default void gl_SetStroke(int[] clr, int alpha) {gl_SetStroke(clr[0],clr[1],clr[2],alpha);}
	/**
	 * begin an open gl shape
	 * @param type
	 */
	public void gl_beginShape(int type);
	default void gl_beginShape() {gl_beginShape(-1);}
	/**
	 * end an open gl shape
	 * @param type
	 */	
	public void gl_endShape(int type);
	default void gl_endShape() {gl_endShape(-1);}
	
	///////////////////////
	// point cloud
	/**
	 * draw a cloud of points with passed color values as an integrated shape
	 * @param numPts number of points to draw
	 * @param ptIncr incrementer between points, to draw only every 2nd, 3rd or more'th point
	 * @param h_part_clr_int 2d array of per point 3-color stroke values
	 * @param h_part_pos_x per point x value
	 * @param h_part_pos_y per point y value
	 * @param h_part_pos_z per point z value
	 */
	public void drawPointCloudWithColors(int numPts, int ptIncr, int[][] h_part_clr_int, float[] h_part_pos_x, float[] h_part_pos_y, float[] h_part_pos_z);

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
	 * set the detail of drawn spheres using passed detail value
	 * @param det
	 */

	/////////////////////////////////////////
	// objects

	
	/**
	 * draw a translucent represenation of a canvas plane ortho to eye-to-mouse vector
	 * @param eyeToMse vector 
	 * @param canvas3D
	 */
	public void drawCanvas(myVector eyeToMse, myPointf[] canvas3D);
	
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
	default void drawEllipse2D(myPoint p, float r){drawEllipse2D((float)p.x, (float)p.y, r, r);}	
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
	public void drawCircle3D(myPoint P, float r, myVector I, myVector J, int n);
	
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
	 * draw a cylinder frame centered at 2 points, with end cap colors
	 * @param A
	 * @param B
	 * @param r
	 * @param c1
	 * @param c2
	 */
	public void drawCylinder_NoFill(myPoint A, myPoint B, float r, int c1, int c2);
	/**
	 * draw a cylinder frame centered at 2 points, with end cap colors
	 * @param A
	 * @param B
	 * @param r
	 * @param c1
	 * @param c2
	 */
	public void drawCylinder_NoFill(myPointf A, myPointf B, float r, int c1, int c2);

	/**
	 * draw a cylinder centered at 2 points, with end cap colors
	 * @param A
	 * @param B
	 * @param r
	 * @param c1
	 * @param c2
	 */	
	public void drawCylinder(myPoint A, myPoint B, float r, int c1, int c2);
	/**
	 * draw a cylinder centered at 2 points, with end cap colors
	 * @param A
	 * @param B
	 * @param r
	 * @param c1
	 * @param c2
	 */
	public void drawCylinder(myPointf A, myPointf B, float r, int c1, int c2);	
	
	
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
	
	/**
	 * display text at x,y location
	 * @param txt
	 * @param x
	 * @param y
	 */
	public void showText(String txt, float x, float y);
	
	/**
	 * display text at x,y,x location
	 * @param txt
	 * @param x
	 * @param y
	 * @param z
	 */
	public void showText(String txt, float x, float y, float z );
	/**
	 * display an array of text at a location on screen
	 * @param d initial y location
	 * @param tclr text color
 	 * @param txtAra string array to display
	 */
	public void showOffsetTextAra(float d, int tclr, String[] txtAra);
	/**
	 * show array displayed at specific point on screens
	 * @param P
	 * @param rad
	 * @param det
	 * @param clrs
	 * @param txtAra
	 */
	public void showTxtAra(myPointf P, float rad, int det, int[] clrs, String[] txtAra);
	
	/**
	 * draw a box at a point containing an array of text
	 * @param P
	 * @param rad
	 * @param det
	 * @param clrs
	 * @param txtAra
	 * @param rectDims
	 */
	public void showBoxTxtAra(myPointf P, float rad, int det, int[] clrs, String[] txtAra, float[] rectDims);
	

	/**
	 * return the size, in pixels, of the passed text string, accounting for the currently set font dimensions
	 * @param txt the text string to be measured
	 * @return the size in pixels
	 */
	public float textWidth(String txt);
	


	
	//////////////////////
	// display text to console and screen
	/**
	 * return current array deque of console strings, to be printed to screen
	 * @return
	 */
	public ArrayDeque<String> getConsoleStrings();	
	
	
//	/**
//	 * print out multiple-line text to screen
//	 * @param str text to show
//	 * @param x x displacement of text
//	 * @param y y displacement of text
//	 */
//	public void ml_text(String str, float x, float y);	
	
	/**
	 * print out a string ara to screen with perLine # of strings per line
	 * @param sAra array of strings
	 * @param perLine # of strings per line to display to screen
	 */
	public void outStr2ScrAra(String[] sAra, int perLine);
	/**
	 * print out a string to screen
	 * @param str string to display
	 */	
	public void outStr2Scr(String str);
	/**
	 * print informational string data to console, and to screen
	 * @param str
	 * @param showDraw whether to show in graphical window as well as console
	 */
	public void outStr2Scr(String str, boolean showDraw);

	
	

	//TODO put all functions commonly used from myDispWindow and its inheritors in here to support different rendering engines


}//IRenderInterface
