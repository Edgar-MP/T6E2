<html>
    <head>
        <title>Tema6Ejercicio2 | Edgar Martínez Palmero</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>TEST</h1>
        <form action="/T6E2/ProcesoPregunta" method="POST">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre"><br><br>
            
            <label for="numPreguntas">¿Cuántas preguntas quieres responder?</label>
            <input type="number" name="numPreguntas" id="numPreguntas" min="1"><br><br>
                
            <label for="pista">Mostrar pistas:</label>
            <input type="checkbox" name="pista" id="pista"><br><br>
            
            <input type="submit" name="enviar" value="COMENZAR">
        </form>
    </body>
</html>
