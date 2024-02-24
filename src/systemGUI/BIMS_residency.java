package systemGUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class BIMS_residency {

	public BIMS_residency(String name, String date) throws MalformedURLException, IOException {
		
		try {
		String file_name="C:\\Users\\Vinn\\Desktop\\Residency.pdf";
		Document document=new Document();

		PdfWriter.getInstance(document, new FileOutputStream(file_name));
		
		document.open();
		
		Font i=new Font(FontFamily.TIMES_ROMAN,12,Font.BOLD);
		Font f=new Font(FontFamily.TIMES_ROMAN);		
		Paragraph para=new Paragraph("  Republic of the Philippines  ",f);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		
		Paragraph para1=new Paragraph("City of Mandaluyong",f);
		para1.setAlignment(Element.ALIGN_CENTER);
		document.add(para1);

		Paragraph para2=new Paragraph("Barangay Hulo",f);
		para2.setAlignment(Element.ALIGN_CENTER);
		document.add(para2);
		
		Paragraph para3=new Paragraph("Office Of the Barangay Captain",f);
		para3.setAlignment(Element.ALIGN_CENTER);
		document.add(para3);
		
		document.add(new Paragraph ("  "));
		
		
		Font g = new Font(FontFamily.TIMES_ROMAN,30);
		Paragraph para4=new Paragraph("CERTIFICATE OF RESIDENCY",g);
		para4.setAlignment(Element.ALIGN_CENTER);
		document.add(para4);
		
		document.add(new Paragraph ("  "));
		
		Paragraph para5=new Paragraph("To whom it may concern, ",f);
		para5.setAlignment(Element.ALIGN_LEFT);
		document.add(para5);
		
		document.add(new Paragraph ("  "));
		
		Chunk parag6 = new Chunk("This is to certify that Mr./Ms. ", f);
        Chunk parag7 = new Chunk(name, i); 
        Chunk parag8 = new Chunk(" of legal age, married, Filipino citizen, whose specimen signature appears below, is a PERMANENT RESIDENT of this Barangay Hulo, Mandaluyong City.",f);
        Paragraph comb1 = new Paragraph();
        comb1.add(new Chunk(parag6));
        comb1.add(new Chunk(parag7));
        comb1.add(new Chunk(parag8));
        comb1.setAlignment(Element.ALIGN_LEFT);
        document.add(comb1);
		
		document.add(new Paragraph ("  "));
		
		Paragraph para7=new Paragraph("Based on records of this office, she/he has been residing at Barangay Hulo, Mandaluyong City.",f);
		para7.setAlignment(Element.ALIGN_LEFT);
		document.add(para7);
		
		document.add(new Paragraph ("  "));
		
		Paragraph para8=new Paragraph("This CERTIFICATION is being issued upon the request of the above-named person for whatever legal purpose it may serve. ",f);
		para8.setAlignment(Element.ALIGN_LEFT);
		document.add(para8);
		
		document.add(new Paragraph ("  "));
		
		//Paragraph para9=new Paragraph("Issued this __ day of ____ 2022 at Barangay Hulo, Mandaluyong CIty, Philippines.",f);
		//para9.setAlignment(Element.ALIGN_LEFT);
		//document.add(para9);
		
		Chunk parag11 = new Chunk("Issued this ", f);
        Chunk parag12 = new Chunk(date, i); 
        Chunk parag13 = new Chunk(" at Barangay Hulo, Mandaluyong CIty, Philippines.",f);
        Paragraph comb2 = new Paragraph();
        comb2.add(new Chunk(parag11));
        comb2.add(new Chunk(parag12));
        comb2.add(new Chunk(parag13));
        comb2.setAlignment(Element.ALIGN_LEFT);
        document.add(comb2);
		
		document.add(new Paragraph ("  "));
		document.add(new Paragraph ("  "));
		document.add(new Paragraph ("  "));
		
		
		Font h=new Font(FontFamily.TIMES_ROMAN,12,Font.ITALIC);
		Paragraph para10=new Paragraph("Specimen Signature: ",h);
		para10.setAlignment(Element.ALIGN_LEFT);
		document.add(para10);
	
		Paragraph para11=new Paragraph("_________________",f);
		para11.setAlignment(Element.ALIGN_LEFT);
		document.add(para11);
	
		Paragraph para12=new Paragraph("BERNARDO C. MAGLAQUE",i);
		para12.setAlignment(Element.ALIGN_RIGHT);
		document.add(para12);
		
		
		Paragraph para13=new Paragraph("Punong Barangay            ",f);
		para13.setAlignment(Element.ALIGN_RIGHT);
		document.add(para13); 
		
		Paragraph para14=new Paragraph("\nNote: ",f);
		para14.setAlignment(Element.ALIGN_LEFT);
		document.add(para14); 
		
		Paragraph para15=new Paragraph("\n \"Not valid Without Official Seal\" ",f);
		para15.setAlignment(Element.ALIGN_LEFT);
		document.add(para15); 
		
		
		Image logo = Image.getInstance("C:\\Users\\Vinn\\Downloads\\mandaluyong-city.png");
		logo.setAbsolutePosition(400,700);
		logo.scaleAbsolute(100, 100);
		document.add(logo);
		
		Image logo2 = Image.getInstance("C:\\Users\\Vinn\\Downloads\\HULO.png");
		logo2.setAbsolutePosition(100,700);
		logo2.scaleAbsolute(100, 100);
		document.add(logo2);
		
		
		document.close();
		
		System.out.print("finished");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

