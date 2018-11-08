
public class SeamCarver {
	Picture picture;
	int w;
	int h;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.picture = picture;
		if (picture == null) {
			System.out.println("picture is null");
			return;
		}
		this.w = picture.width();
		this.h = picture.height();

	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return w;
	}

	// height of current picture
	public int height() {
		return h;
	}

	// energy of pixel at column x and row y

	public double energy(int x, int y) {
		if (x == 0 || x == w - 1) {
		return 1000;
	}
	else if (y == 0 || y == h - 1) {
		return 1000;
	}
	int rx = picture.get(x, y-1).getRed() - picture.get(x, y+1).getRed();
		int gx = picture.get(x, y-1).getGreen() - picture.get(x, y+1).getGreen();
		int bx = picture.get(x, y-1).getBlue() - picture.get(x, y+1).getBlue();
		double xs = (rx*rx) + (gx*gx) + (bx*bx);
		int ry = picture.get(x-1, y).getRed() - picture.get(x+1, y).getRed();
		int gy = picture.get(x-1, y).getGreen() - picture.get(x+1, y).getGreen();
		int by = picture.get(x-1, y).getBlue() - picture.get(x+1, y).getBlue();
		double ys = (ry*ry) + (gy*gy) + (by*by);
		double result = Math.sqrt(xs+ys);
		return result;
}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}