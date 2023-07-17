from flask import Flask, render_template, request
import hashlib

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        codigo = request.form['codigo']
        validar_codigo(codigo)
        return render_template('index.html', error=not validar_codigo(codigo), success=validar_codigo(codigo))

    return render_template('index.html', error=False)

def validar_codigo(codigo):
    correct_hash = 'ea90622fa6e23cf933bfdf5db28473fb'
    input = hashlib.md5(codigo.encode('utf-8')).hexdigest()
    if input == correct_hash:
        return True
    else:
        return False

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=80)
