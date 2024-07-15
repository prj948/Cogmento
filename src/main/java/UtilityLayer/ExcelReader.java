package UtilityLayer;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReader extends BaseClass {
	private static XSSFWorkbook workbook;

	public ExcelReader(String excelpath) throws Exception {
		workbook = new XSSFWorkbook(new FileInputStream(new File(excelpath)));
	}

	public static int getTotalRowCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getLastRowNum() + 1;
	}

	public static int getTotalColoumnCount(int shetindex) {
		return workbook.getSheetAt(shetindex).getRow(0).getLastCellNum();
	}

	public Object getSheetTestData(int sheetindex, int rows, int cell) {
		XSSFCell cells = workbook.getSheetAt(sheetindex).getRow(rows).getCell(cell);
		if (cells.getCellType() == XSSFCell.CELL_TYPE_BLANK) {

			return "";
		}

		else if (cells.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
			return cells.getBooleanCellValue();

		} else if (cells.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
			return cells.getCellFormula();

		}

		else if (cells.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			return cells.getRawValue();
		} else if (cells.getCellType() == XSSFCell.CELL_TYPE_STRING) {
			return cells.getStringCellValue();

		} else if (cells.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
			return cells.getErrorCellValue();
		} else {
			return null;
		}
	}

	public Object[][] getAllSheetTestData(int sheetindex) {
		int rows = getTotalRowCount(sheetindex);
		int cells = getTotalColoumnCount(sheetindex);
		Object[][] data = new Object[rows][cells];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				data[i][j] = getSheetTestData(sheetindex, i, j);
			}

		}
		return data;
	}
}