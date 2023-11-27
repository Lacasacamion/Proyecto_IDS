package com.mycompany.ids_proyect;

import java.util.ArrayList;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;

public class Gestionador {
    int i=0, k=0;//Contadores para los metodos
    double ac_a=0;
    double pv_a=0;
    double ev_a=0;
    private ArrayList<Hito> hitos = new ArrayList<>();
    
    private String interpretarCV(double cv) {
        if(cv>0){
            return "Eficiente";
        }
        else{
            if(cv < 0){
                return "Ineficiente";
            }
            else{
                return "Eficaz";
            }
        }
    }
    
    private String interpretarSV(double sv) {
        if(sv>0){
            return "Acelerado";
        }
        else{
            if(sv < 0){
                return "Lento";
            }
            else{
                return "Constante";
            }
        }
    }
    
    private String interpretarCPI(double cpi) {
        if(cpi>1){
            return "Se está gastando menos de lo que se planeó";
        }
        else{
            if(cpi<1){
                return "Se está gastando más de lo que se planeó";
            }
            else{
                return "Se está gastando exactamente lo que se planéo";
            }
        }
    }
    
    private String interpretarSPI(double spi) {
        return ("Se esta avanzando a un "+spi+"% de lo esperado");
    }
    
    private String interpretarTCPI(double tcpi) {
        if(tcpi>1){
            return "Se debe mejorar la eficiencia para no exceder el presupuesto inicial";
        }
        else{
            if(tcpi < 1){
                return "Se puede gastar más sin generar un exceso en el costo total del proyecto";
            }
            else{
                return "Se debe gastar exactamente lo planificado para el proyecto";
            }
        }
    }
    
    private String interpretarETC(double etc) {
        return ("El proyecto costará "+etc+" de más");
    }
    
    private String interpretarEAC(double eac) {
        return ("El proyecto costara "+ eac+" al finalizar");
    }
    
    private String interpretarVAC(double vac) {
        if(vac>0){
            return "Se espera que el proyecto cueste menos de lo presupuestado";
        }
        else{
            if(vac < 0){
                return "Se espera que el proyecto cueste más de lo que se presupuesto";
            }
            else{
                return "Se espera  que el proyecto cueste lo planificado para el proyecto";
            }
        }
    }
    public Gestionador(){
        
    }
    public Gestionador(ArrayList<Hito> hitos){
        this.hitos=hitos;
    }
    
    public void guardarNoProrrateadoPV_BAC(JTable table,double pv, int numero_hitos){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        if(i < numero_hitos){
            int p=i+1;
            pv_a = pv_a + pv;
            //Crear un nuevo objeto Hito y asignar valores
            //Se asigna 0 a los atributos que no se modifican en este metodo.
            Hito hito= new Hito(p, pv, 0,0,0,pv_a,0,0,0,0,0,0,0,0,0,0);
            hitos.add(hito);//Agregar el hito a la lista
            
            Object[] rowData = {p, pv, null, null, null,pv_a, null};
            tableModel.addRow(rowData);
                
            i++;
            if( i==numero_hitos){
                for(int h=0 ;h <numero_hitos; h++){
                    Hito hito_actual= hitos.get(h);//Obtener el hito en el orden que se crearon
                    // Actualiza el hito con valores de Bac
                    hito_actual.setBac(pv_a);
                    tableModel.setValueAt(pv_a, h, 2);
                }
            }
        } else{
            JOptionPane.showMessageDialog(null, "No se admiten mas valores");
        }
    }
    
