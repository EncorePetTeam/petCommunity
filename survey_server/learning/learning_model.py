from xgboost import XGBClassifier
import pandas as pd
from sklearn.model_selection import train_test_split
import warnings
import joblib
import pymysql
warnings.filterwarnings('ignore')

def create_model():
    con = pymysql.connect(host='localhost', user='petCommunity', password='petCommunity', db="petCommunity", charset='utf8')

    cur = con.cursor()

    sql = "SELECT f.Q1,f.Q2,f.Q3,f.Q4,f.Q5,f.Q6,f.Q7,f.Q8,f.Q9,f.10,t.result FROM survey_feature as f, survey_target as t inner join on f.sno = t.sno"
    cur.execute(sql)
    rows = cur.fetchall()
    con.close()

    ex = pd.DataFrame(rows,names=range(0,11),dtype=str)
    ex_result = ex[10]
    ex_colums = ex.drop(10,axis=1).astype("float")

    X_train, X_test, y_train, y_test=train_test_split(ex_colums, ex_result, test_size=0.2, random_state=156)

    xgb_wrapper = XGBClassifier()
    xgb_wrapper.fit(X_train, y_train)

    joblib.dump(xgb_wrapper, "../model/freq.pkl") # python 객체 - 모델링된 정보
