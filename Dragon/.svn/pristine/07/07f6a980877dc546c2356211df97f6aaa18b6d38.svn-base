uniform mat4 u_CameraMatrix;

//Attributes represent per vertex data
attribute vec4 a_VertexPosition;
attribute vec2 a_TextureCoordinates;

varying vec2 v_TextureCoordinates;

void main()
{

	v_TextureCoordinates = a_TextureCoordinates;
	gl_Position = u_CameraMatrix * a_VertexPosition;

}