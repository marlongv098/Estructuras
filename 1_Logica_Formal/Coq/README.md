# Introducción

Coq es un asistente de pruebas formales que permite escribir definiciones matemáticas, desarrollar teoremas y verificar demostraciones de manera asistida por computadora. Utiliza un lenguaje funcional basado en el cálculo de construcciones, que combina programación y lógica en un mismo entorno.

A diferencia de los métodos tradicionales de verificación manual, Coq permite comprobar de forma automática y precisa la validez lógica de los razonamientos, ofreciendo una herramienta poderosa para el desarrollo de matemáticas formales y software verificado.

## Objetivos

* Introducir el entorno y lenguaje básico de Coq.
* Utilizar tácticas para construir demostraciones paso a paso.
* Comprender cómo se representan proposiciones y pruebas en un entorno formal.
* Aplicar Coq para formalizar propiedades de estructuras discretas y razonamientos lógicos.

## Usos

* Verificación formal de propiedades matemáticas, algoritmos y estructuras de datos.
* Desarrollo de software verificado en áreas como sistemas críticos o criptografía.
* Enseñanza de lógica matemática y fundamentos de pruebas formales.
* Apoyo en la investigación en teoría de tipos, matemáticas constructivas y semántica formal.

## Instalación

* **Opción local**: instalar [Coq Platform](https://coq.inria.fr/download) (incluye CoqIDE). En macOS también se puede instalar por `opam`: `opam install coq`.
* **Opción sin instalación**: [Try Coq](https://coq.vercel.app/) o [jsCoq](https://jscoq.github.io/) en el navegador, útil para practicar sin configurar el entorno localmente.

## Estructura básica de un archivo `.v`

Un desarrollo en Coq se compone de tres partes: **definiciones** (`Definition`, `Fixpoint`), **enunciados** (`Theorem`/`Lemma`) y **demostraciones** construidas con **tácticas**, cerradas con `Qed`.

```coq
(* Definición de una función simple *)
Definition doble (n : nat) : nat := n + n.

(* Enunciado: el doble de n es par *)
Theorem doble_es_par : forall n : nat, exists k, doble n = 2 * k.
Proof.
  intro n.            (* introduce la variable universalmente cuantificada *)
  exists n.            (* testigo del existencial: k = n *)
  unfold doble.        (* despliega la definición *)
  ring.                (* resuelve la igualdad aritmética n + n = 2 * n *)
Qed.
```

### Tácticas más usadas

| Táctica | Para qué sirve |
|---|---|
| `intro` / `intros` | Introduce hipótesis y variables cuantificadas universalmente |
| `apply` | Aplica un teorema o hipótesis ya probado |
| `rewrite` | Reescribe usando una igualdad o equivalencia |
| `simpl` | Simplifica la expresión según las definiciones |
| `induction n` | Aplica inducción matemática sobre `n` |
| `destruct` | Analiza por casos una estructura (p. ej. `nat`, `bool`, listas) |
| `reflexivity` | Cierra una meta de la forma `a = a` |
| `Qed` | Cierra y guarda la demostración terminada |

### Ejemplo de inducción (conexión directa con `1_Logica_Formal/README.md`)

```coq
Theorem suma_n : forall n : nat, 2 * (fix suma m := match m with
  | 0 => 0
  | S k => m + suma k
  end) n = n * (n + 1).
Proof.
  induction n as [| k IH].
  - reflexivity.                 (* caso base *)
  - simpl. rewrite IH. ring.     (* paso inductivo, usando la hipótesis IH *)
Qed.
```

Este es el mismo teorema (suma de los primeros n naturales) que se demuestra "a mano" por inducción en la sección de métodos de demostración del README principal de lógica formal — aquí Coq verifica mecánicamente cada paso.

## Cómo ejecutar

```bash
coqc archivo.v        # compila y verifica el archivo completo
coqtop                # REPL interactivo para ir probando paso a paso
```

Dentro de CoqIDE o VS Code (con la extensión VsCoq), se puede avanzar la prueba línea por línea y ver el estado de las hipótesis y la meta actual, lo que facilita mucho el aprendizaje frente a compilar el archivo completo de una vez.
