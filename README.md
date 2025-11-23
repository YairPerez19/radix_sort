# ⚡ Radix Sort Implementation in Java

> Implementación del algoritmo de ordenación **Radix Sort** en Java. Este programa lee números enteros de un archivo, los ordena eficientemente sin comparaciones directas y escribe el resultado en otro archivo.

## 📋 Tabla de Contenidos

* [¿Qué es Radix Sort?](#-qué-es-radix-sort)
* [Instrucciones de Uso](#-instrucciones-de-uso)
* [Prueba de Radix Sort (Ejemplo)](#-prueba-de-radix-sort-ejemplo)

---

## 🧠 ¿Qué es Radix Sort?

**Radix Sort** (Ordenación por Raíces) es un algoritmo de ordenación lineal, no basado en comparaciones. En lugar de comparar valores, ordena los números examinando y agrupando sus **dígitos** de forma iterativa, ya sea de derecha a izquierda (LSD, *Least Significant Digit*) o de izquierda a derecha (MSD, *Most Significant Digit*).

Esta implementación utiliza el enfoque **LSD (Dígito Menos Significativo)**, lo que significa que el arreglo se ordena repetidamente por cada dígito, comenzando por las unidades, luego las decenas, las centenas, y así sucesivamente.

### Funcionamiento Clave

Radix Sort se apoya en un algoritmo auxiliar, en este caso, **Counting Sort**, para ordenar los números por cada posición de dígito (`exp`).

1.  **Encontrar el Máximo (`getMax`):** Se determina el número más grande para saber cuántos dígitos tiene y cuántas pasadas son necesarias.
2.  **Iteración por Dígito:** El proceso se repite para $exp = 1, 10, 100, 1000, \dots$ hasta que todos los dígitos han sido considerados.
3.  **Ordenación por Conteo (`countSort`):** En cada pasada (para un valor específico de `exp`), se utiliza Counting Sort para ordenar el arreglo basándose únicamente en el dígito actual (calculado como `(arr[i] / exp) % 10`). 

| Característica | Detalle |
| :--- | :--- |
| **Tiempo (Asintótico)** | $O(d \cdot (n + k))$ |
| **Explicación** | Donde $n$ es el número de elementos, $d$ es el número máximo de dígitos, y $k$ es la base (típicamente 10). |
| **Tipo** | Estable (mantiene el orden relativo de elementos iguales). |

---

## 🛠️ Instrucciones de Uso

Esta aplicación en Java lee un archivo de texto con números separados por comas, los ordena usando Radix Sort y escribe el resultado en un archivo de salida.

### Requisitos

Necesitas tener instalado el **Java Development Kit (JDK 8 o superior)** para compilar y ejecutar el código.

### 1. Preparar el Archivo de Entrada

El programa espera que exista un archivo llamado `entrada_radixsort.txt` en el mismo directorio donde se ejecute el código.

* **Nombre del Archivo:** `entrada_radixsort.txt`
* **Formato:** Una línea de números enteros separados por comas.

**Ejemplo de contenido para `entrada_radixsort.txt`:**