    public void guardarNoProrrateadoEV_AC(JTable table, int numero_hitos,int h_evaluar, double ev, double ac){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        double cv,sv,bac, pv_a_hito;
        double cpi, spi, tcpi;
        if(k< h_evaluar){
            // Actualiza los acumulados
            ac_a= ac_a+ac;
            ev_a= ev_a+ev;
            cv= ev_a-ac_a;
            cpi= ev_a/ac_a;
            Hito hito= hitos.get(k);//Obtener el hito en el orden que se crearon
            bac= hito.getBac();
            pv_a_hito= hito.getPv_a();
            sv= ev_a - pv_a_hito;
            spi= ev_a/ pv_a_hito;
            tcpi=(bac-ev_a)/(bac-ac_a);
            // Actualiza el hito con valores de ev, ac y ac_a
            hito.setEv(ev);
            hito.setAc(ac);
            hito.setAc_a(ac_a);
            hito.setEv_a(ev_a);
            hito.setCv(cv);
            hito.setSv(sv);
            hito.setCpi(cpi);
            hito.setSpi(spi);
            hito.setTcpi(tcpi);
            //Agregar los valores de ev,ac y aac_a
            tableModel.setValueAt(ev, k, 3);
            tableModel.setValueAt(ac, k, 4);
            tableModel.setValueAt(ac_a, k, 6);
            
            k++;
            
            if(k==h_evaluar){
                for(int j=k;j<numero_hitos;j++){
                    Hito hito_actual= hitos.get(j);//Obtener el hito en el orden que se crearon
                    pv_a_hito=hito_actual.getPv_a();
                    sv= ev_a - pv_a_hito;
                    spi= ev_a/ pv_a_hito;
                    // Actualiza el hito con valores de Bac
                    hito_actual.setAc_a(ac_a);
                    hito_actual.setEv_a(ev_a);
                    hito_actual.setCv(cv);
                    hito_actual.setSv(sv);
                    hito_actual.setCpi(cpi);
                    hito_actual.setSpi(spi);
                    hito_actual.setTcpi(tcpi);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No se admiten mas valores");
        }
    }
    
    public void guardarProrrateadoPV_BAC(JTable table,double pv_total, int numero_hitos, double bac) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        // Limpiar la tabla si ya contiene datos
        tableModel.setRowCount(0);
        
        double pv_por_hito = pv_total / numero_hitos;
        pv_a = pv_por_hito;

        for (int j = 1; j <= numero_hitos; j++) {
            //Crear un nuevo objeto Hito y asignar valores 
            Hito hito= new Hito(j, pv_por_hito, bac, 0,0,pv_a,0,0,0,0,0,0,0,0,0,0);
            hitos.add(hito);//Agregar el hito a la lista
            pv_a = pv_por_hito*j;
            
            Object[] rowData = {j, pv_por_hito, bac, null, null, pv_a, null};
            tableModel.addRow(rowData);
        }
    }
    
    public void guardarProrrateadoEV_AC(JTable table, int h_evaluar, int numero_hitos, double ev, double ac ) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        double cv=0,sv=0, pv_a_hito=0, bac=0;
        double cpi=0, spi=0, tcpi=0;
        if(i< h_evaluar){
            // Actualiza los acumulados
            ac_a= ac_a+ac;
            ev_a= ev_a+ev;
            cv= ev_a-ac_a;    
            cpi= ev_a/ac_a;  
            Hito hito= hitos.get(i);//Obtener el hito en el orden que se crearon
            bac= hito.getBac();
            pv_a_hito= hito.getPv_a();
            sv= ev_a - pv_a_hito;
            spi= ev_a/ pv_a_hito;
            tcpi=(bac-ev_a)/(bac-ac_a);
            // Actualiza el hito con valores de ev, ac y ac_a
            hito.setEv(ev);
            hito.setAc(ac);
            hito.setAc_a(ac_a);
            hito.setEv_a(ev_a);
            hito.setCv(cv);
            hito.setSv(sv);
            hito.setCpi(cpi);
            hito.setSpi(spi);
            hito.setTcpi(tcpi);
            //Agregar los valores de ev,ac y aac_a
            tableModel.setValueAt(ev, i, 3);
            tableModel.setValueAt(ac, i, 4);
            tableModel.setValueAt(ac_a, i, 6);
            
            i++;
            if(i==h_evaluar){
                for(int j=i;j<numero_hitos;j++){
                    Hito hito_actual= hitos.get(j);//Obtener el hito en el orden que se crearon
                    pv_a_hito=hito_actual.getPv_a();
                    sv= ev_a - pv_a_hito;
                    spi= ev_a/ pv_a_hito;
                    // Actualiza los valores para el resto de hitos 
                    hito_actual.setAc_a(ac_a);
                    hito_actual.setEv_a(ev_a);
                    hito_actual.setCv(cv);
                    hito_actual.setSv(sv);
                    hito_actual.setCpi(cpi);
                    hito_actual.setSpi(spi);
                    hito_actual.setTcpi(tcpi);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No se admiten mas valores");
        }
    }
    
    public boolean validarHitosEvaluar(String h_evaluar, int numero_hitos){
        int numero= Integer.parseInt(h_evaluar);
        if(numero>0 && numero<=numero_hitos){
           return true;
        }else{
            return false;//no se valida la entrada
        }
    }

    public void variacionAtipica(int h_evaluar, int numero_hitos){
        double etc, eac, vac;
        for(int g=0; g<h_evaluar;g++){
            Hito hito= hitos.get(g);//Obtener el hito del arrayList
            //obtener los valores necesarios del hito
            double bac= hito.getBac();
            double ev_ac= hito.getEv_a();
            double ac_ac= hito.getAc_a();
            etc= bac-ev_ac;
            eac= ac_ac+etc;
            vac= bac-eac;
            //agregando los valores al hito respectivo
            hito.setEtc(etc);
            hito.setEac(eac);
            hito.setVac(vac);
            if(g==h_evaluar-1){
                for(int j=g;j<numero_hitos;j++){
                    Hito hito_actual= hitos.get(j);//Obtener el hito en el orden que se crearon 
                    hito_actual.setEtc(etc);
                    hito_actual.setEac(eac);
                    hito_actual.setVac(vac);
                }
            }
        }
    }
    
    public void variacionTipica(int h_evaluar,int numero_hitos){
        double etc, eac, vac;
        for(int g=0; g<h_evaluar;g++){
            Hito hito= hitos.get(g);//Obtener el hito del arrayList
            double bac= hito.getBac();
            double ev_ac= hito.getEv_a();
            double cpi= hito.getCpi();
            etc= (bac-ev_ac)/cpi;
            eac=  bac/cpi;
            vac=  bac-eac;
            //agregando los valores al hito respectivo
            hito.setEtc(etc);
            hito.setEac(eac);
            hito.setVac(vac);
            if(g==h_evaluar-1){
                for(int j=g;j<numero_hitos;j++){
                    Hito hito_actual= hitos.get(j);//Obtener el hito en el orden que se crearon 
                    hito_actual.setEtc(etc);
                    hito_actual.setEac(eac);
                    hito_actual.setVac(vac);
                }
            }
        }
    }
    
    public void agregarProyecciones(JTable table,int h_evaluar){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        double cv ,sv ,cpi ,spi ,tcpi ,eac ,etc ,vac;
        //Obtener las proyecciones del hito a evaluar
        int indice = h_evaluar-1;
        Hito hito= hitos.get(indice);
        cv = hito.getCv();
        sv = hito.getSv();
        cpi = hito.getCpi();
        spi = hito.getSpi();
        tcpi= hito.getTcpi();
        eac = hito.getEac();
        etc = hito.getEtc();
        vac = hito.getVac();
        // Agrega una fila a la tabla con los valores del último hito
        Object[] rowData = {"CV", "EV - AC", cv, interpretarCV(cv)};
        tableModel.addRow(rowData);

        rowData = new Object[]{"SV", "EV - PV", sv, interpretarSV(sv)};
        tableModel.addRow(rowData);

        rowData = new Object[]{"CPI", "EV/AC", cpi, interpretarCPI(cpi)};
        tableModel.addRow(rowData);

        rowData = new Object[]{"SPI", "EV/PV", spi, interpretarSPI(spi)};
        tableModel.addRow(rowData);

        rowData = new Object[]{"TCPI", "(BAC - EV)/(BAC - AC)", tcpi, interpretarTCPI(tcpi)};
        tableModel.addRow(rowData);

        rowData = new Object[]{"EAC", "AC + ETC o (BAC/CPI)", eac, interpretarEAC(eac)};
        tableModel.addRow(rowData);

        rowData = new Object[]{"ETC", "BAC - EV o (BAC - EV)/CPI", etc, interpretarETC(etc)};
        tableModel.addRow(rowData);

        rowData = new Object[]{"VAC", "BAC - EAC", vac, interpretarVAC(vac)};
        tableModel.addRow(rowData);

    }
    
    public ArrayList<Hito> getHitos() {
        return hitos;
    }
}
