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
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

public class BIMS_BusinessClearance {

	public BIMS_BusinessClearance(String busType, String busName, String busOwner, String busAddress, String date) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		try {
		String file_name="C:\\Users\\Vinn\\Desktop\\BusinessClearance.pdf";
		Document document=new Document();

		PdfWriter.getInstance(document, new FileOutputStream(file_name));
		
		document.open();
		
		Font h=new Font(FontFamily.TIMES_ROMAN,12,Font.BOLD);
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
		Paragraph para4=new Paragraph("BARANGAY BUSINESS CLEARANCE",g);
		para4.setAlignment(Element.ALIGN_CENTER);
		document.add(para4);
		
		
		
		document.add(new Paragraph ("  "));
		
		Paragraph para6=new Paragraph("Pursuant to the provision of the Barangay Tax Revenue of Barangay Hulo, Mandaluyong City, the Business Establishment which name, address, and owner's name appears below is now duly registered in this Barangay as provided for under Seec. 1520 of Republic Act  No. 7160, otherwise known as Local Government Code of 1991, to wit: ",f);
		para6.setAlignment(Element.ALIGN_LEFT);
		document.add(para6);
		
		document.add(new Paragraph ("  "));
	
		Chunk parag6 = new Chunk("Type of Business : ", f);
        Chunk parag7 = new Chunk(busType, h); 
        Paragraph comb1 = new Paragraph();
        comb1.add(new Chunk(parag6));
        comb1.add(new Chunk(parag7));
        comb1.setAlignment(Element.ALIGN_LEFT);
        document.add(comb1);
        
        Chunk parag8 = new Chunk("Name of Business : ", f);
        Chunk parag9 = new Chunk(busName, h); 
        Paragraph comb2 = new Paragraph();
        comb2.add(new Chunk(parag8));
        comb2.add(new Chunk(parag9));
        comb2.setAlignment(Element.ALIGN_LEFT);
        document.add(comb2);
        
        Chunk parag10 = new Chunk("Owner's Name : ", f);
        Chunk parag11 = new Chunk(busOwner, h); 
        Paragraph comb3 = new Paragraph();
        comb3.add(new Chunk(parag10));
        comb3.add(new Chunk(parag11));
        comb3.setAlignment(Element.ALIGN_LEFT);
        document.add(comb3);
		
        Chunk parag12 = new Chunk("Address of Business : ", f);
        Chunk parag13 = new Chunk(busAddress, h); 
        Paragraph comb4 = new Paragraph();
        comb4.add(new Chunk(parag12));
        comb4.add(new Chunk(parag13));
        comb4.setAlignment(Element.ALIGN_LEFT);
        document.add(comb4);
		
		document.add(new Paragraph ("  "));
		
		Chunk parag14 = new Chunk("Given this : ", f);
        Chunk parag15 = new Chunk(date, h); 
        Paragraph comb5 = new Paragraph();
        comb5.add(new Chunk(parag14));
        comb5.add(new Chunk(parag15));
        comb5.setAlignment(Element.ALIGN_LEFT);
        document.add(comb5);
		
		
		document.add(new Paragraph ("  "));
		document.add(new Paragraph ("  "));
		document.add(new Paragraph ("  "));
		
		
		Paragraph para10=new Paragraph("BERNARDINO C. MAGLAQUE ",h);
		para10.setAlignment(Element.ALIGN_LEFT);
		document.add(para10);
	
		Paragraph para11=new Paragraph("Punong Barangay ",f);
		para11.setAlignment(Element.ALIGN_LEFT);
		document.add(para11);
		
		
		Paragraph para12=new Paragraph("Applicant Signature",f);
		para12.setAlignment(Element.ALIGN_RIGHT);
		document.add(para12);
		
		Paragraph para13=new Paragraph("NOT VALID WITHOUT OFFICIAL SEAL",f);
		para13.setAlignment(Element.ALIGN_LEFT);
		document.add(para13);
		
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


