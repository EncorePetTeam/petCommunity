import os.path
import joblib
import pymysql
import xgboost as xgb
import numpy as np
import pandas as pd

# 학습 데이터 읽어 들이기
def getSuveyResult(suvey,user_id):
    pklfile = os.path.dirname(__file__) + "./model/result.pkl"
    xgb_model = xgb.XGBRegressor()
    xgb_model = joblib.load(open(pklfile, 'rb'))

    list = [suvey]
    list = np.array(list)

    res = xgb_model.predict(list)

    con = pymysql.connect(host='localhost', user='petCommunity', password='petCommunity', db="petCommunity",
                          charset='utf8')

    cur = con.cursor()

    sql = "INSERT INTO survey_result (user_id, Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, result) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"
    cur.execute(sql, (user_id, list[0], list[1], list[2], list[3], list[4], list[5], list[6], list[7], list[8], list[9] ,res))
    con.commit()

    return res

# list = [1,1,1,1,1,1,1,1,1,1]
# resres = getSuveyResult(list)
# print(resres)