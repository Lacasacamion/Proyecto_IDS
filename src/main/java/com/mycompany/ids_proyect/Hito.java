package com.mycompany.ids_proyect;
public class Hito {
    int posicion;
    double pv, bac, ev,ac, pv_a, ev_a, ac_a, cv, sv;
    double cpi, spi, tcpi,eac,etc, vac; 

    public Hito(int posicion, double pv, double bac, double ev, double ac, double pv_a, double ev_a, double ac_a, double cv, double sv, 
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

    public double getEv_a() {
        return ev_a;
    }

    public void setEv_a(double ev_a) {
        this.ev_a = ev_a;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public double getPv() {
        return pv;
    }

    public void setPv(double pv) {
        this.pv = pv;
    }

    public double getBac() {
        return bac;
    }

    public void setBac(double bac) {
        this.bac = bac;
    }

    public double getEv() {
        return ev;
    }

    public void setEv(double ev) {
        this.ev = ev;
    }

    public double getAc() {
        return ac;
    }

    public void setAc(double ac) {
        this.ac = ac;
    }

    public double getPv_a() {
        return pv_a;
    }

    public void setPv_a(double pv_a) {
        this.pv_a = pv_a;
    }

    public double getAc_a() {
        return ac_a;
    }

    public void setAc_a(double ac_a) {
        this.ac_a = ac_a;
    }

    public double getCv() {
        return cv;
    }

    public void setCv(double cv) {
        this.cv = cv;
    }

    public double getSv() {
        return sv;
    }

    public void setSv(double sv) {
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
