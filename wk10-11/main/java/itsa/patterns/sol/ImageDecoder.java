package itsa.patterns.sol;

interface ImageReader {
    DecodedImage getDecodeImage();
}

class DecodedImage {
    private String image;

    public DecodedImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return image + ": is decoded";
    }
}

class GifReader implements ImageReader {
    private DecodedImage decodedImage;

    public GifReader(String image) {
        this.decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

class JpegReader implements ImageReader {
    private DecodedImage decodedImage;

    public JpegReader(String image) {
        decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

interface ImageDecoderFactoryInterface {

	public ImageReader createImageReader(String image); 
}

class ImageDecoderFactory implements ImageDecoderFactoryInterface {

	public ImageReader createImageReader(String image) {
		ImageReader reader = null;

        String format = image.substring(image.indexOf('.') + 1, (image.length()));
        if (format.equals("gif")) {
            reader = new GifReader(image);
        }
        if (format.equals("jpg")) {
            reader = new JpegReader(image);
        }
		return reader;
	}
}


public class ImageDecoder {
    public static void main(String[] args) {
        DecodedImage decodedImage;
        ImageReader reader = null;
		
		ImageDecoderFactoryInterface factory = new ImageDecoderFactory();
		reader = factory.createImageReader(args[0]);
		
        assert reader != null : "Reader is null";
		
        decodedImage = reader.getDecodeImage();
        System.out.println(decodedImage);
    }
}