package com.dragon.android.framework.InputActions;

import com.dragon.android.data.Vec2;



public class Release implements InputAction{

	private Vec2 releasePos;

	public Release(Vec2 pressPos){
		this.releasePos = pressPos;
	}
	
	@Override
	public Vec2 get(){
		return releasePos;
	}

	@Override
	public InputTypes type() {
		return InputTypes.RELEASE;
	}
	
}
