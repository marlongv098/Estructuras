# Introducción a Coq

## Funciones y parámetros

- En Coq se utiliza la noción de función de modo más formal que en otros lenguajes.
- Estamos acostumbrados a tener funciones que toman varios parámetros, como `int suma(int a, b).`
- En Coq las funciones toman un parámetro y devuelven un parámetro.
- Estas funciones se trabajan mediante el uso de funciones parciales y la técnica denominada "currying".
- Una función como suma, en Coq, toma un número natural, devuelve una función que toma un sólo número natural, le suma el anterior, y devuelve el resultado, que es otro natural.
- A las funciones que toman o devuelven otras funciones como parámetros se las denomina funciones de orden superior.
- Simplemente, `add` es una función que, a efectos prácticos, toma dos naturales y nos devuelve otro, mediante una función intermedia de orden superior.

## Ejemplo sobre el cómputo de funciones

```coq
Compute Nat.add 2 3.
(* = 5 : nat *)
```

## ¿Qué nos presenta el anterior ejemplo?

- `add` se aplica sobre el parámetro `2` y retorna otra función que se aplica sobre `3` para retornarnos el valor `5`.
- Adicionalmente nos indica el tipo del valor de retorno, un natural.

## ¿Pero qué es un tipo en Coq?

- Función de primera clase (se puede tratar como otro valor del lenguaje).
- Se construye de manera inductiva.

## Ejemplo sobre definición inductiva en Coq

```coq
Print nat.
(* Inductive nat : Set := O : nat | S : nat -> nat *)
```

## ¿Qué nos presenta el anterior ejemplo?

- `nat` es un tipo inductivo (perteneciente a `Set` (conjunto)) que se puede formar mediante dos constructores:
  1. `O` que representa el cero.
  2. Una función `S` (función sucesor) que toma un `nat` y devuelve otro `nat`.

## Ejemplo de verificación de tipo de sucesor

```coq
Check S (S (S O)).
(* 3 : nat *)
```

## ¿Qué aprendemos del ejemplo anterior?

- `3` es simplemente azúcar sintáctico para `S (S (S O))`.
- Es la codificación de Peano que vimos previamente.
- Utiliza un sólo dígito y aunque es poco eficiente permite realizar pruebas inductivas con mayor facilidad.

## Ejemplo de verificación de tipo de `add`

```coq
Print Nat.add.
(*
Nat.add =
fix add (n m : nat) {struct n} : nat :=
  match n with
  | 0 => m
  | S p => S (add p m)
  end
     : nat -> nat -> nat
*)
```

## Explicación de `Nat.add`

- `fix` es un operador para definir funciones recursivas (se llama a sí misma).
- `(n m : nat) {struct n} : nat` indica que toma 2 parámetros, `n` y `m`, de tipo `nat`.
- `struct n` indica que la recursión es estructural en `n`, es decir, que cuando `add` se llama a sí misma, `n` va a ser siempre inferior.
- Esto garantiza que `add` siempre devuelva un resultado en tiempo finito.
- El último `nat` es el tipo del valor de retorno de la función.
- Decimos que toma dos parámetros porque el currying es automático.

## Definiendo funciones recursivas en Coq

### Ejercicio: Definir la función factorial en Coq

```coq
Fixpoint factorial (n:nat) : nat :=
match n with
| O => (S O)
| S p => (S p) * (factorial p)
end.
```

### Ejercicio: Definir la multiplicación de dos números `n` y `m` en Coq

```coq
Fixpoint multiplicar (n m:nat) : nat :=
match n with
| O => O
| S p => m + (multiplicar p m)
end.
```

## Primer ejemplo de demostración en Coq

```coq
Theorem add_0_m: forall m:nat, 0 + m = m.
```

```coq
(* 1 subgoal
   ============================
   forall m : nat, 0 + m = m *)
```

```coq
intros.
(* m : nat
   ============================
   0 + m = m *)
```

```coq
simpl.
(* m : nat
   ============================
   m = m *)
```

```coq
reflexivity.
(* No more subgoals. *)
```

```coq
Qed.
(* intros.
   simpl.
   reflexivity.
   Qed.
   add_0_m is defined *)
```
