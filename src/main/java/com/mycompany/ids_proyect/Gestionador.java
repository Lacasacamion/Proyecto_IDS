package com.mycompany.ids_proyect;

import java.util.ArrayList;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;

public class Gestionador {
    int i=0;//La variable contador
    int ac_a;
    int pv_a;
    int ev_a;
    private ArrayList<Hito> hitos = new ArrayList<>();
    
    public void GuardarNoProrrateadoPV_BAC(JTable table,int pv, int numero_hitos){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        // Limpiar la tabla si ya contiene datos
        //tableModel.setRowCount(0
        
        if(i < numero_hitos){
            int p=i+1;
            pv_a = pv_a + pv;
            //Crear un nuevo objeto Hito y asignar valores
            Hito hito= new Hito(p, pv, 0,0,0,pv_a,0,0,0,0,0,0,0,0,0,0);
            hitos.add(hito);//Agregar el hito a la lista
            
            Object[] rowData = {p, pv, null, null, null,pv_a, null};
            tableModel.addRow(rowData);
                
            i++;
            if( i==numero_hitos){
                for(int h=0 ;h <numero_hitos; h++){
                    Hito hito_actual= hitos.get(h);//Obtener el hito en el orden que se crearon
                    // Actualiza el hito con valores de Bac
                    hito.setBac(pv_a);
                    tableModel.setValueAt(pv_a, h, 2);
                }
            }
        } else{
            JOptionPane.showMessageDialog(null, "No se admiten mas valores");
        }
    }
    
    public void GuardarNoProrrateadoEV_AC(JTable table, int numero_hitos, int ev, int ac){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        if(i< numero_hitos){
            // Actualiza los acumulados
            ac_a= ac_a+ac;
            ev_a= ev_a+ev;
            Hito hito= hitos.get(i);//Obtener el hito en el orden que se crearon
            // Actualiza el hito con valores de ev, ac y ac_a
            hito.setEv(ev);
            hito.setAc(ac);
            hito.setAc_a(ac_a);
            hito.setEv_a(ev_a);
            //Agregar los valores de ev,ac y aac_a
            tableModel.setValueAt(ev, i, 3);
            tableModel.setValueAt(ac, i, 4);
            tableModel.setValueAt(ac_a, i, 6);
            
            i++;
        }
        else{
            JOptionPane.showMessageDialog(null, "No se admiten mas valores");
        }
    }
    
    public void GuardarProrrateadoPV_BAC(JTable table,int pv_total, int numero_hitos, int bac) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        // Limpiar la tabla si ya contiene datos
        tableModel.setRowCount(0);
        
        int pv_por_hito = pv_total / numero_hitos;
        pv_a = pv_por_hito;

        for (int j = 1; j <= numero_hitos; j++) {
            //Crear un nuevo objeto Hito y asignar valores con 1 para evitar divisiones entre 0
            Hito hito= new Hito(j, pv_por_hito, bac, 1,1,pv_a,1,1,1,1,1,1,1,1,1,1);
            hitos.add(hito);//Agregar el hito a la lista
            pv_a = pv_por_hito*j;
            
            Object[] rowData = {j, pv_por_hito, bac, null, null, pv_a, null};
            tableModel.addRow(rowData);
        }
    }
    
    public void GuardarProrrateadoEV_AC(JTable table, int h_evaluar, int ev, int ac ) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        if(i< h_evaluar){
            // Actualiza los acumulados
            ac_a= ac_a+ac;
            ev_a= ev_a+ev;
            Hito hito= hitos.get(i);//Obtener el hito en el orden que se crearon
            // Actualiza el hito con valores de ev, ac y ac_a
            hito.setEv(ev);
            hito.setAc(ac);
            hito.setAc_a(ac_a);
            hito.setEv_a(ev_a);
            //Agregar los valores de ev,ac y aac_a
            tableModel.setValueAt(ev, i, 3);
            tableModel.setValueAt(ac, i, 4);
            tableModel.setValueAt(ac_a, i, 6);
            
            i++;
        }
        else{
            JOptionPane.showMessageDialog(null, "No se admiten mas valores");
        }
    }
    
    public boolean ValidarHitosEvaluar(String h_evaluar, int numero_hitos){
        int numero= Integer.parseInt(h_evaluar);
        if(numero>0 && numero<=numero_hitos){
           return true;
        }else{
            return false;//no se valida la entrada
        }
    }

    //pendiente si se usara este metodo
    public DefaultTableModel crearModeloTabla() {
        Vector<String> columnas = new Vector<>();
        columnas.addElement("Posición");
        columnas.addElement("PV");
        columnas.addElement("BAC");
        columnas.addElement("EV");
        columnas.addElement("AC");
        columnas.addElement("PV acumulado");
        columnas.addElement("AC acumulado");

        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (Hito hito : hitos) {
            Vector<Object> rowData = new Vector<>();
            rowData.addElement(hito.getPosicion());
            rowData.addElement(hito.getPv());
            rowData.addElement(hito.getBac());
            rowData.addElement(hito.getEv());
            rowData.addElement(hito.getAc());
            rowData.addElement(hito.getPv_a());
            rowData.addElement(hito.getAc_a());
            // Agrega más datos según tus atributos de Hito
            modeloTabla.addRow(rowData);
        }

        return modeloTabla;
    }

    public ArrayList<Hito> getHitos() {
        return hitos;
    }
}
