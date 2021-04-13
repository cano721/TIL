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

result = my_collection.remove({"java":{"$gt":90}})
print(result)