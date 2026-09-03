# Tipo Abstracto de Datos

### ¿Qué es un Tipo Abstracto de Datos (TAD)?

* Es la conjunción de variables, operaciones y aserciones que modela un dominio de datos.

### ¿Cuál es la diferencia entre TAD y tipo de dato?

- A diferencia de un tipo de dato, un TAD es especificado de forma precisa.
- Diseñado independiente de cualquier implementación.

---

### ¿Por qué nace la noción de TAD?

- Los lenguajes de programación traen de forma nativa un conjunto de tipos que son útiles pero insuficientes para resolver todo tipo de problemas.
  - Si se quisiera tomar los datos de todos los empleados de una empresa y realizar consultas y reportes, resultaría ineficiente crear una variable para cada dato de cada empleado.

---

### ¿Cuáles son sus características esenciales?

- Independiente de un lenguaje.
- Descriptivo.
- Ajustado a las necesidades del diseñador.
  - Por ello no es raro encontrar diferentes definiciones de listas, colas, árboles, etc.

---

### ¿Cuáles son los componentes comunes de un TAD?

- **Estructura del TAD** (representación).
- **Colección de operaciones**.
- **Conjunto de axiomas** (para el TAD y cada una de las operaciones).

---

### ¿Cómo se especifica un TAD de manera formal?

[Especificación formal del TAD](Images/tad.pdf)

---

### ¿Cuáles son los elementos de esta especificación formal?

- **Nombre**  
  - Único y que lo identifique plenamente.
- **Objeto abstracto**  
  - Representado de manera matemática o gráfica.
  - Puede usarse para referenciarse en formalismos y notaciones de operaciones.
- **Invariante**  
  - Serie de condiciones que no varían nunca al interior del TAD.

---

### Listado de operaciones

- Aquellas operaciones que pueden realizarse con los objetos del tipo del TAD.
- Se especifican con las entradas y la salida que retornará el proceso.
- Adicionalmente, para cada una de las operaciones se debe escribir su comportamiento a manera de aserciones.
  - **Precondición**: lo que se debe cumplir antes de ejecutar la operación.
  - **Poscondición**: cómo queda el sistema después de terminar el proceso.

---

### ¿Cómo se describen formalmente las operaciones?

[Descripción formal de las operaciones](Images/tad1.pdf)

---

### ¿Por qué las precondiciones y poscondiciones deben definirse formalmente?

- El formalismo describe el propósito de la operación sin ambigüedades y con exactitud.
- La formalidad acerca el diseño a la implementación (entre más formal sea el diseño del TAD, más fácil será concretizarlo en un lenguaje de programación).

---

### Ejemplo: TAD **Empleado**

- Una compañía tiene la información de Nombre, Foto, Documento de identidad, Cargo y Salario por cada empleado.
- Usar una variable por cada dato o empleado sería ineficiente.
- Una forma eficiente es crear un **tipo de dato Empleado** para guardar la información.
- El objeto abstracto de este nuevo tipo de dato podría verse como un carné donde se encuentra la información del empleado.
- La **invariante del TAD** es una propiedad que hace respetar la ley de que ninguna persona puede ganar un salario menor al salario mínimo mensual vigente.

---

### Primera aproximación al TAD Empleado

[Primera aproximación](Images/tad2.pdf)

#### Operaciones formales:
- **CrearEmpleado**  
  [Empleado](Images/tad3.pdf)
- **AgregarNombre**  
  [AgregarNombre](Images/tad4.pdf)
- **AgregarCedula**  
  [AgregarCedula](Images/tad5.pdf)
- **CambiarSalario**  
  [CambiarSalario](Images/tad6.pdf)
- **CambiarCargo**  
  [CambiarCargo](Images/tad7.pdf)
- **CambiarFoto**  
  [CambiarFoto](Images/tad8.pdf)
- **InfoSalario**  
  [InfoSalario](Images/tad9.pdf)
- **InfoCargo**  
  [InfoCargo](Images/tad10.pdf)
- **TieneFoto**  
  [TieneFoto](Images/tad11.pdf)

---

### Problema con la primera aproximación al TAD Empleado

