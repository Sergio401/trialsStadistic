package model;

public class Type {
    private static String stringType;
    public static String assignType(int option) {
        switch (option) {
            case 1:
                stringType = "ORDINARIOS - CONTROVERSIAS DE SEGURIDAD SOCIAL - ÚNICA INSTANCIA";
                break;
            case 2:
                stringType = "ORDINARIOS - CONTROVERSIAS CONTRATOS DE TRABAJO - ÚNICA INSTANCIA";
                break;
            case 3:
                stringType = "ORDINARIOS - RECONOCIMIENTO DE HONORARIOS - ÚNICA INSTANCIA";
                break;
            case 4:
                stringType = "ORDINARIOS - OTROS";
                break;
            case 5:
                stringType = "EJECUTIVOS - SEGURIDAD SOCIAL";
                break;
            case 6:
                stringType = "EJECUTIVOS - OBLIGACIONES DERIVADAS DEL CONTRATO DE TRABAJO";
                break;
            case 7:
                stringType = "EJECUTIVOS - COBRO DE APORTES PARAFISCALES";
                break;
            case 8:
                stringType = "EJECUTIVOS - OTROS";
                break;
            case 9:
                stringType = "CONCILIACIÓN EXTRAJUDICIAL";
                break;
            case 10:
                stringType = "OTROS";
                break;
            case 11:
                stringType = "FUERO SINDICAL";
                break;
        }
        return stringType;
    }
}
