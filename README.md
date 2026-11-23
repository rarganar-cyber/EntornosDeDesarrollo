# Calculadora Java + HTML

Aplicación que resuelve suma, resta, multiplicación y potencias con números enteros de hasta 5 dígitos (-99999 a 99999). El frontend es un formulario HTML (`index.html`) y el backend un servidor Java (`Calculadora.java`).

## Cómo publicar un repositorio en GitHub

**Opción A (la utilizada): crear el repositorio en la web y clonarlo**
1. En github.com: botón **New repository**, ponerle nombre, marcarlo **Public** y tildar **Add a README file** (crea el commit inicial).
2. `git clone <URL>`: descarga una copia local.
3. Trabajar en la copia y subir los cambios con `git add`, `git commit` y `git push`.

**Opción B: desde una carpeta local**
1. `git init`: convierte la carpeta en un repositorio.
2. `git add <archivos>`: prepara los archivos.
3. `git commit -m "mensaje"`: guarda una versión.
4. `git branch -M main`: nombra la rama principal.
5. `git remote add origin <URL>`: vincula la carpeta con el repositorio de GitHub.
6. `git push -u origin main`: sube el contenido.

## Comandos utilizados (orden cronológico, terminal cmd de Windows)

1. **Crear el repositorio en GitHub (web)**: público, con README.
2. `git clone https://github.com/rarganar-cyber/EntornosDeDesarrollo.git`: descarga el repositorio.
3. `cd EntornosDeDesarrollo`: entra en la carpeta del proyecto.
4. `git remote -v`: muestra la URL del repositorio remoto (`origin`).
5. `git branch -a`: lista las ramas locales y remotas (ya existían `backend` y `fronted`).
6. `git checkout -b frontend`: crea la rama `frontend` y cambia a ella.
7. `Copy-Item` / `copy`: intento de copiar `index.html` y `Calculadora.java` desde otra carpeta. Falló (comando de PowerShell en cmd y ruta inexistente), por lo que luego se editaron los archivos directamente en el repositorio.
8. `git add index.html`: prepara el archivo para el commit.
9. `git status`: muestra el estado de los archivos (modificados, preparados, sin seguimiento).
10. `git commit -m "mensaje"`: guarda los cambios preparados.
11. `git push -u origin frontend`: sube la rama a GitHub. **Falló con error 403** porque Git usaba las credenciales de otra cuenta de GitHub.
12. `git checkout main`: vuelve a la rama principal.
13. `git checkout -b backend`: crea la rama `backend`.
14. `git add Calculadora.java`, `git status`, `git commit -m "mensaje"`, `git push -u origin backend`: mismo proceso para el backend (el `push` volvió a fallar con 403).
15. `git merge --no-ff frontend -m "Merge de frontend en main"` y `git merge --no-ff backend -m "Merge de backend en main"`: unen cada rama en `main` creando un commit de merge visible.
16. `git push origin main`: intento de subir `main` (error 403).
17. `git branch -d frontend` y `git branch -d backend`: borran las ramas locales vacías para rehacerlas.
18. `git log --oneline --graph --all`: muestra el historial de commits y ramas en forma de grafo.
19. `git ls-tree -r --name-only origin/fronted`: lista los archivos de una rama remota sin cambiarse a ella.
20. `git fetch origin`: actualiza la información de las ramas remotas.
21. `git checkout -b frontend origin/fronted`: crea la rama local `frontend` a partir de la remota `fronted`.
22. `notepad index.html`: abre el archivo para editarlo.
23. `git push origin --delete fronted`: intento de borrar la rama remota con el nombre mal escrito (error 403).
24. `git checkout backend`: cambia a la rama `backend`.
25. `git mv calculadora.java tmp.java` y `git mv tmp.java Calculadora.java`: renombran el archivo (en dos pasos porque Windows no distingue mayúsculas) para que coincida con el nombre de la clase Java.
26. `notepad Calculadora.java` y `notepad README.md`: edición de los archivos.
27. `git checkout main`: vuelve a `main` para unir las ramas.

## Acciones realizadas desde la web de GitHub

Como el `push` desde la terminal fallaba con el error 403, los cambios se subieron desde la interfaz web:
1. Renombrar la rama `fronted` a `frontend` (Branches, icono del lápiz).
2. Editar `index.html` en la rama `frontend` y hacer commit.
3. Renombrar `calculadora.java` a `Calculadora.java`, editarlo en la rama `backend` y hacer commit.
4. Crear un Pull Request de `frontend` a `main` y hacer el merge.
5. Crear un Pull Request de `backend` a `main` y hacer el merge.
6. Editar este `README.md` en `main` y hacer commit.

## Estructura de ramas

- `main`: solo commits de actualización de comentarios (README) y los merges.
- `frontend`: solo commits de archivos `.html`.
- `backend`: solo commits de archivos `.java`.

## Cómo ejecutar

```
javac Calculadora.java
java Calculadora
```

Abrir http://localhost:8080. `index.html` y `Calculadora.java` deben estar en la misma carpeta.

## Nota

La potencia usa `Math.pow` (tipo `double`), por lo que con exponentes muy grandes el resultado puede ser `Infinity`.
