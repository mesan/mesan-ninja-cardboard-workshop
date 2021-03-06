package no.mesan.vr.mesanninja.shape;

import android.content.Context;
import android.opengl.GLES20;

import no.mesan.vr.mesanninja.util.GLUtils;
import no.mesan.vr.mesanninja.R;

/**
 * Created by Thomas on 28.09.2015.
 */
public class Cube extends Shape {
    public static final float[] CUBE_COORDS = new float[]{
            // Front face
            -1.0f, 1.0f, 1.0f,
            -1.0f, -1.0f, 1.0f,
            1.0f, 1.0f, 1.0f,
            -1.0f, -1.0f, 1.0f,
            1.0f, -1.0f, 1.0f,
            1.0f, 1.0f, 1.0f,

            // Right face
            1.0f, 1.0f, 1.0f,
            1.0f, -1.0f, 1.0f,
            1.0f, 1.0f, -1.0f,
            1.0f, -1.0f, 1.0f,
            1.0f, -1.0f, -1.0f,
            1.0f, 1.0f, -1.0f,

            // Back face
            1.0f, 1.0f, -1.0f,
            1.0f, -1.0f, -1.0f,
            -1.0f, 1.0f, -1.0f,
            1.0f, -1.0f, -1.0f,
            -1.0f, -1.0f, -1.0f,
            -1.0f, 1.0f, -1.0f,

            // Left face
            -1.0f, 1.0f, -1.0f,
            -1.0f, -1.0f, -1.0f,
            -1.0f, 1.0f, 1.0f,
            -1.0f, -1.0f, -1.0f,
            -1.0f, -1.0f, 1.0f,
            -1.0f, 1.0f, 1.0f,

            // Top face
            -1.0f, 1.0f, -1.0f,
            -1.0f, 1.0f, 1.0f,
            1.0f, 1.0f, -1.0f,
            -1.0f, 1.0f, 1.0f,
            1.0f, 1.0f, 1.0f,
            1.0f, 1.0f, -1.0f,

            // Bottom face
            1.0f, -1.0f, -1.0f,
            1.0f, -1.0f, 1.0f,
            -1.0f, -1.0f, -1.0f,
            1.0f, -1.0f, 1.0f,
            -1.0f, -1.0f, 1.0f,
            -1.0f, -1.0f, -1.0f,
    };

    public static final float[] CUBE_COLORS = new float[]{
            // front, green
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,

            // right, blue
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,

            // back, also green
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,

            // left, also blue
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,

            // top, red
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,

            // bottom, also red
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
            0.8359375f, 0.17578125f, 0.125f, 1.0f,
    };

    public static final float[] CUBE_FOUND_COLORS = new float[]{
            // front, yellow
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,

            // right, yellow
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,

            // back, yellow
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,

            // left, yellow
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,

            // top, yellow
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,

            // bottom, yellow
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
            1.0f, 0.6523f, 0.0f, 1.0f,
    };

    public Cube(Context context) {
        super(context);
    }

    @Override
    protected int getFragmentShader() {
        return GLUtils.loadGLShader(context, GLES20.GL_FRAGMENT_SHADER, R.raw.shape_fragment);
    }

    @Override
    protected float[] getShapeCoordinates() {
        return CUBE_COORDS;
    }

    @Override
    protected float[] getShapeColors() {
        return CUBE_COLORS;
    }
}
