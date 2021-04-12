from pymongo import MongoClient

#mongodb 접속
# mongo_uri = "mongodb://172.30.1.52:27017"
# client = MongoClient(mongo_uri)
client = MongoClient("172.30.1.52",27017)
print(client.list_database_names())

# 사용할 데이터베이스 접속
db = client["mydb"]

#collection접근
# my_collection = db.exam
my_collection = db["exam"]

#맨 위의 document 한 개만 조회
exam_document = my_collection.find_one()

#전체 목록 확인
print("============================")
list_data = my_collection.find()
for my_doc in list_data:
    print(my_doc)

#name을 기준으로 오름차순 정렬
print("============================")
list_data = my_collection.find().sort("name",1)
for my_doc in list_data:
    print(my_doc)

#조건에 따라 조회하기
print("============================")
my_querry = {"java":{"$gt":90}}
list_data = my_collection.find(my_querry)
for my_doc in list_data:
    print(my_doc)

#조건에 따라 조회하기 - 비교연산
print("============================")
my_querry = {"addr":"인천"}
list_data = my_collection.find(my_querry)
for my_doc in list_data:
    print(my_doc)