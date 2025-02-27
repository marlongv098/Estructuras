%% LyX 2.3.7 created this file.  For more info, see http://www.lyx.org/.
%% Do not edit unless you really know what you are doing.
\documentclass[12pt,spanish]{report}
\usepackage[latin1]{inputenc}
\usepackage[letterpaper]{geometry}
\geometry{verbose}
\setcounter{secnumdepth}{3}
\setcounter{tocdepth}{3}
\usepackage{color}
\definecolor{page_backgroundcolor}{rgb}{0.921875, 0.921875, 0.921875}
\pagecolor{page_backgroundcolor}
\usepackage{amsmath}
\usepackage{amssymb}

\makeatletter

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% LyX specific LaTeX commands.
%% Because html converters don't know tabularnewline
\providecommand{\tabularnewline}{\\}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% User specified LaTeX commands.
\usepackage{latexsym}
\usepackage{epsfig}\usepackage{multicol}\usepackage{anysize}\usepackage{graphicx}\usepackage[spanish]{babel}
\parindent=0pt



\DeclareMathOperator{\sen}{sen}
\DeclareMathOperator{\arcsen}{arcsen}
\DeclareMathOperator{\arcsec}{arcsec}
\DeclareMathOperator{\arccot}{arccot} \DeclareMathOperator{\e}{e}
\DeclareMathOperator{\Arctan}{arctan}

