import javax.swing.JApplet;
//classes Java 3d
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.TransformGroup;

import java.applet.Applet;
import java.awt.BorderLayout;

import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import com.sun.j3d.utils.geometry.ColorCube; 

public class cude3d extends Applet {

	/**
	 * Create the applet.
	 */
	public cude3d() {
		
		setLayout(new BorderLayout());
		
		Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
		add("Center", canvas3D);

		//Creating our 3d scene
		BranchGroup scene = createSceneGraph();

		scene.compile();

		//Creating a simple universe that will contain all our objects
		SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
		simpleU.addBranchGraph(scene); 

		simpleU.getViewingPlatform().setNominalViewingTransform();
		
	}
	
	public BranchGroup createSceneGraph()
	{
	    //Principal branchgroup
	    BranchGroup objRoot=new BranchGroup();
	    
	    TransformGroup tg = new TransformGroup();
	    
	    tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

	    Alpha rotationAlpha=new Alpha(-1,4000);

	    RotationInterpolator rotator=new RotationInterpolator(rotationAlpha,tg);

	    BoundingSphere bounds=new BoundingSphere();
	    rotator.setSchedulingBounds(bounds);
	    
	    tg.addChild(rotator);

	    objRoot.addChild(tg);
	    tg.addChild(new ColorCube(0.5));
	    return objRoot;
	}
	
	 public static void main(String[] args)
	 {
	     cude3d myApp=new cude3d();
	     myApp.setSize(600,600);
	     myApp.setVisible(true);
	 } 

}
