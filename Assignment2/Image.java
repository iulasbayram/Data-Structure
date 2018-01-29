public class Image {
	public int width ;
	public int height ;
	public byte[] ulas ;
	public Image(int w, int h) {
		width = w;
		height = h;
		ulas = new byte[width*height];

		
	}
	public void setPixel(int y, int x, byte intensity){
		intensity= ulas[y*width+x];
		}
	public void savePGM(String filename){
		Out abc = new Out(filename);
		abc.println("P2");
		for  (int i=0 ; i<width ; i++)
			for (int j=0; j<height; j++)
				abc.printf(ulas[i]);
	}
	public byte loadPGM(String filename){
		In abcd = new In(filename);
		byte intensity=abcd.readByte();
		return intensity;
	}
	public static void main(String[] args){
		Image procedure = new Image(20,20);
		procedure.setPixel(10, 10,(byte) 255);
		procedure.savePGM("images.pgm");
		byte intensity=procedure.loadPGM("images.pgm");
		StdOut.println(intensity);
	}
}