%NORMAS
\newcommand{\abs}[1]{\lvert #1 \rvert}
\newcommand{\Abs}[1]{\bigl\lvert #1 \bigr\rvert}
\newcommand{\ABS}[1]{\left\lvert #1 \right\rvert}
\newcommand{\nor}[1]{\lVert #1 \rVert}
\newcommand{\Nor}[1]{\bigl\lVert #1 \bigr\rVert}
\newcommand{\NOR}[1]{\left\lVert#1\right\rVert}

%PRODUCTOS
\newcommand{\pro}[2]{\langle #1,#2 \rangle}
\newcommand{\PRO}[2]{\left\langle #1,#2 \right\rangle}

%LETRAS
\newcommand{\ope}[1]{\mathcal{#1}}
\newcommand{\dl}[1]{\mathbb{#1}}

\makeatother

\usepackage{babel}
\addto\shorthandsspanish{\spanishdeactivate{~<>}}

\begin{document}

\chapter*{Interface Set.}
\begin{center}
\begin{tabular}{|c|c|c|c|}
\hline 
Características & HashSet & LinkedHashSet & TreeSet\tabularnewline
\hline 
\hline 
Permite duplicados & No & No & No\tabularnewline
\hline 
Ordena los elementos & No & Orden de inserción  & Orden alfabetico\tabularnewline
\hline 
Complejidad & O(1) & O(1) & O(log(n))\tabularnewline
\hline 
Permite (null) & Si, 1 valor & Si, 1 valor & No\tabularnewline
\hline 
Estructura & Tabla Hash & Tabla Hash + Lista enlazada & Arbol Rojo - Negro\tabularnewline
\hline 
\end{tabular}
\par\end{center}

\section*{Tabla Hash}

Una tabla hash es una estructura de datos que asocia claves (keys)
con valores (values) mediante una función de hash. Su objetivo es
permitir búsquedas, inserciones y eliminaciones rápidas en tiempo
promedio O(1).

\subsection*{Características Principales}
\begin{itemize}
\item Almacenamiento basado en clave-valor. 
\item Uso de una función hash para calcular la posición de almacenamiento. 
\item Eficiencia alta en búsquedas, inserciones y eliminaciones (O(1) en
promedio). 
\item Puede manejar colisiones mediante técnicas como encadenamiento o direccionamiento
abierto.
\end{itemize}

\subsection*{Cómo Funciona una Tabla Hash}
\begin{itemize}
\item Función Hash: Convierte una clave (key) en un índice de la tabla. 
\item Inserción: El valor se almacena en la posición dada por la función
hash. 
\item Búsqueda: Se usa la clave para calcular la posición y acceder rápidamente
al valor. 
\item Colisiones: Cuando dos claves generan el mismo índice, se maneja con
estrategias como listas enlazadas.
\end{itemize}

\subsection*{Manejo de Colisiones}

Cuando dos claves producen el mismo índice en la tabla hash, se usa
una estrategia para resolverlo.
\begin{itemize}
\item Encadenamiento (Chaining): Se usa una lista enlazada en cada celda
para almacenar múltiples valores.
\item Direccionamiento Abierto (Open Addressing): Se buscan otras posiciones
libres dentro de la tabla.
\end{itemize}
Nota: En Java, HashMap usa encadenamiento para manejar colisiones.

\subsection*{¿Cuándo Usar una Tabla Hash?}
\begin{itemize}
\item Cuando necesitas búsquedas rápidas por clave. 
\item Cuando no importa el orden de los elementos. 
\item Cuando el número de elementos es grande y necesitas eficiencia.
\end{itemize}

\section*{Lista Enlazada}

Una lista enlazada (Linked List) es una estructura de datos lineal
y dinámica donde los elementos (nodos) están conectados mediante punteros
o referencias en lugar de ocupar posiciones contiguas en memoria.
Cada nodo contiene: 
\begin{itemize}
\item Un dato (valor almacenado). 
\item Una referencia al siguiente nodo en la lista.
\end{itemize}

\subsection*{Tipos de Listas Enlazadas }
\begin{itemize}
\item Lista Enlazada Simple (SLL): Cada nodo apunta al siguiente. Se recorre
en una sola dirección. 
\item Lista Doblemente Enlazada (DLL): Cada nodo apunta al siguiente y al
anterior. Se puede recorrer en ambas direcciones. 
\item Lista Circular
\begin{itemize}
\item En la versión simple, el último nodo apunta al primero. 
\item En la versión doble, el primer y el último nodo están conectados en
ambos sentidos.
\end{itemize}
\end{itemize}

\section*{Arbol Rojo-Negro}
\begin{flushleft}
\begin{tabular}{|c|c|c|}
\hline 
Características & BST & Arbol Rojo - Negro\tabularnewline
\hline 
\hline 
Orden & I\textless R\textless D & I\textless R\textless D\tabularnewline
\hline 
Balanceo automático & No & Si\tabularnewline
\hline 
Complejidad & O(N) peor caso (Totalmente desbalanceado) & O(log(n))\tabularnewline
\hline 
Coloración nodos & No usa & Nodo, Rojo -Negro\tabularnewline
\hline 
Uso en java & TreeSet o TreeMap. No. & TreeSet o TreeMap, Si.\tabularnewline
\hline 
\end{tabular}
\par\end{flushleft}

\subsection*{¿Qué es un Árbol Rojo-Negro?}

Es un árbol binario de búsqueda (BST) balanceado donde cada nodo tiene
un color rojo o negro y sigue estas reglas:
\begin{itemize}
\item Cada nodo es rojo o negro. 
\item La raíz siempre es negra. 
\item Un nodo rojo no puede tener un hijo rojo (no hay nodos rojos consecutivos). 
\item Cada camino desde la raíz hasta una hoja tiene el mismo número de
nodos negros (propiedad de balanceo). 
\item Si un nodo es rojo, sus hijos deben ser negros.
\item Un nodo negro puede tener hijos negros.
\end{itemize}
Estas reglas garantizan que el árbol esté siempre balanceado, manteniendo
la altura en O(log N), lo que lo hace más eficiente que un BST simple.

\subsection*{¿Cuándo usar un Árbol Rojo-Negro?}
\begin{itemize}
\item Cuando necesitas búsquedas, inserciones y eliminaciones rápidas (O(log
N)). 
\item Cuando el orden es importante (como en TreeSet y TreeMap). 
\item Cuando quieres evitar que un BST se desbalancee.
\end{itemize}

\subsection*{Conclusión}

Permitir que un nodo negro tenga hijos negros ayuda a: 
\begin{itemize}
\item Mantener la propiedad de balanceo del árbol rojo-negro. 
\item Evitar que la altura crezca demasiado, garantizando O(log N).
\item Reducir la necesidad de demasiadas rotaciones y recoloreos.
\end{itemize}
En resumen, un nodo negro puede tener hijos negros porque es una estrategia
clave para el balanceo del árbol y su eficiencia.
\end{document}
