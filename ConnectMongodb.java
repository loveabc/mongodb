//使用Java连接mongodb并读取数据
		ServerAddress address=new ServerAddress("127.0.0.1",12345);//连接的主机和端口号
		List<ServerAddress> addressList=new ArrayList<ServerAddress>();
		addressList.add(address);
		//验证用户  用户名  数据库  密码
		MongoCredential cred=MongoCredential.createCredential("zhang", "stu", "zhang".toCharArray());
		List<MongoCredential> credList=new ArrayList<MongoCredential>();
		credList.add(cred);
		MongoClient client=new MongoClient(addressList, credList);
		//选择数据
		MongoDatabase db=client.getDatabase("stu");
		MongoCollection<Document> docs=db.getCollection("user");
		FindIterable<Document> it=docs.find();
		MongoCursor<Document> cur=it.iterator();
		while(cur.hasNext()){
			Document doc=cur.next();
			System.out.println(doc.get("_id"));
			System.out.println(doc.getString("name"));
			System.out.println(doc.getString("a"));
			System.out.println(doc);
		}
		//关闭客户端
		client.close();
