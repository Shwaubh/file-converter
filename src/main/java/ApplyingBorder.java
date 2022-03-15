import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ApplyingBorder{

	public static void ApplyingBorderMethod(byte[] image) throws Exception{
		
		String home = System.getProperty("user.home") + "//Downloads";
		
		PDDocument pdfdoc = new PDDocument();
		PDImageXObject pdimage = PDImageXObject.createFromByteArray(pdfdoc, image, home);
//		pdimage.setHeight(500);
//		pdimage.setWidth(500);
		PDPage page = new PDPage();
		PDPageContentStream contentstream = new PDPageContentStream(pdfdoc, page);
		
		System.out.println("Length of Image is"+image.length);
		
//		contentstream.drawXObject(pdimage, 10, 700, 100, 100 );
		contentstream.drawImage(pdimage, 10, 10, 480, 480);
		pdfdoc.addPage(page);
		contentstream.close();
		pdfdoc.save(home+"//sampledowloaded.pdf");
		pdfdoc.close();
		
		System.out.println("Sample Document Written Successfully! to "+home);
		
	}
	
}
