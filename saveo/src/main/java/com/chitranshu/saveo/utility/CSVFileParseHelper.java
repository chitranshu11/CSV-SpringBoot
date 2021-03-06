package com.chitranshu.saveo.utility;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.chitranshu.saveo.exception.FileParsingException;

@Component
public class CSVFileParseHelper {

	private static final String NAME = "c_name";
	private static final String BATCH = "c_batch_no";
	private static final String EXPIRY_DATE = "d_expiry_date";
	private static final String QUANTITY = "n_balance_qty";
	private static final String PACKAGING = "c_packaging";
	private static final String UNIQUE_CODE = "c_unique_code";
	private static final String SCHEMES = "c_schemes";
	private static final String MANUFACTURE = "c_manufacturer";
	private static final String HSN_CODE = "hsn_code";
	private static final String MRP = "n_mrp";
	
	//static String[] HEADERs = { "c_name", "c_batch_no", "d_expiry_date", "n_balance_qty" ,"c_packaging","c_unique_code","c_schemes","n_mrp","c_manufacturer","hsn_code"};

	public static List<MedicineHelper> csvToMedicine(InputStream is) throws FileParsingException {
	    try (BufferedReader fileReader = new BufferedReader( new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<MedicineHelper> medicineList = new ArrayList<MedicineHelper>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      
	      for (CSVRecord csvRecord : csvRecords) {
	    	  
	    	  MedicineHelper helper = new MedicineHelper();
	    	 
	    	  
	    	  helper.setcManufactures(csvRecord.get(MANUFACTURE));
	    	  helper.setcName(csvRecord.get(NAME));
	    	  helper.setcPackaging(csvRecord.get(PACKAGING));
	    	  helper.setcUniqueCode(csvRecord.get(UNIQUE_CODE));
	    	  helper.setHsnCode(csvRecord.get(HSN_CODE));
	    	  helper.setnMrp(csvRecord.get(MRP));
	    	  
	    	  helper.setcBatchNo(csvRecord.get(BATCH));
	    	  helper.setcSchemes(csvRecord.get(SCHEMES));
	    	  helper.setnBalanceQty(Long.parseLong(csvRecord.get(QUANTITY)));
	    	  helper.setdExpiryDate(csvRecord.get(EXPIRY_DATE));
	    
	    	  
	    	  medicineList.add(helper);
	      }	  

	      return medicineList;
	    } catch (Exception e) {
		      e.printStackTrace();
		      throw new FileParsingException("Failed to parse CSV file");
	    }
	  
	}
}
	
