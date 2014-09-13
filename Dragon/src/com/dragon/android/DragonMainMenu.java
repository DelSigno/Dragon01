package com.dragon.android;

import java.util.LinkedList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.os.Bundle;

import com.dragon.android.framework.Game;
import com.dragon.android.framework.InputListener;
import com.dragon.android.framework.OrthoCamera;
import com.dragon.android.framework.InputActions.InputAction;

public class DragonMainMenu extends Game {

	private OrthoCamera camera;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.maxPointers = 1;
		this.inputListener = new InputListener(maxPointers);
	}

	@Override
	public void onDrawFrame(GL10 arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSurfaceChanged(GL10 unused, int width, int height) {
		camera = new OrthoCamera(width, height);

	}

	@Override
	public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onHear(LinkedList<InputAction> actions) {
		// TODO Auto-generated method stub

	}

}
