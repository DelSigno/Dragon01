package com.dragon.android.framework.InputActions;

import com.dragon.android.data.Vec2;


public class Press implements InputAction{

	private Vec2 pressPos;

	public Press(Vec2 pressPos){
		this.pressPos = pressPos;
	}
	
	@Override
	public Vec2 get(){
		return pressPos;
	}

	@Override
	public InputTypes type() {
		return InputTypes.PRESS;
	}
	
}
