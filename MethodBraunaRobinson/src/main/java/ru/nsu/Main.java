package ru.nsu;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;


public class Main {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> listOfX=new ArrayList<Integer>();
        ArrayList<Integer> listOfY=new ArrayList<Integer>();
        HashMap<Integer, Double> map1 = new HashMap<>();
        HashMap<Integer, Double> map2 = new HashMap<>();
        FileRedactor database = new FileRedactor("Database.csv");
        int[][] matrix = database.fileReaderMatrix();
        int[] vector1=new int[matrix.length];
        int[] vector2=new int[matrix[0].length];
        for(int i=0;i<vector1.length;i++){
            map1.put(i,0.0);
        }
        for(int i=0;i<vector2.length;i++){
            map2.put(i,0.0);
        }
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Result");
//        List<ElementOfMethod> list = ElementPackageExcel.listEmployees();
//        ElementOfMethod list = ElementPackageExcel.listEmployees(1,matrix,vector1,vector2);
        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("k");
        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("i");
        cell.setCellStyle(style);
        // Salary
        for(int j =0;j<vector2.length;j++){
            cell = row.createCell(j+2, CellType.STRING);
            cell.setCellValue(j);
            cell.setCellStyle(style);
        }
        cell = row.createCell(vector2.length+2, CellType.STRING);
        cell.setCellValue("alpha");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(vector2.length+3, CellType.STRING);
        cell.setCellValue("j");
        cell.setCellStyle(style);
        // Bonus
        for(int j =0;j<vector1.length;j++){
            cell = row.createCell(j+vector2.length+4, CellType.STRING);
            cell.setCellValue(j);
            cell.setCellStyle(style);
        }
        cell = row.createCell(vector2.length+vector1.length+4, CellType.STRING);
        cell.setCellValue("beta");
        cell.setCellStyle(style);

        cell = row.createCell(vector2.length+vector1.length+5, CellType.STRING);
        cell.setCellValue("v");
        cell.setCellStyle(style);

        cell = row.createCell(vector2.length+vector1.length+6, CellType.STRING);
        cell.setCellValue("delta");
        cell.setCellStyle(style);

        cell = row.createCell(vector2.length+vector1.length+7, CellType.STRING);
        cell.setCellValue("epsilon");
        cell.setCellStyle(style);

