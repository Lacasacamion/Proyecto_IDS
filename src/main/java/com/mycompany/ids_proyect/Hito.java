package com.mycompany.ids_proyect;
public class Hito {
    int posicion;
    int pv, bac, ev,ac, pv_a, ev_a, ac_a, cv, sv;
    double cpi, spi, tcpi,eac,etc, vac; 

    public Hito(int posicion, int pv, int bac, int ev, int ac, int pv_a, int ev_a, int ac_a, int cv, int sv, 
                double cpi, double spi, double tcpi, double eac, double etc, double vac) {
        this.posicion = posicion;
        this.pv = pv;
        this.bac = bac;
        this.ev = ev;
        this.ac = ac;
        this.pv_a= pv_a;
        this.ev_a=ev_a;
        this.ac_a= ac_a;
        this.cv=cv;
        this.sv=sv;
        this.cpi=cpi;
        this.spi=spi;
        this.tcpi=tcpi;
        this.eac=eac;
        this.etc=etc;
        this.vac=vac;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getEv_a() {
        return ev_a;
    }

    public void setEv_a(int ev_a) {
        this.ev_a = ev_a;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getPv_a() {
        return pv_a;
    }

    public void setPv_a(int pv_a) {
        this.pv_a = pv_a;
    }

    public int getAc_a() {
        return ac_a;
    }

    public void setAc_a(int ac_a) {
        this.ac_a = ac_a;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getSv() {
        return sv;
    }

    public void setSv(int sv) {
        this.sv = sv;
    }

    public double getCpi() {
        return cpi;
    }

    public void setCpi(double cpi) {
        this.cpi = cpi;
    }

    public double getSpi() {
        return spi;
    }

    public void setSpi(double spi) {
        this.spi = spi;
    }

    public double getTcpi() {
        return tcpi;
    }

    public void setTcpi(double tcpi) {
        this.tcpi = tcpi;
    }

    public double getEac() {
        return eac;
    }

    public void setEac(double eac) {
        this.eac = eac;
    }

    public double getEtc() {
        return etc;
    }

    public void setEtc(double etc) {
        this.etc = etc;
    }

    public double getVac() {
        return vac;
    }

    public void setVac(double vac) {
        this.vac = vac;
    }
    
}
