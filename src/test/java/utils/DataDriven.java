/*
package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    //Definición del método que obtiene los datos de prueba en base al nombre del caso de prueba
    @NotNull
    public static ArrayList<String> getData(String nombreCasoPrueba) {

        //Instanciar un array list
        ArrayList<String> a = new ArrayList<>();

        //Referenciar ruta del excel
        FileInputStream file = null;


        //Se intenta instanciar el objeto de tipo file
        try {
            file = new FileInputStream(PropertiesDriven.getProperty("rutaExcel"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Se intenta Crear objeto libro excell
        XSSFWorkbook excel = null;
        try {
            excel = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Contar cuantas hojas tiene el excel
        int sheets = excel.getNumberOfSheets();


        //bucle para iterar en las hojas
        for(int i=0; i < sheets;i++){
            //verificaremos la hoja a trabajar en base al nombre de esta.
            if(excel.getSheetName(i).equalsIgnoreCase(PropertiesDriven.getProperty("hojaCPs"))){
                //encontre la Hoja

                //Instanciar la hoja del excel encontrada
                XSSFSheet hojaExcel = excel.getSheetAt(i);

                //Iterador de las filas del excel
                Iterator<Row> filas = hojaExcel.iterator();

                //Se instancia un objeto de tipo fila solo contiene la primera fila
                Row fila = filas.next();

                //Iterar con las celdas de la primera fila del excel
                Iterator<Cell> celdas = fila.cellIterator();

                int k = 0;
                int columna = 0;

                while(celdas.hasNext()){

                    //se intancia una celda
                    Cell celdaSeleccionada = celdas.next();
                    //System.out.println(celda.getStringCellValue());
                    if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase(PropertiesDriven.getProperty("tituloCPs"))){
                        columna = k;
                    }
                    k++;
                }


                while(filas.hasNext()){

                    Row r = filas.next();

                    if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(nombreCasoPrueba)){

                        Iterator<Cell> cv = r.cellIterator();

                        while(cv.hasNext()){

                            Cell celda = cv.next();

                            if(celda.getCellType() == CellType.STRING){
                                //System.out.println(celda.getStringCellValue());
                                a.add(celda.getStringCellValue());
                            }else if(celda.getCellType() == CellType.NUMERIC){
                                //System.out.println(celda.getNumericCellValue());
                                a.add(NumberToTextConverter.toText(celda.getNumericCellValue()));
                            }

                        }

                    }
                }

            }
        }
        return a;
    }
}
*/