package com.dragon.android.fonts;

import java.util.HashMap;

import com.dragon.android.data.Vec2;
import com.dragon.android.util.TextTextureHandler;
import com.dragon.android.util.TextureHandler;

public class BlockyBlackAndWhiteFont implements Font {

	private Vec2 letterSize;
	private final int texture;
	private final static float[] divisionMapping = TextTextureHandler.generateDivisionMap(8);
	
	//HASHMAP
	private static HashMap<String,Integer> letterLookup = new HashMap<String,Integer>(){{
		put(";",56);put(":",57);put("-",58);put("_",59);put("\"",60);put("(",61);put(")",62);
		put("w",48);put("x",49);put("y",50);put("z",51);put(".",52);put(",",53);put("!",54);put("?",55);
		put("o",40);put("p",41);put("q",42);put("r",43);put("s",44);put("t",45);put("u",46);put("v",47);
		put("g",32);put("h",33);put("i",34);put("j",35);put("k",36);put("l",37);put("m",38);put("n",39);
		put("Y",24);put("Z",25);put("a",26);put("b",27);put("c",28);put("d",29);put("e",30);put("f",31);
		put("Q",16);put("R",17);put("S",18);put("T",19);put("U",20);put("V",21);put("W",22);put("X",23);
		put("I",8);put("J",9);put("K",10);put("L",11);put("M",12);put("N",13);put("O",14);put("P",15);
		put("A",0);put("B",1);put("C",2);put("D",3);put("E",4);put("F",5);put("G",6);put("H",7);
		
		}
		@Override
		public Integer get(Object k) {
			return containsKey(k) ? super.get(k) : 63;
	}};
	
	//VERTEXMAP
	
		
		
	public BlockyBlackAndWhiteFont(Vec2 letterSize, int texture){
		this.letterSize = letterSize;
		this.texture = texture;	
		
		//This shouldn't be constant
		TextureHandler.setBlockySettings(texture);
		
	}
	
	@Override
	public Vec2 getLetterSize(){
		return letterSize;
	}
	
	@Override
	public int getTexture(){
		return texture;
	}

	@Override
	public HashMap<String,Integer> getLetterLookup() {
		return letterLookup;
	}
	
	@Override
	public float[] getDivisionMapping(){
		return divisionMapping;
	}

}
