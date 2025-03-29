package impresion;

import cola.Cola;
import cola.ColaInterfaz;
import colaPrioridad.ColaPrioridad;
import colaPrioridad.ColaPrioridadInterfaz;

public class Impresora {
    private ColaInterfaz<TrabajoImpresion> colaImpresion;
    private ColaPrioridadInterfaz<TrabajoImpresionPrioridad> colaPrioridadImpresion;
    private TrabajoImpresion trabajoEnCurso;

    public Impresora() {
        this.colaImpresion = new Cola<>();
        this.colaPrioridadImpresion = new ColaPrioridad<>();
        this.trabajoEnCurso = null;
    }

    public void agregarTrabajo(TrabajoImpresion trabajo) {
        this.colaImpresion.encolar(trabajo);
    }

    public void agregarTrabajoPrioridad(TrabajoImpresionPrioridad trabajo) {
        this.colaPrioridadImpresion.insertar(trabajo, trabajo.getPrioridad());
        interrumpirTrabajoEnCurso();
    }

    private void interrumpirTrabajoEnCurso() {
        if (trabajoEnCurso != null) {
            System.out.println("Interrumpiendo trabajo en curso: " + trabajoEnCurso);
            colaImpresion.encolar(trabajoEnCurso);
            trabajoEnCurso = null;
        }
    }

    public void imprimir() {
        while (!colaPrioridadImpresion.estaVacia()) {
            TrabajoImpresionPrioridad trabajo = (TrabajoImpresionPrioridad) colaPrioridadImpresion.eliminar();
            trabajoEnCurso = trabajo;
            System.out.println("Imprimiendo (Prioridad): " + trabajo);
            trabajoEnCurso = null;
        }

        while (!colaImpresion.estaVacia()) {
            TrabajoImpresion trabajo = colaImpresion.desencolar();
            trabajoEnCurso = trabajo;
            System.out.println("Imprimiendo: " + trabajo);
            trabajoEnCurso = null;
        }
    }
}