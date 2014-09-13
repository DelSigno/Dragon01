attribute vec4 a_Position;

uniform vec4 u_Color;
uniform mat4 u_Matrix;

void main()
{
	gl_Position =u_Matrix * a_Position;
	gl_PointSize = 1.0;
}