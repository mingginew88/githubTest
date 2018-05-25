package api_itext;

/**
 * Example written by Bruno Lowagie in answer to the following question:
 * http://stackoverflow.com/questions/40336813/
 */
 

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfImage;
//import com.itextpdf.text.pdf.PdfIndirectObject;
//import com.itextpdf.text.pdf.PdfName;
//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.PdfStamper;
// 
///**
// * @author Bruno Lowagie (iText Software)
// */
//public class AddImageWithId {
//	public static final String SRC = "C:\\Users\\PC17\\Desktop\\hello.pdf";
//    public static final String DEST = "C:\\Users\\PC17\\Desktop\\hello_with_image_id.pdf";
//    public static final String IMG = "C:\\Users\\PC17\\Desktop\\고양이.jpg";
// 
//    public static void main(String[] args) throws IOException, DocumentException {
//        File file = new File(DEST);
//        file.getParentFile().mkdirs();
//        new AddImageWithId().manipulatePdf(SRC, DEST);
//    }
// 
//    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
//        PdfReader reader = new PdfReader(src);
//        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
//        Image image = Image.getInstance(IMG);
//        PdfImage stream = new PdfImage(image, "", null);
//        stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
//        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
//        image.setDirectReference(ref.getIndirectReference());
//        image.setAbsolutePosition(36, 100);
//        PdfContentByte over = stamper.getOverContent(1);
//        over.addImage(image);
//        System.out.println("완료");
//        stamper.close();
//        reader.close();
//    }
// 
//}