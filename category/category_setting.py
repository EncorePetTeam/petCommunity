import pymysql

with pymysql.connect(host='localhost', user='petCommunity', password='petCommunity', db="petCommunity",
                     charset='utf8') as conn:
    with conn.cursor() as cursor:
        with open("dogcategory.txt") as f:
            dogs = f.readlines()
            dog_num = "00"
            large_category = "DOG"
            sql = "INSERT INTO pet_category(pet_category_id, large_category, small_category) VALUES(%s, %s, %s)"
            for i in range(len(dogs)):
                small_category_num = ""
                if len(str(i)) == 1:
                    small_category_num = "00" + str(i)
                elif len(str(i)) == 2:
                    small_category_num = "0" + str(i)
                else:
                    small_category_num = "" + str(i)
                category_num = dog_num + small_category_num
                dog = dogs[i].strip()
                cursor.execute(sql, (category_num, large_category, dog))
                conn.commit()

