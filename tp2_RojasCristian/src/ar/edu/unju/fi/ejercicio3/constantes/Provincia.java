package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(673307, 53219),
    SALTA(1448120, 155488),
    TUCUMAN(1698627, 22524),
    CATAMARCA(373823, 102606),
    LA_RIOJA(331847, 89680),
    SANTIAGO_DEL_ESTERO(874006, 136351);
	
	private int poblacion;
    private int superficie;
    
    private Provincia(int poblacion, int superficie) {
        this.poblacion = poblacion;
        this.superficie = superficie;
    }
    
    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double calcularDensidadPoblacional() {
        return (double) poblacion / superficie;
    }
}
