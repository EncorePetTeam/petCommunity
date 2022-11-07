from flask import Flask
from survey_columns import get_survey_columns
from flask_cors import CORS

app = Flask(__name__)
app.config["JSON_AS_ASCII"] = False
CORS(app, resources={r'*': {'origins': 'http://localhost:3000'}})

@app.route("/getsurvey")
def get_survey():
    return get_survey_columns()

@app.route('/')
def home():
    return 'Hello, World!'

if __name__ == '__main__':
    app.run(debug=True)