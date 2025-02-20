package graphics;
import org.lwjgl.opengl.GL45.*;
import org.lwjgl.opengl.GL20.*;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.lwjgl.opengl.GL20.*;

//TODO: ERROR HANDLING BO INACZEJ STRASZNY PRZYPAŁ
public class Shader implements Bindable {
    public Shader(String vertexShaderPath,String pixelShaderPath) throws java.io.IOException{
        glProgramId = glCreateProgram();

        String vertexShaderCode = Files.readString(Path.of(vertexShaderPath));
        String pixelShaderCode = Files.readString(Path.of(pixelShaderPath));
        System.out.println(vertexShaderCode);
        System.out.println(pixelShaderCode);
        glVertexShaderId = createGlShader(vertexShaderCode,GL_VERTEX_SHADER);
        glPixelShaderId = createGlShader(pixelShaderCode,GL_FRAGMENT_SHADER);
        link();
        glDeleteShader(glVertexShaderId);
        glDeleteShader(glPixelShaderId);

    }
    public void Bind(long context){
        glUseProgram(glProgramId);
    }
    public void Unbind(long context){
        glUseProgram(0);
    }

    private int createGlShader(String code, int glType){
        int shaderId = glCreateShader(glType);
        glShaderSource(shaderId, code);
        glCompileShader(shaderId);
        glAttachShader(glProgramId,shaderId);
        return shaderId;
    }

    private void link(){
        glLinkProgram(glProgramId);

        if (glGetProgrami(glProgramId, GL_LINK_STATUS) == 0) {
            System.out.println("Error linking Shader code: " + glGetProgramInfoLog(glProgramId, 1024));
        }
        if (glVertexShaderId != 0) {
            glDetachShader(glProgramId, glVertexShaderId);
        }
        if (glPixelShaderId != 0) {
            glDetachShader(glProgramId, glPixelShaderId);
        }

        glValidateProgram(glProgramId);

    }

    private final int glProgramId;
    private final int glVertexShaderId;
    private final int glPixelShaderId;
}
