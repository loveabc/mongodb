#使用python操作mongodb
#参考文档  https://docs.mongodb.com/ecosystem/drivers/python/
from pymongo import MongoClient
client=MongoClient('127.0.0.1',12345)#连接mongodb
client.stu.authenticate('zhang','zhang')#验证用户名和密码
db=client['stu']#选择要使用的数据库
collection=db['user']#选择要操作的集合
cur=collection.find()#读取该集合的所有数据
for c in cur:#遍历数据
    print(c)
    print(c['name'])
下面两个close()的作用是关闭游标与客户端吗?
cur.close()
client.close()
#接下来就要学习增删改了
