package com.dragon.android.util;

import static android.opengl.GLES20.*;


import android.util.Log;




public class ShaderHandler {
	
	private static final String TAG = "ShaderHelper" ;
	
	//Easy way to handle Vertex and Fragment Shaders
	public static int compileVertexShader(String shaderCode) {
		//Compiles the source as a vertex shader
		return compileShader(GL_VERTEX_SHADER, shaderCode);
	}
	public static int compileFragmentShader(String shaderCode) {
		//Compiles the source as a fragment shader
		return compileShader(GL_FRAGMENT_SHADER, shaderCode);
	}
	
	//Main code for compiling a shader. Returns the location of the compiled shader if successful
	//or a zero if something failed
	private static int compileShader(int type, String shaderCode) {
		
		//Creates shader ID object in openGL and returns it's location
		final int shaderObjectId = glCreateShader(type);
		//If there was an issue and the Shader wasn't creates reports in in verbose
		//This will also return zero as there will be no shader in openGL to work on
		if (shaderObjectId == 0) {
			Logger.loggerVerbose(TAG , "Shader ID not created, it was zero.");
			return 0;
		}
		
		//Updates the shader's source code preparing it for compilation
		glShaderSource(shaderObjectId, shaderCode);
		//Compiles the shader source code previously entered
		glCompileShader(shaderObjectId);
		
		//Creates a pointer that will be used for debugging
		final int[] compileStatus = new int[1];
		//Checks to see if the shader was successfully compiled, returns zero if failed
		glGetShaderiv(shaderObjectId, GL_COMPILE_STATUS, compileStatus, 0);
		//Now that we are finished and have successfully compiled our code we print the openGL info log for the specific shader
		Logger.loggerVerbose(TAG , "Results of compiling source:" + "\n" + shaderCode + "\n:" + glGetShaderInfoLog(shaderObjectId));
		
		if (compileStatus[0] == 0) {
			// If it failed we delete the shader object, report it was a failure, and return a zero
			glDeleteShader(shaderObjectId);
			Logger.loggerVerbose(TAG, "Failed to compile shader, check that shit!");
			return 0;
		}
		
		//We have successfully created and compiled the shader, we return its openGL ID.
		return shaderObjectId;	
	}

	//linkProgram links a vertex and fragment shader and returns the ID of the newly created
	//program. Returns 0 if failed.
	public static int linkProgram(int vertexShaderId, int fragmentShaderId) {
			
		//Creates an OpenGL program, glCreateProgram() returns its OpenGL ID
		final int programObjectId = glCreateProgram();
		//Checks to see if the program creation was successful
		if (programObjectId == 0) {
			Logger.loggerVerbose(TAG, "Failed to create openGL program object.");
		}
		
		//The following does the grunt work of attaching our shaders to our program
		//Adds the vertex shader to our program
		glAttachShader(programObjectId, vertexShaderId);
		//Adds the fragment shader to our program
		glAttachShader(programObjectId, fragmentShaderId);
		//Links the two shader together
		glLinkProgram(programObjectId);
		
		
		//Contains the status of the link, 0 means it failed
		final int[] linkStatus = new int[1];
		//populates linkStatus with... the link's status.
		glGetProgramiv(programObjectId, GL_LINK_STATUS, linkStatus, 0);
		// Print the program info log to the Android log output.
		Logger.loggerVerbose(TAG, "Results of linking program:\n" + glGetProgramInfoLog(programObjectId));

		//checks to see if like was successful
		if (linkStatus[0] == 0) {
			// If it failed, delete the program object.
			glDeleteProgram(programObjectId);
			Logger.loggerDebug(TAG, "Linking program was a failure, fix dis shit!");
			return 0;
		}
	
		return programObjectId;
	}

	//Gives you some info on program, returns a 0 if invalid
	public static boolean validateProgram(int programObjectId) {
		
		glValidateProgram(programObjectId);
		final int[] validateStatus = new int[1];
		glGetProgramiv(programObjectId, GL_VALIDATE_STATUS, validateStatus, 0);
		Logger.loggerDebug(TAG, "Results of validating program: " + validateStatus[0] + "\nLog:" + glGetProgramInfoLog(programObjectId));
		
		return validateStatus[0] != 0;
	}
	
	
	//Main program method responsible for taking two shader strings and outputting a completed program
	public static int buildProgram(String vertexShaderSource,String fragmentShaderSource,boolean validate) {
		
		int program;
		
		// Compile the shaders.
		int vertexShader = compileVertexShader(vertexShaderSource);
		int fragmentShader = compileFragmentShader(fragmentShaderSource);
		
		// Link them into a shader program.
		program = linkProgram(vertexShader, fragmentShader);
		
		if (validate) {
			validateProgram(program);
		}
		
		return program;
	}
}
