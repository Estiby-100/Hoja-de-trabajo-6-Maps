public enum Category {
    MUEBLE_TERRAZA("Mueble de terraza"),
    SILLONES_MASAJE("Sillones de masaje"),
    BEBIDAS("Bebidas"),
    CONDIMENTOS("Condimentos"),
    FRUTAS("Frutas"),
    CARNES("Carnes"),
    LACTEOS("Lácteos");

     private final String nombreCategoria;

    Category(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getnombreCategoria() {
        return nombreCategoria;
    }

    
    public static Category fromString(String text) {
        for (Category c : Category.values()) {
            if (c.nombreCategoria.equalsIgnoreCase(text.trim())) {
                return c;
            }
        }
        throw new IllegalArgumentException("Categoría no reconocida: " + text);
    }
}
    

