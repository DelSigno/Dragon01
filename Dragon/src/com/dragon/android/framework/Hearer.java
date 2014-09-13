package com.dragon.android.framework;

import java.util.ArrayList;
import java.util.LinkedList;

import com.dragon.android.framework.InputActions.InputAction;

public interface Hearer {
	public void onHear(LinkedList<InputAction> inputList);
}
