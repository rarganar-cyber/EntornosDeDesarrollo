# EntornosDeDesarrollo
# Calculadora Java + HTML

Aplicación que resuelve suma, resta, multiplicación y potencias con enteros de hasta 5 dígitos (-99999 a 99999).

## Comandos utilizados (orden cronológico)

1. Crear el repositorio público en GitHub (web), con README.
2. `git clone https://github.com/TU-USUARIO/control-versiones-calculadora.git`: descarga el repositorio.
3. `cd control-versiones-calculadora`: entra a la carpeta.
4. `git remote -v`: comprueba a qué repositorio apunta.
5. `git checkout -b frontend`: crea la rama frontend y se pasa a ella.
6. `git add index.html`: prepara el archivo HTML.
7. `git status`: comprueba qué se va a guardar.
8. `git commit -m "Agrego formulario HTML de la calculadora"`: guarda el cambio.
9. `git push -u origin frontend`: publica la rama en GitHub.
10. `git checkout main`: vuelve a la rama principal.
11. `git checkout -b backend`: crea la rama backend desde main.
12. `git add Calculadora.java`: prepara el archivo Java.
13. `git status`: comprueba qué se va a guardar.
14. `git commit -m "Agrego logica Java de la calculadora"`: guarda el cambio.
15. `git push -u origin backend`: publica la rama en GitHub.
16. `git checkout main`: vuelve a main para unir las ramas.
17. `git merge --no-ff frontend -m "Merge de frontend en main"`: une frontend en main.
18. `git merge --no-ff backend -m "Merge de backend en main"`: une backend en main.
19. `git push origin main`: publica main.
20. `git add README.md`, `git commit -m "Actualizo comentarios del README"`, `git push origin main`: publica este README.

## Cómo ejecutar

```
javac Calculadora.java
java Calculadora
```

Abrir http://localhost:8080 en el navegador. `index.html` y `Calculadora.java` deben estar en la misma carpeta.

## Nota

La potencia usa `Math.pow` (tipo `double`), así que con exponentes muy grandes el resultado puede ser `Infinity`.
