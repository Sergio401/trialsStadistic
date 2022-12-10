package model;

public class Type {

    private static String type;

    public static String assignType(int option) {
        switch (option) {
            case 1:
                type = "ORDINARIOS - CONTROVERSIAS DE SEGURIDAD SOCIAL - ÚNICA INSTANCIA";
                break;
            case 2:
                type = "ORDINARIOS - CONTROVERSIAS CONTRATOS DE TRABAJO - ÚNICA INSTANCIA";
                break;
            case 3:
                type = "ORDINARIOS - RECONOCIMIENTO DE HONORARIOS - ÚNICA INSTANCIA";
                break;
            case 4:
                type = "ORDINARIOS - OTROS";
                break;
            case 5:
                type = "EJECUTIVOS - SEGURIDAD SOCIAL";
                break;
            case 6:
                type = "EJECUTIVOS - OBLIGACIONES DERIVADAS DEL CONTRATO DE TRABAJO";
                break;
            case 7:
                type = "EJECUTIVOS - COBRO DE APORTES PARAFISCALES";
                break;
            case 8:
                type = "EJECUTIVOS - OTROS";
                break;
            case 9:
                type = "CONCILIACIÓN EXTRAJUDICIAL";
                break;
            case 10:
                type = "OTROS";
                break;
            case 11:
                type = "FUERO SINDICAL";
                break;
        }
        return type;
    }
}
