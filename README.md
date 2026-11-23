# Calculadora Java + HTML

Suma, resta, multiplicación y potencias con enteros de hasta 5 dígitos (-99999 a 99999).

## Comandos y acciones utilizados (orden cronológico)

1. Crear el repositorio público en GitHub (web), con README.
2. `git clone https://github.com/rarganar-cyber/EntornosDeDesarrollo.git`
3. `git remote -v` y `git branch -a`: comprobar el repositorio y las ramas.
4. `git log --oneline --graph --all`: revisar el historial.
5. En la web de GitHub: renombrar la rama `fronted` a `frontend`.
6. En la web: editar `index.html` en `frontend` y hacer commit.
7. En la web: renombrar `calculadora.java` a `Calculadora.java`, editarlo en `backend` y hacer commit.
8. En la web: Pull request de `frontend` a `main` y merge.
9. En la web: Pull request de `backend` a `main` y merge.
10. En la web: editar este README en `main` y hacer commit.

## Cómo ejecutar

```
javac Calculadora.java
java Calculadora
```

Abrir http://localhost:8080. `index.html` y `Calculadora.java` deben estar en la misma carpeta.
