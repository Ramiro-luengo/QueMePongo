package Model;

public enum TipoPrenda {
    ZAPATO(Categoria.CALZADO),

    ZAPATILLA(Categoria.CALZADO),

    CAMISA(Categoria.PARTE_SUPERIOR),

    REMERA(Categoria.PARTE_SUPERIOR),

    BLUSA(Categoria.PARTE_SUPERIOR),

    POLLERA(Categoria.PARTE_INFERIOR),

    PANTALON(Categoria.PARTE_INFERIOR),

    SOMBRERO(Categoria.ACCESORIO),

    ANTEOJOS(Categoria.ACCESORIO);

    private Categoria categoria;

    TipoPrenda(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}