- Debido a que el objeto abstracto es una imagen, resulta incómoda su traducción a un lenguaje de programación.
- Al definir el objeto abstracto como una **tupla**, su traducción a la mayoría de lenguajes de programación sería más directa.

---

### Segunda aproximación al TAD Empleado

[Segunda aproximación](Images/tad12.pdf)

#### Operaciones formales:
- **CrearEmpleado**  
[CrearEmpleado](Images/tad13.pdf)
- **AgregarNombre**  
[AgregarNombre](Images/tad14.pdf)
- **AgregarCedula**  
[AgregarCedula](Images/tad15.pdf)
- **CambiarSalario**  
[CambiarSalario](Images/tad16.pdf)
- **CambiarCargo**  
[CambiarCargo](Images/tad17.pdf)
- **CambiarFoto**  
[CambiarFoto](Images/tad18.pdf)
- **InfoSalario**  
[InfoSalario](Images/tad19.pdf)
- **InfoCargo**  
[InfoCargo](Images/tad20.pdf)
- **TieneFoto**  
[TieneFoto](Images/tad21.pdf)

---

### ¿En qué se dividen las operaciones primitivas de un TAD?

- **Principales**
  - **Constructoras**: crean una instancia nueva del TAD (p. ej. `CrearEmpleado`). Toda especificación de TAD necesita al menos una.
  - **Modificadoras**: cambian el estado interno de una instancia ya creada, respetando la invariante (p. ej. `CambiarSalario`, `CambiarCargo`).
  - **Analizadoras** (u observadoras): consultan información sin modificar el estado (p. ej. `InfoSalario`, `TieneFoto`). Deben ser "puras": mismo estado de entrada, misma salida.
- **Secundarias**
  - **Destructoras**: liberan o invalidan una instancia (en lenguajes con recolector de basura como Java suelen ser implícitas, pero siguen siendo parte de la especificación formal).
  - **Persistencia**: operaciones para guardar/recuperar el estado del TAD más allá de la ejecución del programa (serialización a archivo, base de datos, etc.).

---

### De la especificación formal a Java: TAD Empleado (segunda aproximación)

Traduciendo la representación como tupla (Nombre, Foto, Documento, Cargo, Salario) y sus operaciones formales a una clase Java, respetando la invariante de salario mínimo:

```java
public class Empleado {
    private static final double SALARIO_MINIMO = 1_300_000.0; // ejemplo de invariante

    private String nombre;
    private byte[] foto;
    private String documentoIdentidad;
    private String cargo;
    private double salario;

    // Constructora: equivalente a CrearEmpleado
    public Empleado(String nombre, String documentoIdentidad, String cargo, double salario) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.cargo = cargo;
        cambiarSalario(salario); // reutiliza la validación de la invariante
    }

    // Modificadora: equivalente a CambiarSalario. La invariante se verifica AQUÍ,
    // en el único punto de entrada que cambia el salario, no en cada lugar que lo usa.
    public void cambiarSalario(double nuevoSalario) {
        if (nuevoSalario < SALARIO_MINIMO) {
            throw new IllegalArgumentException("El salario no puede ser menor al mínimo legal");
        }
        this.salario = nuevoSalario;
    }

    public void cambiarCargo(String nuevoCargo) { this.cargo = nuevoCargo; }
    public void cambiarFoto(byte[] nuevaFoto) { this.foto = nuevaFoto; }

    // Analizadoras: equivalentes a InfoSalario, InfoCargo, TieneFoto
    public double infoSalario() { return salario; }
    public String infoCargo() { return cargo; }
    public boolean tieneFoto() { return foto != null; }
}
```

Nótese cómo cada método formal (`CrearEmpleado`, `CambiarSalario`, ...) de las imágenes de especificación anteriores corresponde exactamente a un método público, y la **invariante** ("ningún salario por debajo del mínimo") se hace cumplir centralizándola en `cambiarSalario`, el único punto de modificación de ese campo — así es imposible dejar el objeto en un estado inválido desde fuera de la clase.

---

## Ejercicios

### Diseñe un Tipo Abstracto de Dato para:
- Números racionales
- Curso
