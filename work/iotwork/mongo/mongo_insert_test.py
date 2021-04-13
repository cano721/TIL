from pymongo import MongoClient

#mongodb 접속
# mongo_uri = "mongodb://172.30.1.52:27017"
# client = MongoClient(mongo_uri)
client = MongoClient("172.30.1.52",27017)
print(client.list_database_names())

# 사용할 데이터베이스 접속
# db = client.mydb
db = client["mydb"]
# print(db.list_collection_names())
#
#collection접근
# my_collection = db.exam
my_collection = db["exam"]
# print(my_collection.name)
#
# #CRUD메소드 테스트
# result = my_collection.find_one()
# print(result)

# result = my_collection.insert_one({"name":"장동건","age":40,
#                                    "subject":["java","python"]})
my_data = [
    {"name":"이민호","age":40,"subject":["java","python"]},
    {"name":"김어준","age":40,"subject":["raspberry","python"]},
    {"name":"김서연","age":40,"subject":["java","python"]},
]

result = my_collection.insert_many(my_data)

print(result)