        // Data
        for (int i=1;i<Integer.parseInt(args[0])+1;i++) {
            rownum++;
            row = sheet.createRow(rownum);
            MethodBraunaRobinson method = new MethodBraunaRobinson(matrix,vector1,vector2);
            if(i==1){
                method.setVector2(method.UI(0));
                int numberJ=method.j();
                method.setVector1(method.UJ(numberJ));
                ElementOfMethod el2 = new ElementOfMethod(i,0,method.getVector2(),
                        method.alpha(i),method.j(),method.getVector1(),method.beta(i),method.v(i),0,0);
            // EmpNo (A)
            cell = row.createCell(0, CellType.NUMERIC);
             cell.setCellValue(el2.getkOrder());
            // EmpName (B)
            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(el2.getiOrder());
            if(map1.containsKey(el2.getiOrder())){
                map1.put(el2.getiOrder(),map1.get(el2.getiOrder())+1);
            }else{
                map1.put(el2.getiOrder(),1.0);
            }
            listOfX.add(el2.getiOrder());
            // Salary (C)
            for(int j =0;j<el2.getUAJ().length;j++){
                cell = row.createCell(j+2, CellType.NUMERIC);
                cell.setCellValue(el2.getUAJ()[j]);
            }
            cell = row.createCell(el2.getUAJ().length+2, CellType.NUMERIC);
            cell.setCellValue(el2.getAlpha());
            // Grade
            cell = row.createCell(el2.getUAJ().length+3, CellType.NUMERIC);
            cell.setCellValue(el2.getjOrder());
                if(map2.containsKey(el2.getjOrder())){
                    map2.put(el2.getjOrder(),map2.get(el2.getjOrder())+1);
                }else{
                    map2.put(el2.getjOrder(),1.0);
                }
            listOfY.add(el2.getjOrder());
            // Bonus
            for(int j =0;j<el2.getUAI().length;j++){
                cell = row.createCell(j+el2.getUAJ().length+4, CellType.NUMERIC);
                cell.setCellValue(el2.getUAI()[j]);
            }
            cell = row.createCell(el2.getUAI().length+el2.getUAJ().length+4, CellType.NUMERIC);
            cell.setCellValue(el2.getBeta());

            cell = row.createCell(el2.getUAI().length+el2.getUAJ().length+5, CellType.NUMERIC);
            cell.setCellValue(el2.getValue());

            cell = row.createCell(el2.getUAI().length+el2.getUAJ().length+6, CellType.NUMERIC);
            cell.setCellValue(el2.getDelta());

            cell = row.createCell(el2.getUAI().length+el2.getUAJ().length+7, CellType.NUMERIC);
            cell.setCellValue(el2.getEpsilon());

            }else{
                int numberI=method.i();
                method.setVector2(method.UI(numberI));
                int numberJ=method.j();
                method.setVector1(method.UJ(numberJ));
                ElementOfMethod el1 = new ElementOfMethod(i,method.i(),method.getVector2(),
                        method.alpha(i),method.j(),method.getVector1(),method.beta(i),method.v(i)
                        ,method.delta(i),method.epsilon(i));
                // EmpNo (A)
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(el1.getkOrder());
                // EmpName (B)
                cell = row.createCell(1, CellType.NUMERIC);
                cell.setCellValue(el1.getiOrder());
                if(map1.containsKey(el1.getiOrder())){
                    map1.put(el1.getiOrder(),map1.get(el1.getiOrder())+1);
                }else{
                    map1.put(el1.getiOrder(),1.0);
                }
                listOfX.add(el1.getiOrder());
                // Salary (C)
                for(int j =0;j<el1.getUAJ().length;j++){
                    cell = row.createCell(j+2, CellType.NUMERIC);
                    cell.setCellValue(el1.getUAJ()[j]);
                }
                cell = row.createCell(el1.getUAJ().length+2, CellType.NUMERIC);
                cell.setCellValue(el1.getAlpha());
                // Grade
                cell = row.createCell(el1.getUAJ().length+3, CellType.NUMERIC);
                cell.setCellValue(el1.getjOrder());
                if(map2.containsKey(el1.getjOrder())){
                    map2.put(el1.getjOrder(),map2.get(el1.getjOrder())+1);
                }else{
                    map2.put(el1.getjOrder(),1.0);
                }
                listOfY.add(el1.getjOrder());
                // Bonus
                for(int j =0;j<el1.getUAI().length;j++){
                    cell = row.createCell(j+el1.getUAJ().length+4, CellType.NUMERIC);
                    cell.setCellValue(el1.getUAI()[j]);
                }
                cell = row.createCell(el1.getUAI().length+el1.getUAJ().length+4, CellType.NUMERIC);
                cell.setCellValue(el1.getBeta());

                cell = row.createCell(el1.getUAI().length+el1.getUAJ().length+5, CellType.NUMERIC);
                cell.setCellValue(el1.getValue());

                cell = row.createCell(el1.getUAI().length+el1.getUAJ().length+6, CellType.NUMERIC);
                cell.setCellValue(el1.getDelta());

                cell = row.createCell(el1.getUAI().length+el1.getUAJ().length+7, CellType.NUMERIC);
                cell.setCellValue(el1.getEpsilon());

            }
        }
        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("x");
        for (int i=0;i<map1.size();i++){
            cell = row.createCell(i+1, CellType.NUMERIC);
            cell.setCellValue(map1.get(i)/(Integer.parseInt(args[0])));
        }
        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("y");
        for (int i=0;i<map2.size();i++){
            cell = row.createCell(i+1, CellType.NUMERIC);
            cell.setCellValue(map2.get(i)/(Integer.parseInt(args[0])));
        }
//"C:/Users/Mark/Maven project/MethodBraunaRobinson/result.xls"
        File file = new File(args[1]);
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());

    }
}
