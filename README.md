# 📘 **Análisis de Calidad de Software – `UserManager`**

**Nombre del estudiante:** Indira Maia Obando Ramirez  
**Fecha de entrega:** 02/05/2025  
**Curso:** Programación / Calidad de Software  
**Profesor:** Erick Granados  

---

## 🎯 **Objetivo del ejercicio**

Este ejercicio tiene como propósito analizar un fragmento de código en Java para identificar problemas relacionados con la calidad del software. A través de este análisis, se busca proponer mejoras que optimicen la legibilidad, mantenibilidad, escalabilidad y robustez del código, aplicando buenas prácticas de desarrollo y diseño.

---

## 🧾 **Código original analizado**

El fragmento de código original que se analiza en este ejercicio es el siguiente:

```java
public class UserManager {
    public static String[] users = new String[10];
    public static int userCount = 0;
    
    public static boolean a(String u) {
        if(u != null && u.length() > 0) {
            if(userCount < 10) {
                users[userCount] = u;
                userCount++;
                System.out.println("User added: " + u);
                return true;
            } else {
                System.out.println("Error");
                return false;
            }
        } else {
            return false;
        }
    }
    
    public static void p() {
        for(int i=0; i<userCount; i++)
            System.out.println(users[i]);
    }
}
---

Problemas de calidad identificados
Durante el análisis del código, se identificaron varios problemas de calidad que afectan tanto la legibilidad como la escalabilidad y robustez del código. A continuación, se detallan los problemas, su impacto y las soluciones propuestas:
### 🔍 Problemas de calidad identificados

| Nº  | Problema                            | Descripción                                                                 | Impacto                                                              | Solución Propuesta                                                      |
|:--:|-------------------------------------|-----------------------------------------------------------------------------|----------------------------------------------------------------------|--------------------------------------------------------------------------|
| 1  | **Nombres de métodos poco claros**  | Los métodos `a()` y `p()` no indican su funcionalidad.                      | Dificulta la comprensión del código.                                 | Usar nombres descriptivos como `addUser()` y `printUsers()`.            |
| 2  | **Variables estáticas**             | `users` y `userCount` son estáticos, generando estado global.              | Impide reutilizar la clase con otros conjuntos de usuarios.          | Utilizar atributos de instancia.                                        |
| 3  | **Tamaño fijo en el arreglo**       | El arreglo `String[] users` tiene un tamaño limitado a 10 elementos.       | Limita la escalabilidad del sistema.                                 | Usar `ArrayList<String>` para permitir crecimiento dinámico.            |
| 4  | **Mensajes de error vagos**         | Se utiliza "Error" sin detalles específicos.                               | No permite identificar claramente los fallos.                        | Mostrar mensajes claros o usar excepciones.                             |
| 5  | **Lógica mezclada con presentación**| Se usan `System.out.println()` directamente en la lógica del programa.     | Viola el principio de responsabilidad única (SRP).                   | Separar la lógica de negocio de la presentación o encapsularla mejor.   |

---

Código mejorado
A continuación, se presenta el código optimizado que implementa las soluciones propuestas para mejorar la calidad del software:

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<String> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public boolean addUser(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Error: El nombre de usuario no puede estar vacío.");
            return false;
        }

        users.add(username);
        System.out.println("Usuario agregado: " + username);
        return true;
    }

    public List<String> getUsers() {
        return new ArrayList<>(users); // Devolver una copia segura
    }

    public void printUsers() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Lista de usuarios:");
            for (String user : users) {
                System.out.println("- " + user);
            }
        }
    }
}

---

Cambios realizados:

Métodos con nombres descriptivos: Se cambió el nombre de los métodos a() y p() por addUser() y printUsers(), respectivamente, para hacerlos más claros.

Uso de ArrayList: Se reemplazó el arreglo fijo por una ArrayList<String>, lo que permite manejar un número dinámico de usuarios.

Mejora en los mensajes de error: Los mensajes de error ahora son más informativos y claros.

Separación de la lógica de presentación: La lógica de agregar y mostrar usuarios se mantiene separada de la presentación (en este caso, los System.out.println() siguen siendo necesarios para la interacción, pero la lógica está mejor organizada).

---
Conclusión
Con las mejoras implementadas, el código:

Es más legible gracias a los nombres descriptivos de métodos y la estructura organizada.

Utiliza estructuras dinámicas como ArrayList, lo que hace que el código sea más escalable.

Separa la lógica de negocio (gestión de usuarios) de la presentación (mensajes por consola), cumpliendo con el principio de responsabilidad única.

Proporciona mensajes de error más claros y útiles, lo que facilita la depuración y comprensión del comportamiento del código.

Este ejercicio ha sido muy útil para entender cómo aplicar buenas prácticas de desarrollo de software para mejorar la calidad del código, desde el diseño hasta la implementación.