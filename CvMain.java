
public class CvMain {


	static void imageProcessing1() {

		String filename1 = "kanransya.jpg";

		String filename2 = "copy.jpg";

		MyImage image1, image2;
	
		image1 = JpegFileReader.read(filename1);

		{
			//image2 = Negative.execute(image1);
			//image2 = Binalization.execute(image1);
			//image2 = GammaCorrection3.execute(image1);
			//image2 = SpaceFiltering.execute(image1);	
			//image2 = Scale.execute(image1);
			//image2 = Rotation.execute(image1);
			//image2 = Rotation2.execute(image1);
			//image2 = Rotation3.execute(image1);
			//image2 = AlphaBlending.execute(image1);
			image2 = BGColor.execute(image1);
			//image2 = BGColor2.execute(image1);	
			//image2 = Frame.execute(image1);
			//image2 = StainedGlass.execute(image1);
		}

		JpegFileWriter.write(filename2, image2);

	}


	static void imageProcessing2() {

		String filename1 = "hawaii2.jpg";
		String filename2 = "sunset.jpg";
		String filename3 = "copy.jpg";
		String filename4 = "hawaii3.png";
		String filename5 = "hawaii4.png";
		String filename6 = "hawaii5.png";
		//String filename7 = "";

		MyImage image1, image2, image3, image0,image4,image5,image6,image7,image8,image9,image10;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image4 = JpegFileReader.read(filename4);
		image5 = JpegFileReader.read(filename5);
		image6 = JpegFileReader.read(filename6);
		//image1 = Binalization.execute(image1);
		image4 = Binalization.execute(image4);
		image5 = Binalization.execute(image5);
		image6 = Binalization.execute(image6);
		image1 = Scale.execute(image1);
		image4 = Scale.execute(image4);
		image5 = Scale.execute(image5);
		image6 = Scale.execute(image6);
		image7 = Rotation2.execute(image1);
		image8 = Rotation2.execute(image4);
		image9 = Rotation2.execute(image5);
		image10 = Rotation2.execute(image6);

		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 6);
		image0 = Chromakey.execute(image1, kmeans, 3);
		
		//image3 = VirtualStudio.execute(image1, image2, image0); 
		//image3 = AlphaBlending.execute(image1, image2, image0);
		image3 = AlphaBlending2.execute(image1, image2, image0);

		// kmeans.clustering(image4, 6);
		// image0 = Chromakey.execute(image4, kmeans, 3);
		// image3 = AlphaBlending3.execute(image4, image3, image0);

		// kmeans.clustering(image5, 6);
		// image0 = Chromakey.execute(image5, kmeans, 3);
		// image3 = AlphaBlending4.execute(image5, image3, image0);

		// kmeans.clustering(image6, 6);
		// image0 = Chromakey.execute(image6, kmeans, 3);
		// image3 = AlphaBlending5.execute(image6, image3, image0);
		// //image3 = Tiling.execute(image1, image2);

		// kmeans.clustering(image7, 6);
		// image0 = Chromakey.execute(image7, kmeans, 3);
		// image3 = AlphaBlending6.execute(image7, image3, image0);

		// kmeans.clustering(image8, 6);
		// image0 = Chromakey.execute(image8, kmeans, 3);
		// image3 = AlphaBlending7.execute(image8, image3, image0);

		// kmeans.clustering(image9, 6);
		// image0 = Chromakey.execute(image9, kmeans, 3);
		// image3 = AlphaBlending8.execute(image9, image3, image0);

		// kmeans.clustering(image10, 6);
		// image0 = Chromakey.execute(image10, kmeans, 3);
		// image3 = AlphaBlending9.execute(image10, image3, image0);
		//JpegFileWriter.write(filename3, image3);

	}


	public static void main(String args[]) {

		imageProcessing1();
		//imageProcessing2();

	}
}
