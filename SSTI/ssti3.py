from flask import Flask, request, render_template, redirect, render_template_string, session

app = Flask(__name__)
app.secret_key = 'mysecretkey'

@app.route("/", methods=["GET"])
def home():
    global logged_in
    if request.method == "GET":
        username = request.args.get('username')
        password = request.args.get('password')

        if not username:
            return render_template("login.html", error_message=None)
        if username == "admin" and password == "admin123*":
            session['logged_in'] = True
            return render_template("change_username.html")
        else:
            error_message = "Credenciales inválidas. Por favor, intente nuevamente."
            return render_template("login.html", error_message=error_message)

    return render_template("login.html")

@app.route("/main")
def main():
    return "Bienvenido! Has iniciado sesión correctamente."

@app.route("/update_username", methods=["GET"])
def update_username():
    if not session.get('logged_in'):
        return redirect("/")
    new_username = request.args.get('new_username')
    message = "Nombre de usuario actualizado exitosamente a: " + new_username

    return_code = """
    <!-- change_username.html -->
    <!DOCTYPE html>
    <html>
    <head>
        <title>Cambiar nombre de usuario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style>
            body {
                margin-top: 50px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <h1 class="text-center mb-4">Cambiar nombre de usuario</h1>

                        <div class="alert alert-success">""" + message + """</div>

                    <form method="GET" action="/update_username">
                        <div class="form-group">
                            <label for="new_username">Nuevo nombre de usuario:</label>
                            <input type="text" class="form-control" id="new_username" name="new_username">
                        </div>

                        <button type="submit" class="btn btn-primary">Actualizar nombre de usuario</button>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
    </html>
    """

    return render_template_string(return_code)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000)
