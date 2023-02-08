import java.awt.Color;
import java.util.Arrays;
public class Colors {
    private Color[] colors;
    int size;
    int next;

    Colors(int n){
        this.size = n;
        this.colors = new Color[this.size];
        this.next = 0;
    }

    public void addColor(Color c){
        if (!Arrays.asList(this.colors).contains(c) && this.next < this.size){
            this.colors[this.next] = c;
            this.next++;
        }
    }

    public void addColors(Color[] c){
        int i;
        for (i = 0; i < c.length; i++){
            addColor(c[i]);
        }
    }

    private static double getDistance(int[] p1, int[] p2) throws Exception {
        if (p1.length != 3 || p2.length != 3) throw new Exception("invalid point");

        return Math.sqrt((p2[0] - p1[0])^2 + (p2[1] - p1[1])^2 + (p2[2] - p1[2])^2);
    }

    private static int[] toArray(Color c){
        return new int[] {c.getRed(), c.getGreen(), c.getBlue()};
    }

    public Color getClosestColor(Color x) throws Exception {
        int i;
        int[] c = toArray(x);
        Color closestColor = this.colors[0];
        double d, smallestDistance = getDistance(toArray(closestColor),c);

        for (i = 1; i < this.size; i++){
            int[] c1 = toArray(this.colors[i]);
            d =  getDistance(c, c1);
            if (d < smallestDistance){
                closestColor = this.colors[i];
            }
        }
        return closestColor;
    }
}
