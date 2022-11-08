from flask import Flask, request
from survey_columns import get_survey_columns
from flask_cors import CORS
from suvey import getSuveyResult

app = Flask(__name__)
app.config["JSON_AS_ASCII"] = False
CORS(app, resources={r'*': {'origins': 'http://localhost:3000'}})

@app.route("/getsurvey")
def get_survey():
    return get_survey_columns()

@app.route('/')
def home():
    return 'Hello, World!'

@app.route("/get-survey-result",methods='POST')
def get_survey_result():
    user_id = request.form["userId"]
    array = request.form["survey"]
    return getSuveyResult(array,user_id)

if __name__ == '__main__':
    app.run(debug=True)