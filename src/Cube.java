import java.awt.*;

class Cube {
    Vertex v1, v2, v3, v4;
    Color color;

    Cube(Vertex v1, Vertex v2, Vertex v3, Vertex v4, Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.color = color;
    }

    static class Matrix3 {
        double[] values;
        Matrix3(double[] values) {
            this.values = values;
        }
        Matrix3 multiply(Matrix3 other) {
            double[] result = new double[9];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    for (int i = 0; i < 3; i++) {
                        result[row * 3 + col] +=
                                this.values[row * 3 + i] * other.values[i * 3 + col];
                    }
                }
            }
            return new Matrix3(result);
        }
        Vertex transform(Vertex in) {
            return new Vertex(
                    in.x * values[0] + in.y * values[3] + in.z * values[6],
                    in.x * values[1] + in.y * values[4] + in.z * values[7],
                    in.x * values[2] + in.y * values[5] + in.z * values[8]
            );
        }
    }
}
